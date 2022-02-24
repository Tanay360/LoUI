package com.tanay.loui

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.util.Xml
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
import org.xmlpull.v1.XmlPullParser
import java.lang.reflect.Method
import java.nio.ByteBuffer
import java.nio.ByteOrder

object VectorDrawableCreator {
    private val BIN_XML_STRINGS = arrayOf(
        "width".toByteArray(),
        "height".toByteArray(),
        "viewportWidth".toByteArray(),
        "viewportHeight".toByteArray(),
        "fillColor".toByteArray(),
        "pathData".toByteArray(),
        "path".toByteArray(),
        "vector".toByteArray(),
        "http://schemas.android.com/apk/res/android".toByteArray()
    )
    private val BIN_XML_ATTRS = intArrayOf(
        android.R.attr.height,
        android.R.attr.width,
        android.R.attr.viewportWidth,
        android.R.attr.viewportHeight,
        android.R.attr.fillColor,
        android.R.attr.pathData
    )
    private const val CHUNK_TYPE_XML: Short = 0x0003
    private const val CHUNK_TYPE_STR_POOL: Short = 0x0001
    private const val CHUNK_TYPE_START_TAG: Short = 0x0102
    private const val CHUNK_TYPE_END_TAG: Short = 0x0103
    private const val CHUNK_TYPE_RES_MAP: Short = 0x0180
    private const val VALUE_TYPE_DIMENSION: Short = 0x0500
    private const val VALUE_TYPE_STRING: Short = 0x0300
    private const val VALUE_TYPE_COLOR: Short = 0x1D00
    private const val VALUE_TYPE_FLOAT: Short = 0x0400

    @SuppressLint("DiscouragedPrivateApi")
    fun getVectorDrawable(
        context: Context,
        width: Int, height: Int,
        viewportWidth: Float, viewportHeight: Float,
        paths: List<PathData>
    ): Drawable? {
        val binXml = createBinaryDrawableXml(width, height, viewportWidth, viewportHeight, paths)
        try {
            @SuppressLint("PrivateApi") val xmlBlock = Class.forName("android.content.res.XmlBlock")
            val xmlBlockConstr = xmlBlock.getConstructor(ByteArray::class.java)
            val xmlParserNew: Method = xmlBlock.getDeclaredMethod("newParser")
            xmlBlockConstr.isAccessible = true
            xmlParserNew.isAccessible = true
            val parser = xmlParserNew.invoke(
                xmlBlockConstr.newInstance(binXml as Any)
            ) as XmlPullParser
            return if (Build.VERSION.SDK_INT >= 24) {
                Drawable.createFromXml(context.resources, parser)
            } else {
                val attrs: AttributeSet = Xml.asAttributeSet(parser)
                var type = parser.next()
                while (type != XmlPullParser.START_TAG) {
                    type = parser.next()
                }
                VectorDrawableCompat.createFromXmlInner(context.resources, parser, attrs, null)
            }
        } catch (e: Exception) {
            Log.e(VectorDrawableCreator::class.java.simpleName, "Vector creation failed", e)
        }
        return null
    }

    private fun createBinaryDrawableXml(
        width: Int, height: Int,
        viewportWidth: Float, viewportHeight: Float,
        paths: List<PathData>
    ): ByteArray {
        val stringPool = BIN_XML_STRINGS.toMutableList()
        for (path in paths) {
            stringPool.add(path.data)
        }
        val bb: ByteBuffer = ByteBuffer.allocate(8192)
        bb.order(ByteOrder.LITTLE_ENDIAN)
        var posBefore: Int

        bb.putShort(CHUNK_TYPE_XML)
        bb.putShort(8.toShort())
        val xmlSizePos: Int = bb.position()
        bb.position(bb.position() + 4)

        val spStartPos: Int = bb.position()
        bb.putShort(CHUNK_TYPE_STR_POOL)
        bb.putShort(28.toShort())
        val spSizePos: Int = bb.position()
        bb.position(bb.position() + 4)
        bb.putInt(stringPool.size)
        bb.putInt(0)
        bb.putInt(1 shl 8)
        val spStringsStartPos: Int = bb.position()
        bb.position(bb.position() + 4)
        bb.putInt(0)

        var offset = 0
        for (str in stringPool) {
            bb.putInt(offset)
            offset += str.size + if (str.size > 127) 5 else 3
        }
        posBefore = bb.position()
        bb.putInt(spStringsStartPos, bb.position() - spStartPos)
        bb.position(posBefore)

        for (str in stringPool) {
            if (str.size > 127) {
                val high = (str.size and 0xFF00 or 0x8000 ushr 8).toByte()
                val low = (str.size and 0xFF).toByte()
                bb.put(high)
                bb.put(low)
                bb.put(high)
                bb.put(low)
            } else {
                val len = str.size.toByte()
                bb.put(len)
                bb.put(len)
            }
            bb.put(str)
            bb.put(0.toByte())
        }
        if (bb.position() % 4 != 0) {
            bb.put(ByteArray(4 - bb.position() % 4))
        }

        posBefore = bb.position()
        bb.putInt(spSizePos, bb.position() - spStartPos)
        bb.position(posBefore)

        bb.putShort(CHUNK_TYPE_RES_MAP)
        bb.putShort(8.toShort())
        bb.putInt(8 + BIN_XML_ATTRS.size * 4)
        for (attr in BIN_XML_ATTRS) {
            bb.putInt(attr)
        }

        val vstStartPos: Int = bb.position()
        val vstSizePos = putStartTag(bb, 7, 4)

        putAttribute(bb, 0, -1, VALUE_TYPE_DIMENSION, (width shl 8) + 1)
        putAttribute(bb, 1, -1, VALUE_TYPE_DIMENSION, (height shl 8) + 1)
        putAttribute(bb, 2, -1, VALUE_TYPE_FLOAT, java.lang.Float.floatToRawIntBits(viewportWidth))
        putAttribute(bb, 3, -1, VALUE_TYPE_FLOAT, java.lang.Float.floatToRawIntBits(viewportHeight))

        posBefore = bb.position()
        bb.putInt(vstSizePos, bb.position() - vstStartPos)
        bb.position(posBefore)
        for (i in paths.indices) {
            val pstStartPos: Int = bb.position()
            val pstSizePos = putStartTag(bb, 6, 2)

            putAttribute(bb, 4, -1, VALUE_TYPE_COLOR, paths[i].color)
            putAttribute(bb, 5, 9 + i, VALUE_TYPE_STRING, 9 + i)
            posBefore = bb.position()
            bb.putInt(pstSizePos, bb.position() - pstStartPos)
            bb.position(posBefore)
            putEndTag(bb, 6)
        }

        putEndTag(bb, 7)

        posBefore = bb.position()
        bb.putInt(xmlSizePos, bb.position())
        bb.position(posBefore)

        val binXml = ByteArray(bb.position())
        bb.rewind()
        bb.get(binXml)
        return binXml
    }

    private fun putStartTag(bb: ByteBuffer, name: Int, attributeCount: Int): Int {
        bb.putShort(CHUNK_TYPE_START_TAG)
        bb.putShort(16.toShort())
        val sizePos: Int = bb.position()
        bb.putInt(0)
        bb.putInt(0)
        bb.putInt(-1)
        bb.putInt(-1)
        bb.putInt(name)
        bb.putShort(0x14.toShort())
        bb.putShort(0x14.toShort())
        bb.putShort(attributeCount.toShort())
        bb.putShort(0.toShort())
        bb.putShort(0.toShort())
        bb.putShort(0.toShort())
        return sizePos
    }

    private fun putEndTag(bb: ByteBuffer, name: Int) {
        bb.putShort(CHUNK_TYPE_END_TAG)
        bb.putShort(16.toShort())
        bb.putInt(24)
        bb.putInt(0)
        bb.putInt(-1)
        bb.putInt(-1)
        bb.putInt(name)
    }

    private fun putAttribute(
        bb: ByteBuffer, name: Int,
        rawValue: Int, valueType: Short, valueData: Int
    ) {
        bb.putInt(8)
        bb.putInt(name)
        bb.putInt(rawValue)
        bb.putShort(0x08.toShort())
        bb.putShort(valueType)
        bb.putInt(valueData)
    }

    class PathData(var data: ByteArray, var color: Int) {
        constructor(data: String, color: Int) : this(
            data.toByteArray(),
            color
        )
    }
}

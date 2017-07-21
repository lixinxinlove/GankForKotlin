package com.lxx.gankforkotlin.utils

import android.content.Context
import com.lxx.gankforkotlin.App
import java.io.FileInputStream
import java.io.FileOutputStream


/**
 * Created by android on 2017/7/21.
 */
object FileUtil {

    fun saveVersionToFile() {
        val fileContent = "晶晶"
        val outputStream: FileOutputStream
        try {
            outputStream = App.context!!.openFileOutput("version", Context.MODE_PRIVATE)
            outputStream.write(fileContent.toByteArray())
            outputStream.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun readVersionForFile(): String {
        var text: String
        var fis: FileInputStream?
        fis = App.context!!.openFileInput("version")
        val length = fis.available()
        val buffer = ByteArray(length)
        fis.read(buffer)
        val res = String(buffer)
        fis.close()
        text = res
        return text
    }
}

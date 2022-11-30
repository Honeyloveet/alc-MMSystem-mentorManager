package com.peculiaruc.alc_mmsystem_mentormanager.util

import android.content.Context
import android.graphics.Bitmap
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream

/**
 * this object is used to compress images selected from storage
 * for profile, messages, programs e.t.c before sending the image
 * to the backend to save storage in the server
 */
object CompressUtil {

    /**
     * this function in [imageBitmap] and [context] compresses the
     * imageBitmap and returns imageFile as [File]
     */
    fun compressBitmap(imageBitmap: Bitmap, context: Context): File {
        val imageFile =
            File(context.cacheDir, "${System.currentTimeMillis()}_profile")
        imageFile.createNewFile()

        val byteArrayOutputStream = ByteArrayOutputStream()
        imageBitmap.compress(Bitmap.CompressFormat.JPEG, 75, byteArrayOutputStream)

        val bitmapByteArray = byteArrayOutputStream.toByteArray()

        val fileOutputStream = FileOutputStream(imageFile)
        fileOutputStream.write(bitmapByteArray)
        fileOutputStream.flush()
        fileOutputStream.close()

        return imageFile
    }
}
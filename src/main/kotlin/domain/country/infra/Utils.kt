package domain.country.infra

import ktor.ApplicationContext
import java.awt.image.BufferedImage
import java.io.ByteArrayInputStream
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import javax.imageio.ImageIO

class Utils {
    companion object {
        fun createBase64ToImg(img: String, pid: String): String? {
            val groupExtension = listOf("jpg", "jpeg", "gif", "png")
            val regex = "data:(image/[^;]+);base64,(.+)".toRegex()
            val result = regex.find(img)

            return if (result != null) {
                val type = result.groupValues[1]
                var ext: String = type.split("/")[1]
                val body = result.groupValues[2]

                if (ext !in groupExtension) return null

                try {
                    if (ext == "jpg") ext = "jpeg"

                    val imgBytes = Base64.getDecoder().decode(body)
                    val inputStream = ByteArrayInputStream(imgBytes)
                    val bufferImage: BufferedImage = ImageIO.read(inputStream)

                    val path: String =
                        ApplicationContext.context.environment.config.property("ktor.path.images").getString() + "/$pid"
                    val dir = File(path)

                    // Si el directorio no existe, créalo
                    if (!dir.exists()) {
                        dir.mkdirs()
                    }

                    val nameFile = "${pid}_${SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())}.$ext"
                    val fileImage = File("$path/$nameFile")

                    ImageIO.write(bufferImage, ext, fileImage)
                    return nameFile
                } catch (error: Exception) {
                    error.printStackTrace()
                    return null
                }
            } else null
        }

        fun getNameFileBase64(img: String) {
        }

        fun deleteImage(pid: String, name: String): Boolean {
            try {
                val path =
                    "${ApplicationContext.context.environment.config.property("ktor.path.images").getString()}/$pid"
                val img = File(path, name)
                return if (img.exists()) {
                    img.delete()
                    true
                } else
                    false

            } catch (error: Exception) {
                error.localizedMessage
                return false
            }
        }

        fun createDir(pid: String): Boolean {
            return try {
                val path = ApplicationContext.context.environment.config.property("ktor.path.images").getString()
                val dir = File(path, pid)
                if (!dir.exists()) {
                    dir.mkdirs()
                }
                dir.exists()
            } catch (error: Exception) {
                error.printStackTrace()
                false
            }
        }

        fun deleteDirectory(pid: String): Boolean {
            try {
                val path =
                    ApplicationContext.context.environment.config.property("ktor.path.images").getString() + "/$pid"
                val dir = File(path)
                if (dir.exists()) {
                    return dir.deleteRecursively()
                }
            } catch (error: Exception) {
                error.localizedMessage
                return false
            }
            return false
        }
    }
}
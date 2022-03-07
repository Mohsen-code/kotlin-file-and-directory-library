package mohsen.coder

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.*
import java.io.IOException
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.*
import kotlin.math.floor
import kotlin.math.ln
import kotlin.math.pow
import kotlin.math.round

class File(path: String) : IFile {
    private var filePath: Path
    private val gson = Gson()

    init {
        val currentPath = Paths.get(System.getProperty("user.dir"))
        filePath = Paths.get(currentPath.toString(), path)
    }

    // https://stackoverflow.com/questions/15900485/correct-way-to-convert-size-in-bytes-to-kb-mb-gb-in-javascript
    private fun formatBytes(bytes: Long, decimals: Int = 2): String {
        if (bytes == 0L) return "0 Bytes"

        val k = 1024f
        val dm = if (decimals < 0) 0 else {
            var counter = 10
            repeat(decimals - 1) {
                counter *= 10
            }
            counter
        }
        val sizes = arrayListOf("Bytes", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB")

        val i = floor(ln(bytes.toDouble()) / ln(k))

        val fileSizeInDecimal = round((bytes / k.toDouble().pow(i)) * dm) / dm
        return "$fileSizeInDecimal ${sizes[i.toInt()]}";
    }

    @Throws(IOException::class)
    override fun readFile(): String {
        val file = filePath.toFile()
        if (file.isDirectory) throw Exception("You pass directory path as `file path`")
        if (!file.isFile) throw Exception("File is not valid!")
        file.readLines()
        return file.readText()
    }

    override fun readFileLines(): List<String> {
        val file = filePath.toFile()
        if (file.isDirectory) throw Exception("You pass directory path as `file path`")
        if (!file.isFile) throw Exception("File is not valid!")
        file.readLines()
        return file.readLines()
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun readFileLinesAsync(): Deferred<List<String>> = GlobalScope.async {
        readFileLines()
    }

    @OptIn(DelicateCoroutinesApi::class)
    @Throws(IOException::class)
    override fun readFileAsync() = GlobalScope.async {
        readFile()
    }

    @Throws(IOException::class)
    override fun writeFile(content: String, append: Boolean) {
        val file = filePath.toFile()
        if (file.isDirectory) throw Exception("You pass directory path as `file path`")
        if (!file.isFile) throw Exception("File is not valid!")
        if (append) {
            file.appendText(content)
            return
        }
        file.writeText(content)
    }

    @OptIn(DelicateCoroutinesApi::class)
    @Throws(IOException::class)
    override fun writeFileAsync(content: String, append: Boolean) = GlobalScope.async {
        writeFile(content, append)
    }

    @Throws(IOException::class)
    override fun <T : Any> readJsonFile(): ArrayList<T> {
        if (getFileMeme() != "json") throw IOException("File is not json!")
        val myType = object : TypeToken<ArrayList<Person>>() {}.type
        val arr = gson.fromJson<ArrayList<T>>(readFile(), myType)
        return ArrayList(arr.map { it as T })
    }

    @OptIn(DelicateCoroutinesApi::class)
    @Throws(IOException::class)
    override fun <T : Any> readJsonFileAsync() = GlobalScope.async {
        readJsonFile<T>()
    }

    @Throws(IOException::class)
    override fun <T : Any> writeJsonFile(content: ArrayList<T>) {
        if (getFileMeme() != "json") throw IOException("File is not json!")
        val file = filePath.toFile()
        file.writeText(gson.toJson(content))
    }

    @OptIn(DelicateCoroutinesApi::class)
    @Throws(IOException::class)
    override fun <T : Any> writeJsonFileAsync(content: ArrayList<T>) = GlobalScope.async {
        writeJsonFile(content)
    }

    override fun deleteFile(): Boolean {
        val file = filePath.toFile()
        if (!file.isFile) throw IOException("Can not delete this file!")
        return file.delete()
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun deleteFileAsync() = GlobalScope.async {
        deleteFile()
    }

    override fun createFile() {
        if (!filePath.exists()) {
            val file = filePath.toFile()
            if (getFileMeme() == "json") file.writeText("[]")
            else file.createNewFile()
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun createFileAsync() = GlobalScope.async {
        createFile()
    }

    @Throws(IOException::class)
    override fun renameFile(newName: String): Boolean {
        val newFile = filePath.parent.resolve("${newName}.${getFileMeme()}").toFile()
        if (newFile.exists()) throw IOException("file exist!")
        return filePath.toFile().renameTo(newFile)
    }

    @OptIn(DelicateCoroutinesApi::class)
    @Throws(IOException::class)
    override fun renameFileAsync(newName: String) = GlobalScope.async {
        renameFile(newName)
    }

    override fun getFilePath(): Path {
        return filePath
    }

    override fun getFileName(): String {
        return filePath.name
    }

    override fun getFileSize(): Long {
        return filePath.fileSize()
    }

    override fun getFileSizeString(): String {
        return formatBytes(filePath.fileSize())
    }

    override fun getFileMeme(): String {
        return filePath.extension
    }

    override fun getFilePathString(): String {
        return filePath.absolutePathString()
    }

    override fun isFileExist(): Boolean {
        return filePath.exists()
    }

    override fun toString(): String {
        return filePath.absolutePathString()
    }
}
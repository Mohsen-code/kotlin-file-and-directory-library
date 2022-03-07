package mohsen.coder

import kotlinx.coroutines.Deferred
import java.nio.file.Path

internal interface IFile {
    fun createFile()
    fun createFileAsync(): Deferred<Unit>
    fun readFile(): String
    fun readFileAsync(): Deferred<String>
    fun readFileLines(): List<String>
    fun readFileLinesAsync(): Deferred<List<String>>
    fun writeFile(content: String, append: Boolean)
    fun writeFileAsync(content: String, append: Boolean): Deferred<Unit>
    fun <T: Any> readJsonFile(): ArrayList<T>
    fun <T: Any> readJsonFileAsync(): Deferred<ArrayList<T>>
    fun <T: Any> writeJsonFile(content: ArrayList<T>)
    fun <T: Any> writeJsonFileAsync(content: ArrayList<T>): Deferred<Unit>
    fun renameFile(newName: String): Boolean
    fun renameFileAsync(newName: String): Deferred<Boolean>
    fun deleteFile(): Boolean
    fun deleteFileAsync(): Deferred<Boolean>
    fun getFilePath(): Path
    fun getFileName(): String
    fun getFileSize(): Long
    fun getFileSizeString(): String
    fun getFileMeme(): String
    fun getFilePathString(): String
    fun isFileExist(): Boolean
}
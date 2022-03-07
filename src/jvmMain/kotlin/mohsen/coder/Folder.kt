package mohsen.coder

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.*
import kotlin.math.floor
import kotlin.math.ln
import kotlin.math.pow
import kotlin.math.round

class Folder(path: String) : IFolder {

    private var folderPath: Path

    init {
        val currentPath = Paths.get(System.getProperty("user.dir"))
        folderPath = Paths.get(currentPath.toString(), if (path == "./") "" else path)
        if (!Files.isDirectory(folderPath)) throw IllegalArgumentException("Entered path is not a folder path!")
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

    override fun createFolder(name: String) {
        Files.createDirectory(folderPath.resolve(name))
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun createFolderAsync(name: String): Deferred<Unit> = GlobalScope.async {
        createFolder(name)
    }

    override fun folderContent(): List<String> {
        return folderPath.listDirectoryEntries().map { it.name }.toList()
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun folderContentAsync(): Deferred<List<String>> = GlobalScope.async{
        folderContent()
    }

    override fun removeChildFile(fileName: String): Boolean {
        val file = folderPath.resolve(fileName).toFile()
        return file.delete()
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun removeChildFileAsync(fileName: String): Deferred<Boolean> = GlobalScope.async {
        removeChildFile(fileName)
    }

    override fun removeChildFolder(folderName: String): Boolean {
        val directory = folderPath.resolve(folderName).toFile()
        if (!directory.isDirectory)
            throw IOException("can not remove this folder!")
        return directory.deleteRecursively()
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun removeChildFolderAsync(folderName: String): Deferred<Boolean> = GlobalScope.async {
        removeChildFolder(folderName)
    }

    override fun removeFolder(): Boolean {
        if (!folderPath.isDirectory())
            throw IOException("Can not remove this folder!")
//        folderPath.toFile().walkTopDown().map { it.delete() }
        return folderPath.toFile().deleteRecursively()
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun removeFolderAsync(): Deferred<Boolean> = GlobalScope.async {
        removeFolder()
    }

    override fun renameChildFile(childOldName:String, childNewName: String): Boolean {
        val childFile = folderPath.resolve(childOldName).toFile()
        if (!childFile.isFile) throw IOException("Can not rename this file!")
        return childFile.renameTo(folderPath.resolve("$childNewName.${childFile.extension}").toFile())
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun renameChildFileAsync(childOldName:String, childNewName: String): Deferred<Boolean> = GlobalScope.async {
        renameChildFile(childOldName, childNewName)
    }

    override fun renameChildFolder(childOldName:String, childNewName: String): Boolean {
        val childFile = folderPath.resolve(childOldName).toFile()
        if (!childFile.isDirectory) throw IOException("Can rename this folder!")
        return childFile.renameTo(folderPath.resolve(childNewName).toFile())
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun renameChildFolderAsync(childOldName:String, childNewName: String): Deferred<Boolean> = GlobalScope.async {
        renameChildFolder(childOldName, childNewName)
    }

    override fun renameFolder(newName: String): Boolean {
        if (!folderPath.isDirectory()) throw IOException("Can not rename this folder!")
        return folderPath.toFile().renameTo(folderPath.parent.resolve(newName).toFile())
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun renameFolderAsync(newName: String): Deferred<Boolean> = GlobalScope.async{
        renameFolder(newName)
    }

    private fun getFolderSize(file: java.io.File): String{
        val size = file.walkTopDown()
            .filter { it.isFile }
            .map { it.length() }
            .sum()
        return formatBytes(size)
    }

    override fun getFolderSize(): String {
        return getFolderSize(folderPath.toFile())
    }

    override fun getFolderChildSize(childPath: String): String {
        val file = folderPath.resolve(childPath).toFile()
        if (file.isDirectory){
            return getFolderSize(file)
        }
        return formatBytes(file.toPath().fileSize())
    }

    override fun getFolderName(): String{
        return folderPath.name
    }

    override fun getFolderOwner(): String{
        return folderPath.getOwner()?.name ?: "without owner"
    }

    override fun getPathString(): String {
        return folderPath.absolutePathString()
    }
}
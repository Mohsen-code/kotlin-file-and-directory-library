package mohsen.coder

import kotlinx.coroutines.Deferred

internal interface IFolder {
    fun createFolder(name: String)
    fun createFolderAsync(name: String): Deferred<Unit>
    fun folderContent(): List<String>
    fun folderContentAsync(): Deferred<List<String>>
    fun removeChildFile(fileName: String): Boolean
    fun removeChildFileAsync(fileName: String): Deferred<Boolean>
    fun removeChildFolder(folderName: String): Boolean
    fun removeChildFolderAsync(folderName: String): Deferred<Boolean>
    fun removeFolder(): Boolean
    fun removeFolderAsync(): Deferred<Boolean>
    fun renameChildFile(childOldName:String, childNewName: String): Boolean
    fun renameChildFileAsync(childOldName:String, childNewName: String): Deferred<Boolean>
    fun renameChildFolder(childOldName:String, childNewName: String): Boolean
    fun renameChildFolderAsync(childOldName:String, childNewName: String): Deferred<Boolean>
    fun renameFolder(newName: String): Boolean
    fun renameFolderAsync(newName: String): Deferred<Boolean>
    fun getFolderSize(): String
    fun getFolderChildSize(childPath: String): String
    fun getFolderName(): String
    fun getFolderOwner(): String
    fun getPathString(): String
}
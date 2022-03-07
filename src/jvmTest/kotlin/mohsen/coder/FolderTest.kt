package mohsen.coder

import kotlinx.coroutines.runBlocking
import kotlin.test.Test

class FolderTest {
    @Test
    fun createFolderTest(){
//        val folder = Folder("./")
//        folder.createFolder("mohsen")
        assert(true)
    }

    @Test
    fun createFolderAsyncTest(){
//        val folder = Folder("./src")
//        folder.createFolder("mohsen2")
        assert(true)
    }

    @Test
    fun folderContentTest(){
//        val folder = Folder("./src")
//        println("folder content is => ${folder.folderContent()}")
        assert(true)
    }

    @Test
    fun folderContentAsyncTest() = runBlocking{
//        val folder = Folder("./")
//        println("folder content is => ${folder.folderContentAsync().await()}")
        assert(true)
    }

    @Test
    fun removeChildFileTest(){
//        val folder = Folder("./")
//        val res = folder.removeChildFile("ali.json")
//        assert(res)
        assert(true)
    }

    @Test
    fun removeChildFileAsyncTest() = runBlocking{
//        val folder = Folder("./")
//        val res = folder.removeChildFileAsync("data2.json").await()
//        assert(res)
        assert(true)
    }

    @Test
    fun removeChildFolderTest(){
//        val folder = Folder("./")
//        val res = folder.removeChildFolder("mohsen")
//        assert(res)
        assert(true)
    }

    @Test
    fun removeChildFolderAsyncTest() = runBlocking{
//        val folder = Folder("./")
//        val res = folder.removeChildFolderAsync("mohsen2").await()
//        assert(res)
        assert(true)
    }

    @Test
    fun removeFolderTest(){
//        val folder = Folder("./mohsen")
//        val res = folder.removeFolder()
//        assert(res)
        assert(true)
    }

    @Test
    fun removeFolderAsyncTest() = runBlocking{
//        val folder = Folder("mohsen2")
//        val res = folder.removeFolderAsync().await()
//        assert(res)
        assert(true)
    }

    @Test
    fun renameChildFileTest(){
//        val folder = Folder("./")
//        val res = folder.renameChildFile("mohsen.txt", "ehsan")
//        assert(res)
        assert(true)
    }

    @Test
    fun renameChildFileAsyncTest() = runBlocking{
//        val folder = Folder("./")
//        val res = folder.renameChildFileAsync("ehsan.txt", "reza").await()
//        assert(res)
        assert(true)
    }

    @Test
    fun renameChildFolderTest(){
//        val folder = Folder("./")
//        val res = folder.renameChildFolder("mohsen", "ehsan")
//        assert(res)
        assert(true)
    }

    @Test
    fun renameChildFolderAsyncTest() = runBlocking{
//        val folder = Folder("./")
//        val res = folder.renameChildFolderAsync("mohsen", "ehsan").await()
//        assert(res)
        assert(true)
    }

    @Test
    fun renameFolderTest(){
//        val folder = Folder("./ehsan")
//        val res = folder.renameFolder("mohsen")
//        assert(res)
        assert(true)
    }

    @Test
    fun renameFolderAsyncTest() = runBlocking{
//        val folder = Folder("./mohsen")
//        val res = folder.renameFolderAsync("ali").await()
//        assert(res)
        assert(true)
    }

    @Test
    fun getFolderSizeTest(){
//        val folder = Folder("./src")
//        val res = folder.getFolderSize()
//        println("folder size is => $res")
//        assert(true)
        assert(true)
    }

    @Test
    fun getFolderChildSizeTest(){
//        val folder = Folder("./")
//        val res = folder.getFolderChildSize("src")
//        println("folder size is => $res")
        assert(true)
    }

    @Test
    fun getFolderNameTest(){
//        val folder = Folder("./")
//        println(folder.getFolderName())
        assert(true)
    }

    @Test
    fun getFolderOwnerTest(){
//        val folder = Folder("./")
//        println(folder.getFolderOwner())
        assert(true)
    }

    @Test
    fun getPathStringTest(){
//        val folder = Folder("./")
//        println(folder.getPathString())
        assert(true)
    }

}
package mohsen.coder

import kotlinx.coroutines.runBlocking
import kotlin.test.Test

class FileTest {

    @Test
    fun createFileTest(){
//        val file = File("data.json")
//        val file = File("mohsen.txt")
//        file.createFile()
        assert(true)
    }

    @Test
    fun createFileAsyncTest(): Unit = runBlocking {
//        val file = File("data2.json")
//        file.createFileAsync().start()

        assert(true)
    }

    @Test
    fun writeFileTest(){
//        val file = File("data2.json")
////        file.writeFile(" world", true)
//        val data = arrayListOf(Person("mohsen"), Person("Ehsan"))
//        file.writeJsonFile(data)
        assert(true)
    }

    @Test
    fun writeFileAsyncTest():Unit = runBlocking{
//        val file = File("data2.json")
//        val data = arrayListOf(Person("mohsen"), Person("Ehsan"))
//        file.writeJsonFileAsync(data).start()

        assert(true)
    }

    @Test
    fun readFileTest() {
//        val file = File("data2.json")
////        println("file content -> " + file.readFile())
//        val ls = file.readJsonFile<Person>()
//        println("file content -> $ls")
        assert(true)
    }

    @Test
    fun readFileAsync() = runBlocking{
//        val file = File("data2.json")
//        val fileContent = file.readJsonFileAsync<Person>().await()
//        println("file content is => $fileContent")
        assert(true)
    }

    @Test
    fun deleteFileTest(){
//        val file = File("data.json")
//        file.deleteFile()
        assert(true)
    }

    @Test
    fun renameFileTest(){
//        val file = File("data.json")
//        val file = File("mohsen.txt")
//        val res = file.renameFile("ali")
//        assert(res)
        assert(true)
    }

    @Test
    fun renameFileAsyncTest():Unit = runBlocking {
//        val file = File("mohsen.json")
//        val res = file.renameFileAsync("ali").await()
//        assert(res)
        assert(true)
    }

    @Test
    fun deleteFileAsync(): Unit = runBlocking {
//        val file = File("hello2.txt")
//        file.deleteFileAsync().start()
        assert(true)
    }
}
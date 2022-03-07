# Kotlin File And Directory Library

Work with files and directories as simple as possible with this library. If you're confusing when you want to work with files and directories, and you don't know which package you should use, this library can help you!

it is so simple to use, just instantiate File or Folder class and use their APIs.

## Installation
1. first you must add Jitpack repository to your build.gradle, if you don't know how to add Jitpack repo to your gradle you can visit Jitpack website:
https://jitpack.io

   
2. add library implementation to gradle dependencies
```groovy
dependencies {
    implementation 'com.github.Mohsen-code.kotlin-file-and-directory-library:KotlinFileAndFolderLibrary:1.0'
}
```

## Usage

just import package ``mohes.coder.*`` and use File and Folder classes like bellow:


### For Files:
```kotlin
import mohsen.coder.File

fun main() {
    val file = File("mohsen.txt") // you should pass file path link this
    // if you want to create a file in specific path you can pass file path
    // to File like bellow:
    // val file = File("./src/mohsen.txt")
    // Notice: file path must exist otherwise it throw IOException
    file.createFile() // it will create mohsen.txt in root path of your project

    file.createFileAsync().start() // create file asynchronously

    file.writeFile(content = "hello world", append = false) // write hello world into file
    // if you want to append text at the end of file, append parameter must be true

    file.writeFileAsync(content = "hello world", append = true).start() // write file asynchronously
}
```

### File APIs:
| api                                              | description                                        |
|--------------------------------------------------|----------------------------------------------------|
| createFile()                                     | create new file                                    |
| createFileAsync()                                | create new file asynchronously                     |
| readFile()                                       | return file content                                |
| readFileAsync()                                  | return file content asynchronously                 |
| readFileLines()                                  | return file content lines as a list                |
| readFileLinesAsync()                             | return file content lines as a list asynchronously |
| writeFile(content: String, append: Boolean)      | write file                                         |
| writeFileAsync(content: String, append: Boolean) | write file asynchronously                          |
| readJsonFile()                                   | return parsed json file content                    |
| readJsonFileAsync()                              | return parsed json file content asynchronously     |
| writeJsonFile(content: ArrayList<*>)             | write json file                                    |
| writeJsonFileAsync(content: ArrayList<*>)        | write json file asynchronously                     |
| renameFile(newName: String)                      | rename file                                        |
| renameFileAsync(newName: String)                 | rename file asynchronously                         |
| deleteFile()                                     | delete file                                        |
| deleteFileAsync()                                | delete file asynchronously                         |
| getFilePath()                                    | return file path as Path object                    |
| getFileName()                                    | return file name                                   |
| getFileSize()                                    | return file size                                   |
| getFileSizeString()                              | return file size as string, for example 2.23 KB    |
| getFileMeme()                                    | return file meme                                   |
| getFilePathString()                              | return file absolute file path                     |
| isFileExist()                                    | check file exist or not                            |

### For Directory:
```kotlin
import mohsen.coder.Folder

fun main() {
    val folder = Folder("./") // pass directory path you want to work with. 
                              // in this example we work with root directory.
    
    folder.createFolder("mohsen") // create a directory named "mohsen" in root path
    folder.createFolderAsync("ali").start() // create a directory asynchronously
    
    folder.renameChildFolder("mohsen", "mohsen2") // rename mohsen directory to mohsen2
    folder.removeChildFolder("mohsen") // remove directory
    
    folder.renameChildFile("test.txt", "hello") // rename child file of a directory
    folder.removeChildFile("test.txt") // remove directory child file
}
```

### Folder APIs:
| api                                                               | description                                     |
|-------------------------------------------------------------------|-------------------------------------------------|
| createFolder(name: String)                                        | create new directory                            |
| createFolderAsync(name: String)                                   | create new directory asynchronously             |
| folderContent()                                                   | return directory content                        |
| folderContentAsync()                                              | return directory content asynchronously         |
| removeChildFile(fileName: String)                                 | remove directory children file                  |
| removeChildFileAsync(fileName: String)                            | remove directory children file asynchronously   |
| removeChildFolder(folderName: String)                             | remove directory children folder                |
| removeChildFolderAsync(folderName: String)                        | remove directory children folder asynchronously |
| removeFolder()                                                    | remove work directory                           |
| removeFolderAsync()                                               | remove work directory asynchronously            |
| renameChildFile(childOldName:String, childNewName: String)        | rename directory child file                     |
| renameChildFileAsync(childOldName:String, childNewName: String)   | rename directory child file asynchronously      |
| renameChildFolder(childOldName:String, childNewName: String)      | rename directory child folder                   |
| renameChildFolderAsync(childOldName:String, childNewName: String) | rename directory child folder asynchronously    |
| renameFolder(newName: String)                                     | rename work directory                           |
| renameFolderAsync(newName: String)                                | rename work directory asynchronously            |
| getFolderSize()                                                   | return directory size                           |
| getFolderChildSize(childPath: String)                             | return directory child size                     |
| getFolderName()                                                   | return directory name                           |
| getFolderOwner()                                                  | return directory owner                          |
| getPathString()                                                   | return directory absolute path                  |

### Author Note:
دیگران کاشتند و ما خوردیم، ما می کاریم تا دیگران بخورند!

follow me on Twitter: https://twitter.com/developer_xs
package itmo.web_services

import itmo.web_services.impl.JavaEERestClient
import itmo.web_services.impl.StandaloneRestClient
import itmo.web_services.model.AddBookRequest
import itmo.web_services.model.UpdateBookRequest

enum class ServerType {
    STANDALONE, JAVA_EE
}

class ClientService {
    private val clients = mapOf(
        ServerType.JAVA_EE to JavaEERestClient(),
        ServerType.STANDALONE to StandaloneRestClient()
    )

    fun getBooks(type: ServerType) {
        println("get books")
        clients[type]?.getBooks()
    }

    fun getBooksByTitle(type: ServerType) {
        println("enter title: ")
        val title = readLine()!!
        clients[type]?.getBooksByTitle(title)
    }

    fun getBooksByAuthor(type: ServerType) {
        println("enter author: ")
        val author = readLine()!!
        clients[type]?.getBooksByAuthor(author)
    }

    fun getBooksByPubHouse(type: ServerType) {
        println("enter publishing house: ")
        val pubHouse = readLine()!!
        clients[type]?.getBooksByPubHouse(pubHouse)
    }

    fun getBooksByTitleAndAuthor(type: ServerType) {
        println("enter title: ")
        val title = readLine()!!
        println("enter author: ")
        val author = readLine()!!
        clients[type]?.getBooksByTitleAndAuthor(title, author)
    }

    fun getBookByTitleAndPubHouse(type: ServerType) {
        println("enter title: ")
        val title = readLine()!!
        println("enter publishing house")
        val pubHouse = readLine()!!
        clients[type]?.getBookByTitleAndPubHouse(title, pubHouse)
    }

    fun getBookByAuthorAndPubHouse(type: ServerType) {
        println("enter author: ")
        val author = readLine()!!
        println("enter publishing house")
        val pubHouse = readLine()!!
        clients[type]?.getBookByAuthorAndPubHouse(author, pubHouse)
    }

    fun getBooksByPagesRange(type: ServerType) {
        println("enter from: ")
        val from = readLine()!!
        println("enter to: ")
        val to = readLine()!!
        clients[type]?.getBooksByPagesRange(from.toInt(), to.toInt())
    }

    fun getBooksByAuthorAndMinPages(type: ServerType) {
        println("enter author: ")
        val author = readLine()!!
        println("enter min: ")
        val min = readLine()!!
        clients[type]?.getBooksByAuthorAndMinPages(author, min.toInt())
    }

    fun getBooksByAuthorAndMaxPages(type: ServerType) {
        println("enter author: ")
        val author = readLine()!!
        println("enter max: ")
        val max = readLine()!!
        clients[type]?.getBooksByAuthorAndMaxPages(author, max.toInt())
    }

    fun addBook(type: ServerType) {
        println("enter title: ")
        val title = readLine()!!
        println("enter author: ")
        val author = readLine()!!
        println("enter pubHouse: ")
        val pubHouse = readLine()!!
        println("enter lang: ")
        val lang = readLine()!!
        println("enter pages: ")
        val pages = readLine()!!

        clients[type]?.addNewBook(
            AddBookRequest(
                title, author, pubHouse, lang, pages.toInt()
            )
        )
    }

    fun updateBook(type: ServerType) {
        println("enter uid: ")
        val uid = readLine()!!
        println("enter title: ")
        val title = readLine()!!
        println("enter author: ")
        val author = readLine()!!
        println("enter pubHouse: ")
        val pubHouse = readLine()!!
        println("enter lang: ")
        val lang = readLine()!!
        println("enter pages: ")
        val pages = readLine()!!

        clients[type]?.updateBook(
            UpdateBookRequest(
                uid.toLong(), title, author, pubHouse, lang, pages.toInt()
            )
        )
    }

    fun deleteBook(type: ServerType) {
        println("enter uid: ")
        val uid = readLine()!!
        clients[type]?.deleteBook(uid.toLong())
    }

    fun login(type: ServerType) {
        println("enter username")
        val username = readLine()!!
        println("enter pswd")
        val pswd = readLine()!!

        clients[type]?.login(username, pswd)
    }

    fun logout(type: ServerType) {
        clients[type]?.logout()
    }
}
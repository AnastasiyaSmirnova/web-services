package itmo.web_services

import itmo.web_services.impl.JavaEERestClient
import itmo.web_services.impl.StandaloneRestClient

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

}
package itmo.web_services.impl

import itmo.web_services.BookClient
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import itmo.web_services.model.*

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpRequest.BodyPublishers.ofString
import java.net.http.HttpResponse

class JavaEERestClient : BookClient {
    private val url = "http://localhost:8080/java-ee-rest-application-books-rest/rest/books"
    private var client: HttpClient = HttpClient.newBuilder().build()
    private val mapper = ObjectMapper()

    override fun getBooks() {
        val request = request(url)
        val books = client.send(request, HttpResponse.BodyHandlers.ofString())
            .body()
            .value<Collection<Book>>()
        println(books.joinToString("\n"))
    }

    override fun getBooksByTitle(title: String) {
        val request = request("$url/byTitle?title=$title")
        val books = client.send(request, HttpResponse.BodyHandlers.ofString())
            .body()
            .value<Collection<Book>>()
        println(books.joinToString("\n"))
    }

    override fun getBooksByAuthor(author: String) {
        val request = request("$url/byAuthor?author=$author")
        val books = client.send(request, HttpResponse.BodyHandlers.ofString())
            .body()
            .value<Collection<Book>>()
        println(books.joinToString("\n"))
    }

    override fun getBooksByPubHouse(pubHouse: String) {
        val request = request("$url/byPublishingHouse?pubHouse=$pubHouse")
        val books = client.send(request, HttpResponse.BodyHandlers.ofString())
            .body()
            .value<Collection<Book>>()
        println(books.joinToString("\n"))
    }

    override fun getBooksByTitleAndAuthor(title: String, author: String) {
        val request = request("$url/byTitleAndAuthor?title=$title&author=$author")
        val books = client.send(request, HttpResponse.BodyHandlers.ofString())
            .body()
            .value<Collection<Book>>()
        println(books.joinToString("\n"))
    }

    override fun getBookByTitleAndPubHouse(title: String, pubHouse: String) {
        val request = request("$url/byTitleAndPublishingHouse?title=$title&pubHouse=$pubHouse")
        val books = client.send(request, HttpResponse.BodyHandlers.ofString())
            .body()
            .value<Collection<Book>>()
        println(books.joinToString("\n"))
    }

    override fun getBookByAuthorAndPubHouse(author: String, pubHouse: String) {
        val request = request("$url/byAuthorAndPublishingHouse?author=$author&pubHouse=$pubHouse")
        val books = client.send(request, HttpResponse.BodyHandlers.ofString())
            .body()
            .value<Collection<Book>>()
        println(books.joinToString("\n"))
    }

    override fun getBooksByPagesRange(from: Int, to: Int) {
        val request = request("$url/byPagesRange?from=$from&to=$to")
        val books = client.send(request, HttpResponse.BodyHandlers.ofString())
            .body()
            .value<Collection<Book>>()
        println(books.joinToString("\n"))
    }

    override fun getBooksByAuthorAndMinPages(author: String, min: Int) {
        val request = request("$url/byAuthorAndMinPages?author=$author&min=$min")
        val books = client.send(request, HttpResponse.BodyHandlers.ofString())
            .body()
            .value<Collection<Book>>()
        println(books.joinToString("\n"))
    }

    override fun getBooksByAuthorAndMaxPages(author: String, max: Int) {
        val request = request("$url/byAuthorAndMaxPages?author=$author&max=$max")
        val books = client.send(request, HttpResponse.BodyHandlers.ofString())
            .body()
            .value<Collection<Book>>()
        println(books.joinToString("\n"))
    }

    override fun addNewBook(newBook: AddBookRequest) {
        val request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .POST(ofString(newBook.toJson()))
            .header("Content-Type", "application/json")
            .header("Accept", "application/json")
            .version(HttpClient.Version.HTTP_1_1)
            .build()

        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        if (response.statusCode().successStatus()) {
            val uid = response
                .body()
                .value<Long>()
            println("new book created with UID #$uid")
        } else println("something goes wrong: ${response.body()}")
    }

    override fun updateBook(book: UpdateBookRequest) {
        val request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .PUT(ofString(book.toJson()))
            .header("Content-Type", "application/json")
            .header("Accept", "application/json")
            .version(HttpClient.Version.HTTP_1_1)
            .build()

        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        if (response.statusCode().successStatus()) {
            val status = response
                .body()
                .value<QueryStatus>()
            println("update operation status $status")
        } else println("something goes wrong: ${response.body()}")
    }

    override fun deleteBook(uid: Long) {
        val request = HttpRequest.newBuilder()
            .uri(URI.create("$url/$uid"))
            .DELETE()
            .header("Content-Type", "application/json")
            .header("Accept", "application/json")
            .version(HttpClient.Version.HTTP_1_1)
            .build()

        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        if (response.statusCode().successStatus()) {
            val status = response
                .body()
                .value<QueryStatus>()
            println("delete operation status $status")
        } else println("something goes wrong: ${response.body()}")
    }

    private fun Int.successStatus() = toString().startsWith("2")

    private inline fun <reified T> String.value() = mapper.readValue<T>(this)

    private inline fun <reified T : Books> T.toJson(): String = mapper.writeValueAsString(this)

    private fun request(uri: String) = HttpRequest.newBuilder()
        .uri(URI.create(uri))
        .header("Content-Type", "application/json")
        .header("Accept", "application/json")
        .version(HttpClient.Version.HTTP_1_1)
        .build()
}

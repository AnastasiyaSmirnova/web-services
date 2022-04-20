package itmo.web_services.impl

import itmo.web_services.BookClient
import itmo.web_services.model.Book
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
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

    private inline fun <reified T> String.value() = mapper.readValue<T>(this)

    private fun request(uri: String) = HttpRequest.newBuilder()
        .uri(URI.create(uri))
        .header("Content-Type", "application/json")
        .header("Accept", "application/json")
        .version(HttpClient.Version.HTTP_1_1)
        .build()
}

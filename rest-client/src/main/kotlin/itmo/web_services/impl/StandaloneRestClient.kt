package itmo.web_services.impl

import com.sun.jersey.api.client.Client
import com.sun.jersey.api.client.ClientResponse
import com.sun.jersey.api.client.WebResource
import com.sun.jersey.api.client.config.DefaultClientConfig
import itmo.web_services.BookClient
import itmo.web_services.model.BookResponse
import itmo.web_services.model.BooksResponse
import org.codehaus.jackson.jaxrs.JacksonJsonProvider
import javax.ws.rs.core.MediaType

class StandaloneRestClient : BookClient {
    private val url = "http://localhost:8080/rest/books"
    private lateinit var client: Client

    private val titles = mutableListOf<String>()
    private val authors = mutableListOf<String>()
    private val pubHouses = mutableListOf<String>()

    init {
        try {
            val defaultClientConfig = DefaultClientConfig()
            defaultClientConfig.classes.add(JacksonJsonProvider::class.java)
            client = Client.create(defaultClientConfig)
        } catch (e: Exception) {
            println("Something goes wrong =( ${e.message}")
        }
    }

    override fun getBooks() {
        titles.clear()
        authors.clear()
        pubHouses.clear()

        val webResource: WebResource = client.resource(url)
        sendRequest(webResource)
            .getEntity(BooksResponse::class.java)
            .let { books ->
                books.print()
                books.book
                    ?.filterNotNull()
                    ?.forEach { book ->
                        titles.add(book.title)
                        authors.add(book.author)
                        pubHouses.add(book.title)
                    }
            }
    }

    override fun getBooksByTitle(title: String) {
        val webResource: WebResource = client.resource("$url/byTitle?title=$title")
        sendRequest(webResource).getEntity(BookResponse::class.java).print()
    }

    override fun getBooksByAuthor(author: String) {
        val webResource: WebResource = client.resource("$url/byAuthor?author=$author")
        sendRequest(webResource).getEntity(BookResponse::class.java).print()
    }

    override fun getBooksByPubHouse(pubHouse: String) {
        val webResource: WebResource = client.resource("$url/byPublishingHouse?publishingHouse=$pubHouse")
        sendRequest(webResource).getEntity(BookResponse::class.java).print()
    }

    override fun getBooksByTitleAndAuthor(title: String, author: String) {
        val webResource: WebResource = client.resource("$url/byTitleAndAuthor?title=$title&author=$author")
        sendRequest(webResource).getEntity(BookResponse::class.java).print()
    }

    override fun getBookByTitleAndPubHouse(title: String, pubHouse: String) {
        val webResource: WebResource =
            client.resource("$url/byTitleAndPublishingHouse?title=$title&publishingHouse=$pubHouse")
        sendRequest(webResource).getEntity(BookResponse::class.java).print()
    }

    override fun getBookByAuthorAndPubHouse(author: String, pubHouse: String) {
        val webResource: WebResource =
            client.resource("$url/byAuthorAndPublishingHouse?author=$author&publishingHouse=$pubHouse")
        sendRequest(webResource).getEntity(BooksResponse::class.java).print()
    }

    override fun getBooksByPagesRange(from: Int, to: Int) {
        val webResource: WebResource = client.resource("$url/byPagesRange?from=$from&to=$to")
        sendRequest(webResource).getEntity(BooksResponse::class.java).print()
    }

    override fun getBooksByAuthorAndMinPages(author: String, min: Int) {
        val webResource: WebResource = client.resource("$url/byAuthorAndMinPages?author=$author&min=$min")
        sendRequest(webResource).getEntity(BookResponse::class.java).print()
    }

    override fun getBooksByAuthorAndMaxPages(author: String, max: Int) {
        val webResource: WebResource = client.resource("$url/byAuthorAndMaxPages?author=$author&max=$max")
        sendRequest(webResource).getEntity(BookResponse::class.java).print()
    }

    private fun sendRequest(webResource: WebResource): ClientResponse {
        val response: ClientResponse = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse::class.java)
        check(response.status == ClientResponse.Status.OK.statusCode) { "Request failed" }
        return response
    }

    private fun BookResponse?.print() = println(this?.book)


    private fun BooksResponse?.print() = println(
        this?.book?.joinToString("\n") ?: "no books found "
    )
}
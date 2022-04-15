package itmo.web_services

import com.sun.jersey.api.client.Client
import com.sun.jersey.api.client.ClientResponse
import com.sun.jersey.api.client.WebResource
import itmo.web_services.model.BookResponse
import itmo.web_services.model.BooksResponse
import javax.ws.rs.core.MediaType


class RestClient(
    private val client: Client,
    private val url: String
) {

    private val titles = mutableListOf<String>()
    private val authors = mutableListOf<String>()
    private val pubHouses = mutableListOf<String>()

    fun run() {
        getBooks()
        println(
            "choose the action:" +
                    "\n1 - get books by title " +
                    "\n2 - get books by author " +
                    "\n3 - get books by publishing house" +
                    "\n4 - get books by pages range" +
                    "\n5 - get books by title and author " +
                    "\n6 - get books by title and publishing house" +
                    "\n7 - get books by author and publishing house" +
                    "\n8 - get books by author and min pages number " +
                    "\n9 - get books by author and max pages number" +
                    "\n10 - get books" +
                    "\n11 - add new book" +
                    "\n12 - update book " +
                    "\n13 - delete book" +
                    "\n0 - exit"
        )

        var next: Int
        while (readLine()!!.toInt().also { next = it } > 0) {
            when (next) {
                1 -> getBooksByTitle()
                2 -> getBooksByAuthor()
                3 -> getBooksByPubHouse()
                4 -> getBooksByPagesRange()
                5 -> getBooksByTitleAndAuthor()
                6 -> getBookByTitleAndPubHouse()
                7 -> getBookByAuthorAndPubHouse()
                8 -> getBooksByAuthorAndMinPages()
                9 -> getBooksByAuthorAndMaxPages()
                10 -> getBooks()
                else ->
                    println("unknown action")
            }
        }
    }

    private fun getBooks() {
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


    private fun getBooksByTitle() {
        println("get books by title. ${titles.joinToString()}\nenter title:")
        val title = readLine()

        val webResource: WebResource = client.resource("$url/byTitle?title=$title")
        sendRequest(webResource)
            .getEntity(BookResponse::class.java)
            .print()
    }

    private fun getBooksByAuthor() {
        println("get books by author. ${authors.joinToString()}\nenter author")
        val author = readLine()

        val webResource: WebResource = client.resource("$url/byAuthor?author=$author")
        sendRequest(webResource)
            .getEntity(BookResponse::class.java)
            .print()
    }

    private fun getBooksByPubHouse() {
        println("get books by publishing house. ${pubHouses.joinToString()}\nenter publishing house")
        val pubHouse = readLine()

        val webResource: WebResource = client.resource("$url/byPublishingHouse?publishingHouse=$pubHouse")
        sendRequest(webResource)
            .getEntity(BookResponse::class.java)
            .print()
    }

    private fun getBooksByTitleAndAuthor() {
        println("get books by title and author\nenter title:")
        val title = readLine()
        println("enter author: ")
        val author = readLine()

        val webResource: WebResource = client.resource("$url/byTitleAndAuthor?title=$title&author=$author")
        sendRequest(webResource)
            .getEntity(BookResponse::class.java)
            .print()
    }

    private fun getBookByTitleAndPubHouse() {
        println("get books by title and publishingHouse\nenter title:")
        val title = readLine()
        println("enter publishingHouse: ")
        val pubHouse = readLine()

        val webResource: WebResource =
            client.resource("$url/byTitleAndPublishingHouse?title=$title&publishingHouse=$pubHouse")
        sendRequest(webResource)
            .getEntity(BookResponse::class.java)
            .print()
    }

    private fun getBookByAuthorAndPubHouse() {
        println("get books by author and publishingHouse\nenter author:")
        val author = readLine()
        println("enter publishingHouse: ")
        val pubHouse = readLine()

        val webResource: WebResource =
            client.resource("$url/byAuthorAndPublishingHouse?author=$author&publishingHouse=$pubHouse")
        sendRequest(webResource)
            .getEntity(BooksResponse::class.java)
            .print()
    }

    private fun getBooksByPagesRange() {
        println("get books by pages range\nenter min:")
        val min = readLine()
        println("enter max: ")
        val max = readLine()

        val webResource: WebResource = client.resource("$url/byPagesRange?from=$min&to=$max")
        sendRequest(webResource)
            .getEntity(BooksResponse::class.java)
            .print()
    }

    private fun getBooksByAuthorAndMinPages() {
        println("get books by author and min pages\nenter author:")
        val author = readLine()
        println("enter min: ")
        val min = readLine()

        val webResource: WebResource = client.resource("$url/byAuthorAndMinPages?author=$author&min=$min")
        sendRequest(webResource)
            .getEntity(BookResponse::class.java)
            .print()
    }

    private fun getBooksByAuthorAndMaxPages() {
        println("get books by author and max pages\nenter author:")
        val author = readLine()
        println("enter max: ")
        val max = readLine()

        val webResource: WebResource = client.resource("$url/byAuthorAndMaxPages?author=$author&max=$max")
        sendRequest(webResource)
            .getEntity(BookResponse::class.java)
            .print()
    }


    private fun sendRequest(webResource: WebResource): ClientResponse {
        val response: ClientResponse = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse::class.java)
        check(response.status == ClientResponse.Status.OK.statusCode) { "Request failed" }
        return response
    }

    private fun BookResponse?.print() = println(this?.book)


    private fun BooksResponse?.print() = println(
        this?.book?.joinToString("\n")
            ?: "no books found "
    )
}


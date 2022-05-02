package itmo.web_services

class RestClient(
    private val type: ServerType,
    private val client: ClientService
) {

    fun run() {
        client.getBooks(type)
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
                    "\n14 - login" +
                    "\n15 - logout" +
                    "\n0 - exit"
        )

        var next: Int
        while (readLine()!!.toInt().also { next = it } > 0) {
            when (next) {
                1 -> client.getBooksByTitle(type)
                2 -> client.getBooksByAuthor(type)
                3 -> client.getBooksByPubHouse(type)
                4 -> client.getBooksByPagesRange(type)
                5 -> client.getBooksByTitleAndAuthor(type)
                6 -> client.getBookByTitleAndPubHouse(type)
                7 -> client.getBookByAuthorAndPubHouse(type)
                8 -> client.getBooksByAuthorAndMinPages(type)
                9 -> client.getBooksByAuthorAndMaxPages(type)
                10 -> client.getBooks(type)
                11 -> client.addBook(type)
                12 -> client.updateBook(type)
                13 -> client.deleteBook(type)
                14 -> client.login(type)
                15 -> client.logout(type)
                else ->
                    println("unknown action")
            }
        }
    }
}


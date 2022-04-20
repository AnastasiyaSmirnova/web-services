package itmo.web_services

interface BookClient {
    fun getBooks()
    fun getBooksByTitle(title: String)
    fun getBooksByAuthor(author: String)
    fun getBooksByPubHouse(pubHouse: String)
    fun getBooksByTitleAndAuthor(title: String, author: String)
    fun getBookByTitleAndPubHouse(title: String, pubHouse: String)
    fun getBookByAuthorAndPubHouse(author: String, pubHouse: String)
    fun getBooksByPagesRange(from: Int, to: Int)
    fun getBooksByAuthorAndMinPages(author: String, min: Int)
    fun getBooksByAuthorAndMaxPages(author: String, max: Int)
}
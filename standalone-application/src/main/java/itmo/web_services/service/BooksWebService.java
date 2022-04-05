package itmo.web_services.service;

import itmo.web_services.dao.BookDao;
import itmo.web_services.model.Book;
import itmo.web_services.model.Language;
import itmo.web_services.model.QueryStatus;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@WebService(serviceName = "BookService")
public class BooksWebService {
    private final BookDao bookDao;

    public BooksWebService() {
        bookDao = new BookDao();
    }

    @WebMethod(operationName = "addBook")
    public long addBook(@WebParam(name = "title") @XmlElement(required = true) String title,
                        @WebParam(name = "author") @XmlElement(required = true) String author,
                        @WebParam(name = "publishing_house") @XmlElement(required = true) String publishing_house,
                        @WebParam(name = "language") @XmlElement(required = true) Language language,
                        @WebParam(name = "pages") @XmlElement(required = true) int pages) {
        return bookDao.addBook(title, author, publishing_house, language, pages);
    }

    @WebMethod(operationName = "updateBook")
    public QueryStatus updateBook(@WebParam(name = "id") @XmlElement(required = true) long id,
                                  @WebParam(name = "title") @XmlElement(required = true) String title,
                                  @WebParam(name = "author") @XmlElement(required = true) String author,
                                  @WebParam(name = "publishing_house") @XmlElement(required = true) String publishing_house,
                                  @WebParam(name = "language") @XmlElement(required = true) Language language,
                                  @WebParam(name = "pages") @XmlElement(required = true) int pages) {
        return bookDao.updateBook(id, title, author, publishing_house, language, pages);
    }

    @WebMethod(operationName = "deleteBook")
    public QueryStatus deleteBook(@WebParam(name = "id") @XmlElement(required = true) long id) {
        return bookDao.deleteBook(id);
    }

    @WebMethod(operationName = "getBooks")
    public List<Book> getBooks() {
        return bookDao.getBooks();
    }

    @WebMethod(operationName = "getBooksByTitle")
    public List<Book> getBooksByTitle(@WebParam(name = "title") @XmlElement(required = true) String title) {
        return bookDao.getBooksByTitle(title);
    }

    @WebMethod(operationName = "getBooksByAuthor")
    public List<Book> getBooksByAuthor(@WebParam(name = "author") @XmlElement(required = true) String author) {
        return bookDao.getBooksByAuthor(author);
    }

    @WebMethod(operationName = "getBooksByPublishingHouse")
    public List<Book> getBooksByPublishingHouse(@WebParam(name = "publishingHouse") @XmlElement(required = true) String publishingHouse) {
        return bookDao.getBooksByPublishingHouse(publishingHouse);
    }

    @WebMethod(operationName = "getBooksByPagesRange")
    public List<Book> getBooksByPagesRange(
            @WebParam(name = "from") @XmlElement(required = true) int from,
            @WebParam(name = "to") @XmlElement(required = true) int to
    ) {
        return bookDao.getBooksByPagesRange(from, to);
    }

    @WebMethod(operationName = "getBooksByTitleAndAuthor")
    public List<Book> getBooksByTitleAndAuthor(
            @WebParam(name = "title") @XmlElement(required = true) String title,
            @WebParam(name = "author") @XmlElement(required = true) String author
    ) {
        return bookDao.getBooksByTitleAndAuthor(title, author);
    }

    @WebMethod(operationName = "getBooksByTitleAndPublishingHouse")
    public List<Book> getBooksByTitleAndPublishingHouse(
            @WebParam(name = "title") @XmlElement(required = true) String title,
            @WebParam(name = "publishingHouse") @XmlElement(required = true) String publishingHouse
    ) {
        return bookDao.getBooksByTitleAndPublishingHouse(title, publishingHouse);
    }

    @WebMethod(operationName = "getBooksByAuthorAndPublishingHouse")
    public List<Book> getBooksByAuthorAndPublishingHouse(
            @WebParam(name = "author") @XmlElement(required = true) String author,
            @WebParam(name = "publishingHouse") @XmlElement(required = true) String publishingHouse
    ) {
        return bookDao.getBooksByAuthorAndPublishingHouse(author, publishingHouse);
    }

    @WebMethod(operationName = "getBooksByAuthorAndMinPages")
    public List<Book> getBooksByAuthorAndMinPages(
            @WebParam(name = "author") @XmlElement(required = true) String author,
            @WebParam(name = "min") @XmlElement(required = true) int min
    ) {
        return bookDao.getBooksByAuthorAndMinPages(author, min);
    }

    @WebMethod(operationName = "getBooksByAuthorAndMaxPages")
    public List<Book> getBooksByAuthorAndMaxPages(
            @WebParam(name = "author") @XmlElement(required = true) String author,
            @WebParam(name = "max") @XmlElement(required = true) int max
    ) {
        return bookDao.getBooksByAuthorAndMaxPages(author, max);
    }
}


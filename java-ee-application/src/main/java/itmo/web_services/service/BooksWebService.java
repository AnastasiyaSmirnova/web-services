package itmo.web_services.service;

import itmo.web_services.dao.BookDao;
import itmo.web_services.model.Book;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.sql.DataSource;
import javax.xml.bind.annotation.XmlElement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebService(serviceName = "BookService")
public class BooksWebService {

    @Resource(lookup = "jdbc/ifmo-ws")
    private DataSource dataSource;

    @WebMethod(operationName = "getBooks")
    public List<Book> getBooks() {
        return new BookDao(getConnection()).getBooks();
    }

    @WebMethod(operationName = "getBooksByTitle")
    public List<Book> getBooksByTitle(@WebParam(name = "title") @XmlElement(required = true) String title) {
        return new BookDao(getConnection()).getBooksByTitle(title);
    }

    @WebMethod(operationName = "getBooksByAuthor")
    public List<Book> getBooksByAuthor(@WebParam(name = "author") @XmlElement(required = true) String author) {
        return new BookDao(getConnection()).getBooksByAuthor(author);
    }

    @WebMethod(operationName = "getBooksByPublishingHouse")
    public List<Book> getBooksByPublishingHouse(@WebParam(name = "publishingHouse") @XmlElement(required = true) String publishingHouse) {
        return new BookDao(getConnection()).getBooksByPublishingHouse(publishingHouse);
    }

    @WebMethod(operationName = "getBooksByPagesRange")
    public List<Book> getBooksByPagesRange(
            @WebParam(name = "from") @XmlElement(required = true) int from,
            @WebParam(name = "to") @XmlElement(required = true) int to
    ) {
        return new BookDao(getConnection()).getBooksByPagesRange(from, to);
    }

    @WebMethod(operationName = "getBooksByTitleAndAuthor")
    public List<Book> getBooksByTitleAndAuthor(
            @WebParam(name = "title") @XmlElement(required = true) String title,
            @WebParam(name = "author") @XmlElement(required = true) String author
    ) {
        return new BookDao(getConnection()).getBooksByTitleAndAuthor(title, author);
    }

    @WebMethod(operationName = "getBooksByTitleAndPublishingHouse")
    public List<Book> getBooksByTitleAndPublishingHouse(
            @WebParam(name = "title") @XmlElement(required = true) String title,
            @WebParam(name = "publishingHouse") @XmlElement(required = true) String publishingHouse
    ) {
        return new BookDao(getConnection()).getBooksByTitleAndPublishingHouse(title, publishingHouse);
    }

    @WebMethod(operationName = "getBooksByAuthorAndPublishingHouse")
    public List<Book> getBooksByAuthorAndPublishingHouse(
            @WebParam(name = "author") @XmlElement(required = true) String author,
            @WebParam(name = "publishingHouse") @XmlElement(required = true) String publishingHouse
    ) {
        return new BookDao(getConnection()).getBooksByAuthorAndPublishingHouse(author, publishingHouse);
    }

    @WebMethod(operationName = "getBooksByAuthorAndMinPages")
    public List<Book> getBooksByAuthorAndMinPages(
            @WebParam(name = "author") @XmlElement(required = true) String author,
            @WebParam(name = "min") @XmlElement(required = true) int min
    ) {
        return new BookDao(getConnection()).getBooksByAuthorAndMinPages(author, min);
    }

    @WebMethod(operationName = "getBooksByAuthorAndMaxPages")
    public List<Book> getBooksByAuthorAndMaxPages(
            @WebParam(name = "author") @XmlElement(required = true) String author,
            @WebParam(name = "max") @XmlElement(required = true) int max
    ) {
        return new BookDao(getConnection()).getBooksByAuthorAndMaxPages(author, max);
    }

    private Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

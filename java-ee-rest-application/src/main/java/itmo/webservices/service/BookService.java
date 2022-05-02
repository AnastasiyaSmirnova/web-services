package itmo.webservices.service;

import itmo.webservices.annotation.Secured;
import itmo.webservices.dao.BookDao;
import itmo.webservices.exception.InvalidBookParamException;
import itmo.webservices.model.*;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.sql.DataSource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@RequestScoped
@Path("/books")
@Produces({MediaType.APPLICATION_JSON})
public class BookService {

    @Resource(lookup = "jdbc/ifmo-ws")
    private DataSource dataSource;

    @Secured
    @GET()
    public List<Book> getBooks() {
        return new BookDao(getConnection()).getBooks();
    }

    @Secured
    @POST
    public long addBook(AddBookRequest newBook) throws InvalidBookParamException {
        System.out.println("add book " + newBook);
        Language language = validateLanguage(newBook.getLanguage());
        return new BookDao(getConnection())
                .addBook(
                        newBook.getTitle(),
                        newBook.getAuthor(),
                        newBook.getPublishingHouse(),
                        language,
                        newBook.getPages()
                );
    }

    @Secured
    @PUT
    public QueryStatus updateBook(UpdateBookRequest book) throws InvalidBookParamException {
        System.out.println("update book " + book);
        validateUid(book.getUid());
        Language language = validateLanguage(book.getLanguage());
        return new BookDao(getConnection()).updateBook(
                book.getUid(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublishingHouse(),
                language,
                book.getPages()
        );
    }

    @Secured
    @DELETE
    @Path("{uid}")
    public QueryStatus deleteBook(@PathParam("uid") long uid) throws InvalidBookParamException {
        System.out.println("delete book " + uid);
        validateUid(uid);
        return new BookDao(getConnection()).deleteBook(uid);
    }

    private void validateUid(Long uid) throws InvalidBookParamException {
        if (uid == null || new BookDao(getConnection()).getBookByUid(uid) == null)
            throw new InvalidBookParamException("unknown uid");
    }

    private Language validateLanguage(String language) throws InvalidBookParamException {
        try {
            return Language.valueOf(language);
        } catch (IllegalArgumentException e) {
            throw new InvalidBookParamException("unknown language - " + language);
        }
    }

    @GET
    @Path("byTitle")
    public List<Book> getBooksByTitle(@QueryParam("title") @XmlElement(required = true) String title) {
        return new BookDao(getConnection()).getBooksByTitle(title);
    }

    @GET
    @Path("byAuthor")
    public List<Book> getBooksByAuthor(@QueryParam("author") @XmlElement(required = true) String author) {
        return new BookDao(getConnection()).getBooksByAuthor(author);
    }

    @GET
    @Path("byPublishingHouse")
    public List<Book> getBooksByPublishingHouse(@QueryParam("publishingHouse") @XmlElement(required = true) String publishingHouse) {
        return new BookDao(getConnection()).getBooksByPublishingHouse(publishingHouse);
    }

    @GET
    @Path("byPagesRange")
    public List<Book> getBooksByPagesRange(
            @QueryParam("from") @XmlElement(required = true) int from,
            @QueryParam("to") @XmlElement(required = true) int to
    ) {
        return new BookDao(getConnection()).getBooksByPagesRange(from, to);
    }

    @GET
    @Path("byTitleAndAuthor")
    public List<Book> getBooksByTitleAndAuthor(
            @QueryParam("title") @XmlElement(required = true) String title,
            @QueryParam("author") @XmlElement(required = true) String author
    ) {
        return new BookDao(getConnection()).getBooksByTitleAndAuthor(title, author);
    }

    @GET
    @Path("byTitleAndPublishingHouse")
    public List<Book> getBooksByTitleAndPublishingHouse(
            @QueryParam("title") @XmlElement(required = true) String title,
            @QueryParam("publishingHouse") @XmlElement(required = true) String publishingHouse
    ) {
        return new BookDao(getConnection()).getBooksByTitleAndPublishingHouse(title, publishingHouse);
    }

    @GET
    @Path("byAuthorAndPublishingHouse")
    public List<Book> getBooksByAuthorAndPublishingHouse(
            @QueryParam("author") @XmlElement(required = true) String author,
            @QueryParam("publishingHouse") @XmlElement(required = true) String publishingHouse
    ) {
        return new BookDao(getConnection()).getBooksByAuthorAndPublishingHouse(author, publishingHouse);
    }

    @GET
    @Path("byAuthorAndMinPages")
    public List<Book> getBooksByAuthorAndMinPages(
            @QueryParam("author") @XmlElement(required = true) String author,
            @QueryParam("min") @XmlElement(required = true) int min
    ) {
        return new BookDao(getConnection()).getBooksByAuthorAndMinPages(author, min);
    }

    @GET
    @Path("byAuthorAndMaxPages")
    public List<Book> getBooksByAuthorAndMaxPages(
            @QueryParam("author") @XmlElement(required = true) String author,
            @QueryParam("max") @XmlElement(required = true) int max
    ) {
        return new BookDao(getConnection()).getBooksByAuthorAndMaxPages(author, max);
    }

    private Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return connection;
    }
}
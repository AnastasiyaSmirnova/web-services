package itmo.webservices.service;

import itmo.webservices.dao.BookDao;
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

    @GET()
    public List<Book> getBooks() {
        return new BookDao(getConnection()).getBooks();
    }

    @POST
    public long addBook(AddBookRequest newBook) {
        System.out.println("add book " + newBook);
        return new BookDao(getConnection())
                .addBook(
                        newBook.getTitle(),
                        newBook.getAuthor(),
                        newBook.getPublishingHouse(),
                        Language.valueOf(newBook.getLanguage()),
                        newBook.getPages()
                );
    }

    @PUT
    public QueryStatus updateBook(UpdateBookRequest book) {
        System.out.println("update book " + book);

        return new BookDao(getConnection()).updateBook(
                book.getUid(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublishingHouse(),
                Language.valueOf(book.getLanguage()),
                book.getPages()
        );
    }

    @DELETE
    @Path("{uid}")
    public QueryStatus deleteBook(@PathParam("uid") long uid) {
        System.out.println("delete book " + uid);
        return new BookDao(getConnection()).deleteBook(uid);
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
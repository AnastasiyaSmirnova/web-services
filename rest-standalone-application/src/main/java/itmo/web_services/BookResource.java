package itmo.web_services;

import itmo.web_services.dao.BookDao;
import itmo.web_services.model.Book;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Path("/books")
@Produces({MediaType.APPLICATION_JSON})
public class BookResource {

    private final BookDao bookDao;

    public BookResource() {
        bookDao = new BookDao();
    }

    @GET()
    public List<Book> getBooks() {
        return bookDao.getBooks();
    }

    @GET
    @Path("byTitle")
    public List<Book> getBooksByTitle(@QueryParam("title") @XmlElement(required = true) String title) {
        return bookDao.getBooksByTitle(title);
    }

    @GET
    @Path("byAuthor")
    public List<Book> getBooksByAuthor(@QueryParam("author") @XmlElement(required = true) String author) {
        return bookDao.getBooksByAuthor(author);
    }

    @GET
    @Path("byPublishingHouse")
    public List<Book> getBooksByPublishingHouse(@QueryParam("publishingHouse") @XmlElement(required = true) String publishingHouse) {
        return bookDao.getBooksByPublishingHouse(publishingHouse);
    }

    @GET
    @Path("byPagesRange")
    public List<Book> getBooksByPagesRange(
            @QueryParam("from") @XmlElement(required = true) int from,
            @QueryParam("to") @XmlElement(required = true) int to
    ) {
        return bookDao.getBooksByPagesRange(from, to);
    }

    @GET
    @Path("byTitleAndAuthor")
    public List<Book> getBooksByTitleAndAuthor(
            @QueryParam("title") @XmlElement(required = true) String title,
            @QueryParam("author") @XmlElement(required = true) String author
    ) {
        return bookDao.getBooksByTitleAndAuthor(title, author);
    }

    @GET
    @Path("byTitleAndPublishingHouse")
    public List<Book> getBooksByTitleAndPublishingHouse(
            @QueryParam("title") @XmlElement(required = true) String title,
            @QueryParam("publishingHouse") @XmlElement(required = true) String publishingHouse
    ) {
        return bookDao.getBooksByTitleAndPublishingHouse(title, publishingHouse);
    }

    @GET
    @Path("byAuthorAndPublishingHouse")
    public List<Book> getBooksByAuthorAndPublishingHouse(
            @QueryParam("author") @XmlElement(required = true) String author,
            @QueryParam("publishingHouse") @XmlElement(required = true) String publishingHouse
    ) {
        return bookDao.getBooksByAuthorAndPublishingHouse(author, publishingHouse);
    }

    @GET
    @Path("byAuthorAndMinPages")
    public List<Book> getBooksByAuthorAndMinPages(
            @QueryParam("author") @XmlElement(required = true) String author,
            @QueryParam("min") @XmlElement(required = true) int min
    ) {
        return bookDao.getBooksByAuthorAndMinPages(author, min);
    }

    @GET
    @Path("byAuthorAndMaxPages")
    public List<Book> getBooksByAuthorAndMaxPages(
            @QueryParam("author") @XmlElement(required = true) String author,
            @QueryParam("max") @XmlElement(required = true) int max
    ) {
        return bookDao.getBooksByAuthorAndMaxPages(author, max);
    }
}

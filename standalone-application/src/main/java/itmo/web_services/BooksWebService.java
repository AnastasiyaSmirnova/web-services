package itmo.web_services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "BookService")
public class BooksWebService {
    private final BookDao bookDao;

    public BooksWebService() {
        bookDao = new BookDao();
    }

    @WebMethod(operationName = "getBooks")
    public List<Book> getBooks() {
        return bookDao.getBooks();
    }
}

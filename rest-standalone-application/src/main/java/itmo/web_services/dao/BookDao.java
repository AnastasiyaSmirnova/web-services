package itmo.web_services.dao;

import itmo.web_services.dao.executor.Executor;
import itmo.web_services.model.Book;
import itmo.web_services.model.Language;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    private final Executor executor;

    public BookDao() {
        this.executor = new Executor();
    }


    public List<Book> getBooks() {
        return selectBooks("select * from books");
    }

    public List<Book> getBooksByTitle(String title) {
        return selectBooks("select * from books where title ='" + title + "'");
    }

    public List<Book> getBooksByAuthor(String author) {
        return selectBooks("select * from books where author ='" + author + "'");
    }

    public List<Book> getBooksByPublishingHouse(String publishingHouse) {
        return selectBooks("select * from books where publishing_house ='" + publishingHouse + "'");
    }

    public List<Book> getBooksByPagesRange(int from, int to) {
        return selectBooks("select * from books where pages > " + from + " and pages < " + to);
    }

    public List<Book> getBooksByTitleAndAuthor(String title, String author) {
        return selectBooks("select * from books where title ='" + title + "' and author = '" + author + "'");
    }

    public List<Book> getBooksByTitleAndPublishingHouse(String title, String publishingHouse) {
        return selectBooks("select * from books where title ='" + title + "' and publishing_house = '" + publishingHouse + "'");
    }

    public List<Book> getBooksByAuthorAndPublishingHouse(String author, String publishingHouse) {
        return selectBooks("select * from books where author ='" + author + "' and publishing_house = '" + publishingHouse + "'");
    }

    public List<Book> getBooksByAuthorAndMinPages(String author, int minPages) {
        return selectBooks("select * from books where author ='" + author + "' and pages > " + minPages);
    }

    public List<Book> getBooksByAuthorAndMaxPages(String author, int maxPages) {
        return selectBooks("select * from books where author ='" + author + "' and pages < " + maxPages);
    }

    private List<Book> selectBooks(String query) {
        List<Book> books = null;
        try {
            books = executor.execQuery(query, result -> {
                List<Book> arr = new ArrayList<>();
                while (result.next()) {
                    arr.add(generateBook(result));
                }
                return arr;
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    private Book generateBook(ResultSet result) throws SQLException {
        return new Book(result.getLong("id"),
                result.getString("title"),
                result.getString("author"),
                result.getString("publishing_house"),
                Language.valueOf(result.getString("language")),
                result.getInt("pages"));
    }
}

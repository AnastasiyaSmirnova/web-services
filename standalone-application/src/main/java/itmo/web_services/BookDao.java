package itmo.web_services;

import itmo.web_services.executor.Executor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookDao {
    private final Executor executor;

    public BookDao() {
        this.executor = new Executor();
    }

    public List<Book> getBooks() {
        List<Book> books = null;
        try {
            String query = "select * from books";
            books = executor.execQuery(query, result -> {
                List<Book> arr = new ArrayList<>();
                while (result.next()) {
                    arr.add(new Book(
                            result.getLong("id"),
                            result.getString("title"),
                            result.getString("author"),
                            result.getString("publishing_house"),
                            result.getInt("pages")
                    ));
                }
                return arr;
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}

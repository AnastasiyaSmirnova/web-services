package itmo.web_services;

import itmo.web_services.service.Book;
import itmo.web_services.service.BookService;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WebClient {
    private final BookService bookService;
    private final List<String> titles = new ArrayList<>();
    private final List<String> authors = new ArrayList<>();
    private final List<String> pubHouses = new ArrayList<>();

    public WebClient(String serverUrl) {
        URL url = null;
        try {
            url = new URL(serverUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        bookService = new BookService(url);
        run();
    }

    private void run() {
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\n");
        int next;
        getBooks();
        System.out.println("Choose the method:  " +
                "\n1 - get books by title " +
                "\n2 - get books by author " +
                "\n3 - get books by publishing house" +
                "\n4 - get book by pages range" +
                "\n5 - get books by title and author " +
                "\n6 - get books by title and publishing house" +
                "\n7 - get books by author and publishing house" +
                "\n8 - get books by author and min pages number " +
                "\n9 - get books by author and max pages number" +
                "\n10 - get books" +
                "\n0 - exit");

        while ((next = Integer.parseInt(in.nextLine())) > 0) {
            switch (next) {
                case 1: {
                    getBooksByTitle(in);
                    break;
                }
                case 2: {
                    getBooksByAuthor(in);
                    break;
                }
                case 3: {
                    getBooksByPubHouse(in);
                    break;
                }
                case 4: {
                    getBooksByPagesRange(in);
                    break;
                }
                case 5: {
                    getBooksByTitleAndAuthor(in);
                    break;
                }
                case 6: {
                    getBookByTitleAndPubHouse(in);
                    break;
                }
                case 7: {
                    getBookByAuthorAndPubHouse(in);
                    break;
                }
                case 8: {
                    getBooksByAuthorAndMinPages(in);
                    break;
                }
                case 9: {
                    getBooksByAuthorAndMaxPages(in);
                    break;
                }
                case 10: {
                    getBooks();
                    break;
                }
                default: {
                    System.out.println("unknown action");
                }

            }
        }
        in.close();
    }

    private void getBooks() {
        titles.clear();
        authors.clear();
        pubHouses.clear();

        List<Book> books = bookService.getBooksWebServicePort().getBooks();
        for (Book book : books) {
            titles.add(book.getTitle());
            authors.add(book.getAuthor());
            pubHouses.add(book.getPublishingHouse());
            System.out.println(book);
        }
    }

    private void getBooksByTitle(Scanner in) {
        String title = enterTitle(in);
        System.out.println(title);
        printResponse(
                bookService.getBooksWebServicePort().getBooksByTitle(title)
        );
    }

    private void getBooksByAuthor(Scanner in) {
        String author = enterAuthor(in);
        printResponse(
                bookService.getBooksWebServicePort().getBooksByAuthor(author)
        );
    }

    private void getBooksByPubHouse(Scanner in) {
        String name = enterPubHouse(in);
        printResponse(
                bookService.getBooksWebServicePort().getBooksByPublishingHouse(name)
        );
    }

    private void getBooksByPagesRange(Scanner in) {
        int min = enterMin(in);
        int max = enterMax(in);

        printResponse(
                bookService.getBooksWebServicePort().getBooksByPagesRange(min, max)
        );
    }

    private void getBooksByTitleAndAuthor(Scanner in) {
        String title = enterTitle(in);
        String author = enterAuthor(in);
        printResponse(
                bookService.getBooksWebServicePort().getBooksByTitleAndAuthor(title, author)
        );
    }


    private void getBookByTitleAndPubHouse(Scanner in) {
        String title = enterTitle(in);
        String pubHouse = enterPubHouse(in);
        printResponse(
                bookService.getBooksWebServicePort().getBooksByTitleAndPublishingHouse(title, pubHouse)
        );
    }

    private void getBookByAuthorAndPubHouse(Scanner in) {
        String author = enterAuthor(in);
        String pubHouse = enterPubHouse(in);
        printResponse(
                bookService.getBooksWebServicePort().getBooksByAuthorAndPublishingHouse(author, pubHouse)
        );
    }

    private void getBooksByAuthorAndMinPages(Scanner in) {
        String author = enterAuthor(in);
        int min = enterMin(in);
        printResponse(
                bookService.getBooksWebServicePort().getBooksByAuthorAndMinPages(author, min)
        );
    }

    private void getBooksByAuthorAndMaxPages(Scanner in) {
        String author = enterAuthor(in);
        int max = enterMax(in);
        printResponse(
                bookService.getBooksWebServicePort().getBooksByAuthorAndMaxPages(author, max)
        );
    }

    private String enterTitle(Scanner in) {
        System.out.println("Enter title. Possibles: " + printStringList(titles));
        return in.nextLine();
    }

    private String enterAuthor(Scanner in) {
        System.out.println("Enter author. Possibles: " + printStringList(authors));
        return in.nextLine();
    }

    private String enterPubHouse(Scanner in) {
        System.out.println("Enter publishing house name. Possibles: " + printStringList(pubHouses));
        return in.nextLine();
    }

    private int enterMin(Scanner in) {
        System.out.println("Enter min:");
        return Integer.parseInt(in.nextLine());
    }

    private int enterMax(Scanner in) {
        System.out.println("Enter max:");
        return Integer.parseInt(in.nextLine());
    }

    private void printResponse(List<Book> books) {
        System.out.println(books.size() + " records received:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private String printStringList(List<String> list) {
        return Arrays.toString(list.toArray());
    }

}

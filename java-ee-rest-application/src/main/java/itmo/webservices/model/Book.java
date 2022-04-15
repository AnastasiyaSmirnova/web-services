package itmo.webservices.model;

public class Book {
    private long id;
    private String title;
    private String author;
    private String publishingHouse;
    private Language language;
    private int pages;

    public Book() {
    }

    public Book(long id, String title, String author, String publishingHouse, Language language, int pages) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.language = language;
        this.pages = pages;
    }

    public Book(String title, String author, String publishingHouse, Language language, int pages) {
        this.title = title;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.language = language;
        this.pages = pages;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}

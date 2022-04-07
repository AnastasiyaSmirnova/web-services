package itmo.web_services.model;

public class Book {
    private long id;
    private String title;
    private String author;
    private String publishingHouse;
    private Language language;
    private int pages;

    public Book() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public Language getLanguage() {
        return language;
    }

    public int getPages() {
        return pages;
    }

    public Book(long id, String title, String author, String publishingHouse, Language language, int pages) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.language = language;
        this.pages = pages;
    }
}

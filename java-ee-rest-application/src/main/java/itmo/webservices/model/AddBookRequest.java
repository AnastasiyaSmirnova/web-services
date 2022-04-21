package itmo.webservices.model;

public class AddBookRequest {
    private String title;
    private String author;
    private String publishingHouse;
    private String language;
    private int pages;

    public AddBookRequest() {

    }

    public AddBookRequest(String title, String author, String publishingHouse, String language, int pages) {
        this.title = title;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.language = language;
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "AddBookRequest{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishingHouse='" + publishingHouse + '\'' +
                ", language='" + language + '\'' +
                ", pages=" + pages +
                '}';
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

    public String getString() {
        return language;
    }

    public void setString(String language) {
        this.language = language;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}

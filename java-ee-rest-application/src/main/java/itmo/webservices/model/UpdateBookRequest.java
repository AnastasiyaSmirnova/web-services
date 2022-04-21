package itmo.webservices.model;

public class UpdateBookRequest {
    private long uid;
    private String title;
    private String author;
    private String publishingHouse;
    private String language;
    private int pages;

    public UpdateBookRequest() {
    }

    public UpdateBookRequest(long uid, String title, String author, String publishingHouse, String language, int pages) {
        this.uid = uid;
        this.title = title;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.language = language;
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "UpdateBookRequest{" +
                "uid=" + uid +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishingHouse='" + publishingHouse + '\'' +
                ", language='" + language + '\'' +
                ", pages=" + pages +
                '}';
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}

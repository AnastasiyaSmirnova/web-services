package itmo.web_services.exception;

public class BookServiceFault {
    protected String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static BookServiceFault defaultInstance(String message) {
        BookServiceFault fault = new BookServiceFault();
        fault.setMessage(message);
        return fault;
    }
}

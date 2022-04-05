package itmo.web_services;

public class Main {
    public static void main(String[] args) {
        System.out.println("Client started");

        String url = "http://localhost:8080/BookService?wsdl"; // standalone client
//        String url = "http://desktop-kmrspqh:8080/books/BookService?wsdl"; // j2ee client
        new WebClient(url);

        System.out.println("Client finished");
    }
}

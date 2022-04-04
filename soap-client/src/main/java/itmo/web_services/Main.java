package itmo.web_services;

public class Main {
    public static void main(String[] args) {
        System.out.println("Client started");

        String url = "http://localhost:8080/BookService?wsdl";
        new WebClient(url);

        System.out.println("Client finished");
    }
}

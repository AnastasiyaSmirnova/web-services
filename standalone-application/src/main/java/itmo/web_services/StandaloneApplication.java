package itmo.web_services;

import javax.xml.ws.Endpoint;

public class StandaloneApplication {
    public static void main(String[] args) {
        String url = "http://localhost:8080/BookService";
        Endpoint.publish(url, new BooksWebService());

        System.out.println("Server started");
    }
}

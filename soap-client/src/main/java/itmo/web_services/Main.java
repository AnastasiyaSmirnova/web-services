package itmo.web_services;

import itmo.web_services.service.BooksWebService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        System.out.println("Client started");

        URL url = new URL("http://localhost:8080/BookService?wsdl");
        QName qName = new QName("http://service.web_services.itmo/", "BookService");
        Service service = Service.create(url, qName);

        QName port = new QName("http://service.web_services.itmo/", "BooksWebServicePort");
        BooksWebService bookService = service.getPort(port, BooksWebService.class);

        System.out.println(bookService.getImageAsString());
        System.out.println("Client finished");
    }
}

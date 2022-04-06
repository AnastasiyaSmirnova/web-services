package itmo.web_services;

import itmo.web_services.service.BooksWebService;

import javax.xml.ws.Endpoint;

public class StandaloneApplication {
    public static void main(String[] args) {
        System.setProperty("com.sun.xml.ws.fault.SOAPFaultBuilder.disableCaptureSt ackTrace", " false ");

        String url = "http://0.0.0.0:8080/BookService";
        Endpoint.publish(url, new BooksWebService());

        System.out.println("Server started");
    }
}

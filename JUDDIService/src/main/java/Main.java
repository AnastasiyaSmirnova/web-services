
import java.util.Scanner;

public class Main {
    private static final String DEFAULT_SERVICE_LOCATION = "http://localhost:8081/BookService?wsdl";

    public static void main(String[] args) {
        System.out.println("Select an action:" +
                "\n1 - registration" +
                "\n2 - browse" +
                "\n3 - find by name" +
                "\n0 - exit");

        Scanner in = new Scanner(System.in);
        int action;
        while ((action = Integer.parseInt(in.nextLine())) != 0) {
            switch (action) {
                case 1: {
                    System.out.println("Publish new service");
                    System.out.println("Enter business name: ");
                    String businessName = in.nextLine();

                    System.out.println("Enter service name: ");
                    String serviceName = in.nextLine();


                    System.out.println("Business " + businessName + ", service " + serviceName + " will be created");
//                    RegistrationService registrationService = new RegistrationService();
//                    registrationService.publish(businessName, serviceName, DEFAULT_SERVICE_LOCATION);
                    System.out.println("------------------------------------------------------------------" +
                            "\nEnter next:");
                    break;
                }
                case 2: {
                    System.out.println("Search service");
                    SearchService searchService = new SearchService();
                    searchService.Browse();
                    System.out.println("------------------------------------------------------------------" +
                            "\nEnter next");
                    break;
                }
                case 3: {
                    System.out.println("Find service");
                    System.out.println("Enter name: ");
                    String name = in.nextLine();
                    SearchService searchService = new SearchService();
                    searchService.findServiceByName(name);
                    System.out.println("------------------------------------------------------------------" +
                            "\nEnter next");
                    break;
                }
            }
        }
        System.out.println("Good bye =)");
    }
}

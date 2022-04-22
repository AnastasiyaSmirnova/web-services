package itmo.web_services.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(serviceName = "BookService")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface BooksWebService {

    @WebMethod(operationName = "getImageAsString")
    public String getImageAsString();
}



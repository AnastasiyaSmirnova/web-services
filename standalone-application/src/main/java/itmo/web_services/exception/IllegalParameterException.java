package itmo.web_services.exception;

import javax.xml.ws.WebFault;

@WebFault(faultBean = "itmo.web_services.exception.BookServiceFault")
public class IllegalParameterException extends Exception {
    private final BookServiceFault fault;

    public IllegalParameterException( BookServiceFault fault) {
        super(fault.getMessage());
        this.fault = fault;
    }

    public IllegalParameterException( BookServiceFault fault, Throwable cause) {
        super(fault.getMessage(), cause);
        this.fault = fault;
    }

    public BookServiceFault getFaultInfo() {
        return fault;
    }
}

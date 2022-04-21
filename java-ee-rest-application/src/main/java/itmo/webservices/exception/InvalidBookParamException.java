package itmo.webservices.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class InvalidBookParamException extends Exception implements ExceptionMapper<InvalidBookParamException> {

    public InvalidBookParamException(String msg) {
        super(msg);
    }

    @Override
    public Response toResponse(InvalidBookParamException exception) {
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(exception.getMessage())
                .build();
    }
}

package pets.pets_management.infrastructure;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pets.pets_management.infrastructure.error.ApiError;
import pets.pets_management.infrastructure.exception.DataNotFoundException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ApiError> handleDataNotFoundException(DataNotFoundException exception) {
        ApiError apiError = new ApiError();
        apiError.setTitle(exception.getTitle());
        apiError.setStatusCode(HttpStatus.NOT_FOUND.value());
        apiError.setDetail(exception.getDetail());
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }
}
package softtech.common;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import softtech.exception.NoDataToDisplayException;
import softtech.exception.SofttechDataNotFoundException;
import softtech.exception.SofttechValidationException;

@RestControllerAdvice
public class SofttechExceptionHandler {
    @ExceptionHandler(SofttechDataNotFoundException.class)
    public ExceptionResponse handleDataNotFoundException(SofttechDataNotFoundException exception){
        return new ExceptionResponse(exception.getExceptionType().getCode(),exception.getExceptionType().getMessage());
    }
    @ExceptionHandler(SofttechValidationException.class)
    public ExceptionResponse handleSofttechValidationException(SofttechValidationException exception){
        return new ExceptionResponse(exception.getExceptionType().getCode(),exception.getExceptionType().getMessage());
    }

    @ExceptionHandler(NoDataToDisplayException.class)
    public ExceptionResponse handleNoDataToDisplayException(NoDataToDisplayException exception){
        return new ExceptionResponse(exception.getExceptionType().getCode(),exception.getExceptionType().getMessage());
    }
}

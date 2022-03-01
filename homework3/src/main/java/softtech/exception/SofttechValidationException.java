package softtech.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public class SofttechValidationException extends RuntimeException{
    private final ExceptionType exceptionType;
}

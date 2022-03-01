package softtech.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SofttechDataNotFoundException extends RuntimeException{
    private final ExceptionType exceptionType;

}

package softtech.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionType {
    USER_DATA_NOT_FOUND(1001,"USER NOT FOUND"),
    PHONE_NUMBER_DOES_NOT_MATCHING(1002,"PHONE NUMBER DOES NOT MATCHING"),
    EMPTY_COMMENT_LIST(1003,"The product has no comments"),
    USER_HAS_NO_COMMENT(1004,"The user has not written any comments yet"),
    PHONE_NUMBER_ALREADY_EXIST(1005,"Phone number already exist"),
    USER_NAME_ALREADY_EXIST(1006,"Username already exist");
    private final int code;
    private final String message;
}

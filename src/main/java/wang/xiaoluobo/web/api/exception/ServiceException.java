package wang.xiaoluobo.web.api.exception;

import wang.xiaoluobo.web.api.enums.ServerResponseEnum;

public class ServiceException extends RuntimeException {

    private int code;

    private String message;

    public ServiceException(String message) {
        this(ServerResponseEnum.UNKNOWN_ERROR.getCode(), message);
    }

    public ServiceException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public ServiceException(ServerResponseEnum serverResponseEnum) {
        super(serverResponseEnum.getMessage());
        this.code = serverResponseEnum.getCode();
        this.message = serverResponseEnum.getMessage();
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}

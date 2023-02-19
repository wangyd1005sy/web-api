package wang.xiaoluobo.web.api.enums;

public enum ServerResponseEnum {

    SUCCESS(200, "SUCCESS"),
    REQUEST_FORBIDDEN(403, "REQUEST_FORBIDDEN"),
    REQUEST_NOT_FOUND(404, "REQUEST_NOT_FOUND"),
    REQUEST_METHOD_NOT_SUPPORT(405, "REQUEST_METHOD_NOT_SUPPORT"),
    UNKNOWN_ERROR(500, "UNKNOWN_ERROR"),

    NO_RIGHT(600, "无权限"),
    FAILED(601, "FAILED"),
    SESSION_INVALID(602, "请重新登录"),
    INVALID_USERNAME_PASSWORD(603, "用户名或密码不正确"),
    INVALID_PARAM(604, "INVALID_PARAM"),
    SINGLE_SIGN_ON_ONLY(620, "用户在其他端登录"),
    DATA_EXISTS(700, "数据已存在"),
    DATA_NOT_EXISTS(701, "数据不存在"),
    INVALID_TOKEN(702, "token已失效")
    ;

    private int code;
    private String message;

    ServerResponseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static String getCode(int index) {
        for (ServerResponseEnum serverResponseEnum : ServerResponseEnum.values()) {
            if (serverResponseEnum.getCode() == index) {
                return serverResponseEnum.message;
            }
        }
        return null;
    }
}

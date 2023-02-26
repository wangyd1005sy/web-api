package wang.xiaoluobo.web.api.dto;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import wang.xiaoluobo.web.api.enums.ServerResponseEnum;

import java.io.Serializable;

@Log4j2
@Getter
@Setter
public class ServerResponse<T> implements Serializable {

    private static final long serialVersionUID = -749717232714847902L;

    /**
     * 响应码
     */
    private int status;

    /**
     * JSON格式数据
     */
    private T data;

    /**
     * 错误信息
     * 可选项
     */
    private Object err;

    /**
     * 成功应答JSON格式据
     *
     * @param data
     * @return
     */
    public static <T> String success(T data) {
        ServerResponse<T> serverResponse = new ServerResponse<>();
        serverResponse.setStatus(ServerResponseEnum.SUCCESS.getCode());
        serverResponse.setData(data);
        String responseData = JSON.toJSONString(serverResponse);
        log.info("response data is {}", responseData);
        return responseData;
    }

    public static String fail(ServerResponseEnum serverResponseEnum) {
        ServerResponse serverResponse = new ServerResponse();
        serverResponse.setStatus(serverResponseEnum.getCode());
        serverResponse.setErr(serverResponseEnum.getMessage());
        String responseData = JSON.toJSONString(serverResponse);
        log.info("response data is {}", responseData);
        return responseData;
    }
}

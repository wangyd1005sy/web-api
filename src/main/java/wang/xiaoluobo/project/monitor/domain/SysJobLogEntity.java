package wang.xiaoluobo.project.monitor.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 定时任务调度日志表
 * </p>
 *
 * @author mybatis plus generator
 * @since 2023-03-19
 */
@Getter
@Setter
@TableName("sys_job_log")
@ApiModel(value = "SysJobLogEntity对象", description = "定时任务调度日志表")
public class SysJobLogEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("任务日志ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("任务名称")
    private String jobName;

    @ApiModelProperty("任务组名")
    private String jobGroup;

    @ApiModelProperty("调用目标字符串")
    private String invokeTarget;

    @ApiModelProperty("日志信息")
    private String jobMessage;

    @ApiModelProperty("执行状态（0正常 1失败）")
    private String status;

    @ApiModelProperty("异常信息")
    private String exceptionInfo;

    @ApiModelProperty("创建时间")
    private Date createTime;
}

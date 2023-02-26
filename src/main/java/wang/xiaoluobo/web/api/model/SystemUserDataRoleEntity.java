package wang.xiaoluobo.web.api.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 用户数据权限表
 * </p>
 *
 * @author mybatis plus generator
 * @since 2023-02-26
 */
@Getter
@Setter
@TableName("t_system_user_data_role")
@ApiModel(value = "SystemUserDataRoleEntity对象", description = "用户数据权限表")
public class SystemUserDataRoleEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("租户id")
    private Long tenantId;

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("资源id")
    private Long resourceId;

    @ApiModelProperty("状态，0：禁用，1：启用")
    private Byte status;

    @ApiModelProperty("生效开始时间")
    private Long effectStartTime;

    @ApiModelProperty("生效结束时间")
    private Long effectEndTime;

    @ApiModelProperty("创建人")
    private String createBy;

    @ApiModelProperty("创建时间")
    private Long createTime;

    @ApiModelProperty("创建人")
    private String modifyBy;

    @ApiModelProperty("修改时间")
    private Long modifyTime;
}

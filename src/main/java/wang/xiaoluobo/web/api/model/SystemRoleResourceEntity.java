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
 * 角色资源关系表
 * </p>
 *
 * @author mybatis plus generator
 * @since 2023-02-26
 */
@Getter
@Setter
@TableName("t_system_role_resource")
@ApiModel(value = "SystemRoleResourceEntity对象", description = "角色资源关系表")
public class SystemRoleResourceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("租户id")
    private Long tenantId;

    @ApiModelProperty("角色 ID")
    private Long roleId;

    @ApiModelProperty("资源 ID")
    private String resourceId;

    @ApiModelProperty("状态，0：禁用，1：启用")
    private Byte status;

    @ApiModelProperty("创建人")
    private String createBy;

    @ApiModelProperty("创建时间")
    private Long createTime;

    @ApiModelProperty("创建人")
    private String modifyBy;

    @ApiModelProperty("修改时间")
    private Long modifyTime;
}

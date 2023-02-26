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
 * 资源表
 * </p>
 *
 * @author mybatis plus generator
 * @since 2023-02-26
 */
@Getter
@Setter
@TableName("t_system_resource")
@ApiModel(value = "SystemResourceEntity对象", description = "资源表")
public class SystemResourceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("租户id")
    private Long tenantId;

    @ApiModelProperty("资源父id")
    private Long parentId;

    @ApiModelProperty("资源名称")
    private String name;

    @ApiModelProperty("资源描述")
    private String description;

    @ApiModelProperty("资源请求路径")
    private String resourcePath;

    @ApiModelProperty("icon样式")
    private String iconClass;

    @ApiModelProperty("类型，1：菜单，2：按钮")
    private Byte type;

    @ApiModelProperty("顺序")
    private Integer sortId;

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

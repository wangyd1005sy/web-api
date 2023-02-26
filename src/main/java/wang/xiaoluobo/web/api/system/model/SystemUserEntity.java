package wang.xiaoluobo.web.api.system.model;

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
 * 用户表
 * </p>
 *
 * @author mybatis plus generator
 * @since 2023-02-26
 */
@Getter
@Setter
@TableName("t_system_user")
@ApiModel(value = "SystemUserEntity对象", description = "用户表")
public class SystemUserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("租户id")
    private Long tenantId;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("手机号区号")
    private String areaCode;

    @ApiModelProperty("手机号")
    private String mobile;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("头像路径")
    private String headPicture;

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

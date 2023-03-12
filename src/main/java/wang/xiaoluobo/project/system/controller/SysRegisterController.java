package wang.xiaoluobo.project.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import wang.xiaoluobo.common.utils.StringUtils;
import wang.xiaoluobo.framework.security.RegisterBody;
import wang.xiaoluobo.framework.security.service.SysRegisterService;
import wang.xiaoluobo.framework.web.controller.BaseController;
import wang.xiaoluobo.framework.web.domain.AjaxResult;
import wang.xiaoluobo.project.system.service.ISysConfigService;

/**
 * 注册验证 */
@RestController
public class SysRegisterController extends BaseController
{
    @Autowired
    private SysRegisterService registerService;

    @Autowired
    private ISysConfigService configService;

    @PostMapping("/register")
    public AjaxResult register(@RequestBody RegisterBody user)
    {
        if (!("true".equals(configService.selectConfigByKey("sys.account.registerUser"))))
        {
            return error("当前系统没有开启注册功能！");
        }
        String msg = registerService.register(user);
        return StringUtils.isEmpty(msg) ? success() : error(msg);
    }
}

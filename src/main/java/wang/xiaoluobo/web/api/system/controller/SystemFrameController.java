package wang.xiaoluobo.web.api.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.xiaoluobo.web.api.system.service.SystemFrameService;

import javax.annotation.Resource;

/**
 * 系统权限controller
 */
@RestController
@RequestMapping("/systemFrame")
public class SystemFrameController {

    @Resource
    private SystemFrameService systemFrameService;

}

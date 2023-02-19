package wang.xiaoluobo.web.api.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;
import wang.xiaoluobo.web.api.dto.ServerResponse;
import wang.xiaoluobo.web.api.model.ProvinceEntity;
import wang.xiaoluobo.web.api.service.IProvinceService;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author mybatis plus generator
 * @since 2023-02-11
 */
@RestController
@RequestMapping("/province")
public class ProvinceController {

    @Resource
    private IProvinceService provinceService;

    @ApiOperation(value = "获取州省列表")
    @ApiImplicitParams({
    })
    @ApiResponses({
            @ApiResponse(code = 604, message = "INVALID_PARAM")
    })
    @RequestMapping(value = "/getProvinceList", method = {RequestMethod.GET})
    @ResponseBody
    public String getProvinceList(@RequestParam(required = false) String province) {
        Page<ProvinceEntity> page = provinceService.page(new Page<>(1, 10));
        return ServerResponse.toSuccessJSONString(page);
    }
}

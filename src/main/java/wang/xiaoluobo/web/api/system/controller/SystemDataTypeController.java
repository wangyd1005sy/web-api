package wang.xiaoluobo.web.api.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;
import wang.xiaoluobo.web.api.dto.ServerResponse;
import wang.xiaoluobo.web.api.system.model.SystemDataTypeEntity;
import wang.xiaoluobo.web.api.system.service.ISystemDataTypeService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/systemFrame/dataType")
public class SystemDataTypeController {

    @Resource
    private ISystemDataTypeService systemDataTypeService;

    @ApiOperation(value = "分页列表")
    @ApiImplicitParams({
    })
    @ApiResponses({
            @ApiResponse(code = 604, message = "INVALID_PARAM")
    })
    @RequestMapping(value = "/pageList", method = {RequestMethod.GET})
    @ResponseBody
    public String pageList(@RequestParam(value = "current", defaultValue = "1", required = false) int current,
                           @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
        Page<SystemDataTypeEntity> page = systemDataTypeService.page(new Page<>(current, pageSize));
        return ServerResponse.success(page);
    }

    @ApiOperation(value = "新增")
    @ApiImplicitParams({
    })
    @ApiResponses({
            @ApiResponse(code = 604, message = "INVALID_PARAM")
    })
    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    @ResponseBody
    public String add(@RequestBody SystemDataTypeEntity entity) {
        entity.setCreateBy("system");
        entity.setCreateTime(System.currentTimeMillis());
        entity.setModifyBy("system");
        entity.setModifyTime(System.currentTimeMillis());
        boolean flag = systemDataTypeService.save(entity);
        return ServerResponse.success(flag);
    }

    @ApiOperation(value = "修改")
    @ApiImplicitParams({
    })
    @ApiResponses({
            @ApiResponse(code = 604, message = "INVALID_PARAM")
    })
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    @ResponseBody
    public String update(@RequestBody SystemDataTypeEntity entity) {
        entity.setModifyBy("system");
        entity.setModifyTime(System.currentTimeMillis());
        boolean flag = systemDataTypeService.updateById(entity);
        return ServerResponse.success(flag);
    }

    @ApiOperation(value = "删除")
    @ApiImplicitParams({
    })
    @ApiResponses({
            @ApiResponse(code = 604, message = "INVALID_PARAM")
    })
    @RequestMapping(value = "/delete/{id}", method = {RequestMethod.GET})
    @ResponseBody
    public String delete(@PathVariable Long id) {
        boolean flag = systemDataTypeService.removeById(id);
        return ServerResponse.success(flag);
    }
}

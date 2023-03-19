package wang.xiaoluobo.project.monitor.controller;

import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.compress.utils.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.xiaoluobo.common.utils.bean.BeanUtils;
import wang.xiaoluobo.common.utils.poi.ExcelUtil;
import wang.xiaoluobo.framework.aspectj.lang.annotation.Log;
import wang.xiaoluobo.framework.aspectj.lang.enums.BusinessType;
import wang.xiaoluobo.framework.web.controller.BaseController;
import wang.xiaoluobo.framework.web.domain.AjaxResult;
import wang.xiaoluobo.framework.web.page.TableDataInfo;
import wang.xiaoluobo.project.monitor.domain.SysJobLog;
import wang.xiaoluobo.project.monitor.domain.SysJobLogEntity;
import wang.xiaoluobo.project.monitor.service.ISysJobLogService;

/**
 * 调度日志操作处理
 */
@RestController
@RequestMapping("/monitor/jobLog")
public class SysJobLogController extends BaseController {
    @Autowired
    private ISysJobLogService jobLogService;

    /**
     * 查询定时任务调度日志列表
     */
    @PreAuthorize("@ss.hasPermi('monitor:job:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysJobLog sysJobLog) {
//        startPage();
//        List<SysJobLog> list = jobLogService.selectJobLogList(sysJobLog);
        LambdaQueryWrapper<SysJobLogEntity> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(sysJobLog.getJobName())) {
            queryWrapper.like(SysJobLogEntity::getJobName, sysJobLog.getJobName());
        }
        if (StringUtils.isNotBlank(sysJobLog.getJobGroup())) {
            queryWrapper.eq(SysJobLogEntity::getJobGroup, sysJobLog.getJobGroup());
        }
        if (StringUtils.isNotBlank(sysJobLog.getStatus())) {
            queryWrapper.eq(SysJobLogEntity::getStatus, sysJobLog.getStatus());
        }
        if (StringUtils.isNotBlank(sysJobLog.getInvokeTarget())) {
            queryWrapper.like(SysJobLogEntity::getInvokeTarget, sysJobLog.getInvokeTarget());
        }
        if (StringUtils.isNotBlank(String.valueOf(sysJobLog.getParams().get("beginTime")))) {
            queryWrapper.ge(SysJobLogEntity::getCreateTime, sysJobLog.getParams().get("beginTime") + " 00:00:00");
        }
        if (StringUtils.isNotBlank(String.valueOf(sysJobLog.getParams().get("endTime")))) {
            queryWrapper.le(SysJobLogEntity::getInvokeTarget, sysJobLog.getParams().get("endTime") + " 23:59:59");
        }
        Page<SysJobLogEntity> page = jobLogService.page(new Page<>(), queryWrapper);
        return getDataTable(page.getRecords());
    }

    /**
     * 导出定时任务调度日志列表
     */
    @PreAuthorize("@ss.hasPermi('monitor:job:export')")
    @Log(title = "任务调度日志", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysJobLog sysJobLog) {
//        List<SysJobLog> list = jobLogService.selectJobLogList(sysJobLog);
        LambdaQueryWrapper<SysJobLogEntity> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(sysJobLog.getJobName())) {
            queryWrapper.like(SysJobLogEntity::getJobName, sysJobLog.getJobName());
        }
        if (StringUtils.isNotBlank(sysJobLog.getJobGroup())) {
            queryWrapper.eq(SysJobLogEntity::getJobGroup, sysJobLog.getJobGroup());
        }
        if (StringUtils.isNotBlank(sysJobLog.getStatus())) {
            queryWrapper.eq(SysJobLogEntity::getStatus, sysJobLog.getStatus());
        }
        if (StringUtils.isNotBlank(sysJobLog.getInvokeTarget())) {
            queryWrapper.like(SysJobLogEntity::getInvokeTarget, sysJobLog.getInvokeTarget());
        }
        if (StringUtils.isNotBlank(String.valueOf(sysJobLog.getParams().get("beginTime")))) {
            queryWrapper.ge(SysJobLogEntity::getCreateTime, sysJobLog.getParams().get("beginTime") + " 00:00:00");
        }
        if (StringUtils.isNotBlank(String.valueOf(sysJobLog.getParams().get("endTime")))) {
            queryWrapper.le(SysJobLogEntity::getInvokeTarget, sysJobLog.getParams().get("endTime") + " 23:59:59");
        }
        List<SysJobLogEntity> list = jobLogService.list(queryWrapper);
        List<SysJobLog> resultList = Lists.newArrayList();
        BeanUtils.copyBeanProp(resultList, list);
        ExcelUtil<SysJobLog> util = new ExcelUtil<>(SysJobLog.class);
        util.exportExcel(response, resultList, "调度日志");
    }

    /**
     * 根据调度编号获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('monitor:job:query')")
    @GetMapping(value = "/{jobLogId}")
    public AjaxResult getInfo(@PathVariable Long jobLogId) {
        return success(jobLogService.getById(jobLogId));
    }

    /**
     * 删除定时任务调度日志
     */
    @PreAuthorize("@ss.hasPermi('monitor:job:remove')")
    @Log(title = "定时任务调度日志", businessType = BusinessType.DELETE)
    @DeleteMapping("/{jobLogIds}")
    public AjaxResult remove(@PathVariable Long[] jobLogIds) {
        return toAjax(jobLogService.removeByIds(Arrays.asList(jobLogIds)));
    }

    /**
     * 清空定时任务调度日志
     */
    @PreAuthorize("@ss.hasPermi('monitor:job:remove')")
    @Log(title = "调度日志", businessType = BusinessType.CLEAN)
    @DeleteMapping("/clean")
    public AjaxResult clean() {
        LambdaQueryWrapper<SysJobLogEntity> queryWrapper = new LambdaQueryWrapper<>();
        jobLogService.remove(queryWrapper);
        return success();
    }
}

package com.ruoyi.web.controller.system;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.enums.OrderStatus;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.framework.security.context.AuthenticationContextHolder;
import com.ruoyi.system.domain.SysInvestOrder;
import com.ruoyi.system.service.ISysInvestOrderService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysInvestOrderStep;
import com.ruoyi.system.service.ISysInvestOrderStepService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订单拆分大步骤Controller
 * 
 * @author ruoyi
 * @date 2025-05-25
 */
@RestController
@RequestMapping("/system/step")
public class SysInvestOrderStepController extends BaseController
{
    @Autowired
    private ISysInvestOrderStepService sysInvestOrderStepService;

    @Autowired
    private ISysInvestOrderService sysInvestOrderService;
    /**
     * 查询订单拆分大步骤列表
     */
    @PreAuthorize("@ss.hasPermi('system:step:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysInvestOrderStep sysInvestOrderStep)
    {
        startPage();
        List<SysInvestOrderStep> list = sysInvestOrderStepService.selectSysInvestOrderStepList(sysInvestOrderStep);
        return getDataTable(list);
    }

    /**
     * 导出订单拆分大步骤列表
     */
    @PreAuthorize("@ss.hasPermi('system:step:export')")
    @Log(title = "订单拆分大步骤", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysInvestOrderStep sysInvestOrderStep)
    {
        List<SysInvestOrderStep> list = sysInvestOrderStepService.selectSysInvestOrderStepList(sysInvestOrderStep);
        ExcelUtil<SysInvestOrderStep> util = new ExcelUtil<SysInvestOrderStep>(SysInvestOrderStep.class);
        util.exportExcel(response, list, "订单拆分大步骤数据");
    }

    /**
     * 获取订单拆分大步骤详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:step:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(sysInvestOrderStepService.selectSysInvestOrderStepById(id));
    }

    /**
     * 新增订单拆分大步骤
     */
    @PreAuthorize("@ss.hasPermi('system:step:add')")
    @Log(title = "订单拆分大步骤", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysInvestOrderStep sysInvestOrderStep)
    {
        return toAjax(sysInvestOrderStepService.insertSysInvestOrderStep(sysInvestOrderStep));
    }

    /**
     * 修改订单拆分大步骤
     */
    @PreAuthorize("@ss.hasPermi('system:step:edit')")
    @Log(title = "订单拆分大步骤", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysInvestOrderStep sysInvestOrderStep)
    {
        return toAjax(sysInvestOrderStepService.updateSysInvestOrderStep(sysInvestOrderStep));
    }

    @PreAuthorize("@ss.hasPermi('system:step:edit')")
    @Log(title = "订单拆分大步骤", businessType = BusinessType.UPDATE)
    @PostMapping(value = "/update_config")
    public AjaxResult updateConfig(@RequestBody SysInvestOrderStep sysInvestOrderStep) throws Exception {
        //管理员、订单交易员可以更改配置
        LoginUser user = SecurityUtils.getLoginUser();
        SysInvestOrder order = sysInvestOrderService.selectSysInvestOrderByOrderId(sysInvestOrderStep.getOrderId());
        if(null==order){
            throw new Exception("订单不存在");
        }
        if(Objects.equals(OrderStatus.FARM.getCode(), order.getOrderStatus())){
            return AjaxResult.success();
        }
        boolean hasPermission = false;
        if(user.getUser().isAdmin()){
            hasPermission = true;
        }else{
           if(Objects.equals(user.getUserId(), order.getTraderId())){
               hasPermission = true;
           }
        }
        if(hasPermission){
            sysInvestOrderStep.setUpdateTime(new Date());
            sysInvestOrderStep.setUpdateBy(getUsername());
            sysInvestOrderStep.setOrderStepStatus(null);
            if(sysInvestOrderStep.getStepMode()=="rate"){
                sysInvestOrderStep.setStepValueType("NUMBER");
            }else{
                sysInvestOrderStep.setStepValueType("USDT");
            }
            //TODO 对margin、spot-perp做参数校验
            return toAjax(sysInvestOrderStepService.updateSysInvestOrderStep(sysInvestOrderStep));
        }else{
            throw  new Exception("权限不足");
        }

    }

    @PreAuthorize("@ss.hasPermi('system:step:edit')")
    @Log(title = "订单拆分大步骤", businessType = BusinessType.UPDATE)
    @PostMapping(value = "/update_status")
    public AjaxResult updateStatus(@RequestBody SysInvestOrderStep sysInvestOrderStep)
    {
        return toAjax(sysInvestOrderStepService.updateSysInvestOrderStep(sysInvestOrderStep));
    }

    /**
     * 删除订单拆分大步骤
     */
    @PreAuthorize("@ss.hasPermi('system:step:remove')")
    @Log(title = "订单拆分大步骤", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysInvestOrderStepService.deleteSysInvestOrderStepByIds(ids));
    }
}

package com.ruoyi.web.controller.system;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.system.domain.SysInvestOrder;
import com.ruoyi.system.domain.SysInvestStat;
import com.ruoyi.system.service.ISysInvestOrderService;
import com.ruoyi.system.service.ISysInvestStatService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.ruoyi.system.domain.SysInvestProfit;
import com.ruoyi.system.service.ISysInvestProfitService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 实际收益信息记录Controller
 * 
 * @author ruoyi
 * @date 2025-06-01
 */
@RestController
@RequestMapping("/system/profit")
public class SysInvestProfitController extends BaseController
{
    @Autowired
    private ISysInvestProfitService sysInvestProfitService;

    @Autowired
    private ISysInvestStatService sysInvestStatService;

    @Autowired
    private ISysInvestOrderService sysInvestOrderService;
    /**
     * 查询实际收益信息记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:profit:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysInvestProfit sysInvestProfit)
    {
        startPage();
        List<SysInvestProfit> list = sysInvestProfitService.selectSysInvestProfitList(sysInvestProfit);
        return getDataTable(list);
    }

    /**
     * 导出实际收益信息记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:profit:export')")
    @Log(title = "实际收益信息记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysInvestProfit sysInvestProfit)
    {
        List<SysInvestProfit> list = sysInvestProfitService.selectSysInvestProfitList(sysInvestProfit);
        ExcelUtil<SysInvestProfit> util = new ExcelUtil<SysInvestProfit>(SysInvestProfit.class);
        util.exportExcel(response, list, "实际收益信息记录数据");
    }

    /**
     * 获取实际收益信息记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:profit:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(sysInvestProfitService.selectSysInvestProfitById(id));
    }

    /**
     * 新增实际收益信息记录
     */
    @PreAuthorize("@ss.hasPermi('system:profit:add')")
    @Log(title = "实际收益信息记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysInvestProfit sysInvestProfit)
    {
        return toAjax(sysInvestProfitService.insertSysInvestProfit(sysInvestProfit));
    }

    /**
     * 修改实际收益信息记录
     */
    @PreAuthorize("@ss.hasPermi('system:profit:edit')")
    @Log(title = "实际收益信息记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysInvestProfit sysInvestProfit)
    {
        return toAjax(sysInvestProfitService.updateSysInvestProfit(sysInvestProfit));
    }

    /**
     * 删除实际收益信息记录
     */
    @PreAuthorize("@ss.hasPermi('system:profit:remove')")
    @Log(title = "实际收益信息记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysInvestProfitService.deleteSysInvestProfitByIds(ids));
    }

    /**
     * 查询最新的收益记录
     */
    @PreAuthorize("@ss.hasPermi('system:profit:list')")
    @GetMapping("/latest_profit")
    public AjaxResult get_latest_profit()
    {
        AjaxResult ajaxResult=AjaxResult.success();
        SysInvestStat sysInvestStat = new SysInvestStat();
        sysInvestStat.setStatTypeCode("profit");
        List<SysInvestStat> sysInvestStats =   sysInvestStatService.selectSysInvestStatList(sysInvestStat);
        Date statDay = sysInvestStats.get(0).getDay();
        SysInvestOrder sysInvestOrder = new SysInvestOrder();
        LoginUser user = getLoginUser();
        if(user.getUser().isInvestor()){
            sysInvestOrder.setBuyerId(user.getUserId());
        }else if(user.getUser().isTrader()){
            sysInvestOrder.setTraderId(user.getUserId());
        }
        List<SysInvestOrder> list = sysInvestOrderService.selectSysInvestOrderList(sysInvestOrder);
        List<String> orderIds = new ArrayList<>();
        for(SysInvestOrder o:list){
            if(o.getOrderStatus()!=7){
                orderIds.add(o.getOrderId());
            }
        }

        Date beginDate = new Date(statDay.getTime() - 6 * 24 * 60 * 60 * 1000);
        List<SysInvestProfit> sysInvestProfits = sysInvestProfitService.selectSysInvestProfitListByOrder(orderIds,beginDate,statDay);
        ajaxResult.put(AjaxResult.DATA_TAG,sysInvestProfits);
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(statDay);
        ajaxResult.put("day",formattedDate);
        return ajaxResult;
    }
}

package com.ruoyi.web.controller.system;

import java.util.List;
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
import com.ruoyi.system.domain.SysInvestTxRecord;
import com.ruoyi.system.service.ISysInvestTxRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2025-06-11
 */
@RestController
@RequestMapping("/system/record")
public class SysInvestTxRecordController extends BaseController
{
    @Autowired
    private ISysInvestTxRecordService sysInvestTxRecordService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:record:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysInvestTxRecord sysInvestTxRecord)
    {
        startPage();
        List<SysInvestTxRecord> list = sysInvestTxRecordService.selectSysInvestTxRecordList(sysInvestTxRecord);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('system:record:list')")
    @GetMapping("/list_all")
    public List<SysInvestTxRecord> listByOrderId(SysInvestTxRecord sysInvestTxRecord)
    {
        List<SysInvestTxRecord> list = sysInvestTxRecordService.selectSysInvestTxRecordList(sysInvestTxRecord);
        return list;
    }


    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:record:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysInvestTxRecord sysInvestTxRecord)
    {
        List<SysInvestTxRecord> list = sysInvestTxRecordService.selectSysInvestTxRecordList(sysInvestTxRecord);
        ExcelUtil<SysInvestTxRecord> util = new ExcelUtil<SysInvestTxRecord>(SysInvestTxRecord.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:record:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(sysInvestTxRecordService.selectSysInvestTxRecordById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:record:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysInvestTxRecord sysInvestTxRecord)
    {
        return toAjax(sysInvestTxRecordService.insertSysInvestTxRecord(sysInvestTxRecord));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:record:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysInvestTxRecord sysInvestTxRecord)
    {
        return toAjax(sysInvestTxRecordService.updateSysInvestTxRecord(sysInvestTxRecord));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:record:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysInvestTxRecordService.deleteSysInvestTxRecordByIds(ids));
    }
}

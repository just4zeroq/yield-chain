package com.ruoyi.web.controller.system;


import java.util.Date;
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
import com.ruoyi.system.domain.SysInvestProduct;
import com.ruoyi.system.service.ISysInvestProductService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 产品管理Controller
 * 
 * @author ruoyi
 * @date 2025-05-10
 */
@RestController
@RequestMapping("/system/product")
public class SysInvestProductController extends BaseController
{
    @Autowired
    private ISysInvestProductService sysInvestProductService;

    /**
     * 查询产品管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:product:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysInvestProduct sysInvestProduct)
    {
        startPage();
        List<SysInvestProduct> list = sysInvestProductService.selectSysInvestProductList(sysInvestProduct);
        return getDataTable(list);
    }

    /**
     * 查询产品管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:product:list')")
    @GetMapping("/list_all")
    public AjaxResult listProduct(SysInvestProduct sysInvestProduct)
    {
//        SysInvestProduct sysInvestProduct = new SysInvestProduct();
        if(sysInvestProduct.getEndTime() ==null){
            sysInvestProduct.setEndTime(new Date());
        }
//        sysInvestProduct.setEndTime(new Date());
        List<SysInvestProduct> list = sysInvestProductService.selectSysInvestProductList(sysInvestProduct);
        return AjaxResult.success(list);
    }

    /**
     * 导出产品管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:product:export')")
    @Log(title = "产品管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysInvestProduct sysInvestProduct)
    {
        List<SysInvestProduct> list = sysInvestProductService.selectSysInvestProductList(sysInvestProduct);
        ExcelUtil<SysInvestProduct> util = new ExcelUtil<SysInvestProduct>(SysInvestProduct.class);
        util.exportExcel(response, list, "产品管理数据");
    }

    /**
     * 获取产品管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:product:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(sysInvestProductService.selectSysInvestProductById(id));
    }

    /**
     * 新增产品管理
     */
    @PreAuthorize("@ss.hasPermi('system:product:add')")
    @Log(title = "产品管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysInvestProduct sysInvestProduct)
    {
        return toAjax(sysInvestProductService.insertSysInvestProduct(sysInvestProduct));
    }

    /**
     * 修改产品管理
     */
    @PreAuthorize("@ss.hasPermi('system:product:edit')")
    @Log(title = "产品管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysInvestProduct sysInvestProduct)
    {
        return toAjax(sysInvestProductService.updateSysInvestProduct(sysInvestProduct));
    }

    /**
     * 删除产品管理
     */
    @PreAuthorize("@ss.hasPermi('system:product:remove')")
    @Log(title = "产品管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysInvestProductService.deleteSysInvestProductByIds(ids));
    }
}

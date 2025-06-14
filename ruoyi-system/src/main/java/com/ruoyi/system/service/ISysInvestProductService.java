package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysInvestProduct;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2025-05-10
 */
public interface ISysInvestProductService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public SysInvestProduct selectSysInvestProductById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysInvestProduct 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SysInvestProduct> selectSysInvestProductList(SysInvestProduct sysInvestProduct);

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysInvestProduct 【请填写功能名称】
     * @return 结果
     */
    public int insertSysInvestProduct(SysInvestProduct sysInvestProduct);

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysInvestProduct 【请填写功能名称】
     * @return 结果
     */
    public int updateSysInvestProduct(SysInvestProduct sysInvestProduct);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteSysInvestProductByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSysInvestProductById(Long id);
}

package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysInvestProductMapper;
import com.ruoyi.system.domain.SysInvestProduct;
import com.ruoyi.system.service.ISysInvestProductService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-05-10
 */
@Service
public class SysInvestProductServiceImpl implements ISysInvestProductService 
{
    @Autowired
    private SysInvestProductMapper sysInvestProductMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public SysInvestProduct selectSysInvestProductById(Long id)
    {
        return sysInvestProductMapper.selectSysInvestProductById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysInvestProduct 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<SysInvestProduct> selectSysInvestProductList(SysInvestProduct sysInvestProduct)
    {
        return sysInvestProductMapper.selectSysInvestProductList(sysInvestProduct);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysInvestProduct 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSysInvestProduct(SysInvestProduct sysInvestProduct)
    {
        sysInvestProduct.setCreateTime(DateUtils.getNowDate());
        return sysInvestProductMapper.insertSysInvestProduct(sysInvestProduct);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysInvestProduct 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSysInvestProduct(SysInvestProduct sysInvestProduct)
    {
        sysInvestProduct.setUpdateTime(DateUtils.getNowDate());
        return sysInvestProductMapper.updateSysInvestProduct(sysInvestProduct);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysInvestProductByIds(Long[] ids)
    {
        return sysInvestProductMapper.deleteSysInvestProductByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysInvestProductById(Long id)
    {
        return sysInvestProductMapper.deleteSysInvestProductById(id);
    }
}

package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysInvestOrderSubStep;

/**
 * 订单拆分子步骤Mapper接口
 * 
 * @author ruoyi
 * @date 2025-05-25
 */
public interface SysInvestOrderSubStepMapper 
{
    /**
     * 查询订单拆分子步骤
     * 
     * @param id 订单拆分子步骤主键
     * @return 订单拆分子步骤
     */
    public SysInvestOrderSubStep selectSysInvestOrderSubStepById(Long id);

    /**
     * 查询订单拆分子步骤列表
     * 
     * @param sysInvestOrderSubStep 订单拆分子步骤
     * @return 订单拆分子步骤集合
     */
    public List<SysInvestOrderSubStep> selectSysInvestOrderSubStepList(SysInvestOrderSubStep sysInvestOrderSubStep);

    /**
     * 新增订单拆分子步骤
     * 
     * @param sysInvestOrderSubStep 订单拆分子步骤
     * @return 结果
     */
    public int insertSysInvestOrderSubStep(SysInvestOrderSubStep sysInvestOrderSubStep);

    /**
     * 修改订单拆分子步骤
     * 
     * @param sysInvestOrderSubStep 订单拆分子步骤
     * @return 结果
     */
    public int updateSysInvestOrderSubStep(SysInvestOrderSubStep sysInvestOrderSubStep);

    /**
     * 删除订单拆分子步骤
     * 
     * @param id 订单拆分子步骤主键
     * @return 结果
     */
    public int deleteSysInvestOrderSubStepById(Long id);

    /**
     * 批量删除订单拆分子步骤
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysInvestOrderSubStepByIds(Long[] ids);
}

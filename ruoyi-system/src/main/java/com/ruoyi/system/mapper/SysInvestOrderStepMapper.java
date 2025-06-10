package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysInvestOrderStep;

/**
 * 订单拆分大步骤Mapper接口
 * 
 * @author ruoyi
 * @date 2025-05-25
 */
public interface SysInvestOrderStepMapper 
{
    /**
     * 查询订单拆分大步骤
     * 
     * @param id 订单拆分大步骤主键
     * @return 订单拆分大步骤
     */
    public SysInvestOrderStep selectSysInvestOrderStepById(Long id);

    /**
     * 查询订单拆分大步骤列表
     * 
     * @param sysInvestOrderStep 订单拆分大步骤
     * @return 订单拆分大步骤集合
     */
    public List<SysInvestOrderStep> selectSysInvestOrderStepList(SysInvestOrderStep sysInvestOrderStep);

    /**
     * 新增订单拆分大步骤
     * 
     * @param sysInvestOrderStep 订单拆分大步骤
     * @return 结果
     */
    public int insertSysInvestOrderStep(SysInvestOrderStep sysInvestOrderStep);

    /**
     * 修改订单拆分大步骤
     * 
     * @param sysInvestOrderStep 订单拆分大步骤
     * @return 结果
     */
    public int updateSysInvestOrderStep(SysInvestOrderStep sysInvestOrderStep);

    /**
     * 删除订单拆分大步骤
     * 
     * @param id 订单拆分大步骤主键
     * @return 结果
     */
    public int deleteSysInvestOrderStepById(Long id);

    /**
     * 批量删除订单拆分大步骤
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysInvestOrderStepByIds(Long[] ids);

    /**
     * 批量插入订单拆分大步骤
     * 
     * @param sysInvestOrderStepList 订单拆分大步骤列表
     * @return 结果
     */
    public int insertSysInvestOrderStepList(List<SysInvestOrderStep> sysInvestOrderStepList);
}

package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysInvestOrderSubStepMapper;
import com.ruoyi.system.domain.SysInvestOrderSubStep;
import com.ruoyi.system.service.ISysInvestOrderSubStepService;

/**
 * 订单拆分子步骤Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-05-25
 */
@Service
public class SysInvestOrderSubStepServiceImpl implements ISysInvestOrderSubStepService 
{
    @Autowired
    private SysInvestOrderSubStepMapper sysInvestOrderSubStepMapper;

    /**
     * 查询订单拆分子步骤
     * 
     * @param id 订单拆分子步骤主键
     * @return 订单拆分子步骤
     */
    @Override
    public SysInvestOrderSubStep selectSysInvestOrderSubStepById(Long id)
    {
        return sysInvestOrderSubStepMapper.selectSysInvestOrderSubStepById(id);
    }

    /**
     * 查询订单拆分子步骤列表
     * 
     * @param sysInvestOrderSubStep 订单拆分子步骤
     * @return 订单拆分子步骤
     */
    @Override
    public List<SysInvestOrderSubStep> selectSysInvestOrderSubStepList(SysInvestOrderSubStep sysInvestOrderSubStep)
    {
        return sysInvestOrderSubStepMapper.selectSysInvestOrderSubStepList(sysInvestOrderSubStep);
    }

    /**
     * 新增订单拆分子步骤
     * 
     * @param sysInvestOrderSubStep 订单拆分子步骤
     * @return 结果
     */
    @Override
    public int insertSysInvestOrderSubStep(SysInvestOrderSubStep sysInvestOrderSubStep)
    {
        sysInvestOrderSubStep.setCreateTime(DateUtils.getNowDate());
        return sysInvestOrderSubStepMapper.insertSysInvestOrderSubStep(sysInvestOrderSubStep);
    }

    /**
     * 修改订单拆分子步骤
     * 
     * @param sysInvestOrderSubStep 订单拆分子步骤
     * @return 结果
     */
    @Override
    public int updateSysInvestOrderSubStep(SysInvestOrderSubStep sysInvestOrderSubStep)
    {
        sysInvestOrderSubStep.setUpdateTime(DateUtils.getNowDate());
        return sysInvestOrderSubStepMapper.updateSysInvestOrderSubStep(sysInvestOrderSubStep);
    }

    /**
     * 批量删除订单拆分子步骤
     * 
     * @param ids 需要删除的订单拆分子步骤主键
     * @return 结果
     */
    @Override
    public int deleteSysInvestOrderSubStepByIds(Long[] ids)
    {
        return sysInvestOrderSubStepMapper.deleteSysInvestOrderSubStepByIds(ids);
    }

    /**
     * 删除订单拆分子步骤信息
     * 
     * @param id 订单拆分子步骤主键
     * @return 结果
     */
    @Override
    public int deleteSysInvestOrderSubStepById(Long id)
    {
        return sysInvestOrderSubStepMapper.deleteSysInvestOrderSubStepById(id);
    }
}

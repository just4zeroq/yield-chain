package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysInvestOrderStepMapper;
import com.ruoyi.system.domain.SysInvestOrderStep;
import com.ruoyi.system.service.ISysInvestOrderStepService;

/**
 * 订单拆分大步骤Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-05-25
 */
@Service
public class SysInvestOrderStepServiceImpl implements ISysInvestOrderStepService 
{
    @Autowired
    private SysInvestOrderStepMapper sysInvestOrderStepMapper;

    /**
     * 查询订单拆分大步骤
     * 
     * @param id 订单拆分大步骤主键
     * @return 订单拆分大步骤
     */
    @Override
    public SysInvestOrderStep selectSysInvestOrderStepById(Long id)
    {
        return sysInvestOrderStepMapper.selectSysInvestOrderStepById(id);
    }

    /**
     * 查询订单拆分大步骤列表
     * 
     * @param sysInvestOrderStep 订单拆分大步骤
     * @return 订单拆分大步骤
     */
    @Override
    public List<SysInvestOrderStep> selectSysInvestOrderStepList(SysInvestOrderStep sysInvestOrderStep)
    {
        return sysInvestOrderStepMapper.selectSysInvestOrderStepList(sysInvestOrderStep);
    }

    /**
     * 新增订单拆分大步骤
     * 
     * @param sysInvestOrderStep 订单拆分大步骤
     * @return 结果
     */
    @Override
    public int insertSysInvestOrderStep(SysInvestOrderStep sysInvestOrderStep)
    {
        sysInvestOrderStep.setCreateTime(DateUtils.getNowDate());
        return sysInvestOrderStepMapper.insertSysInvestOrderStep(sysInvestOrderStep);
    }

    @Override
    public void insertSysInvestOrderStepList(List<SysInvestOrderStep> sysInvestOrderStepList) {
        sysInvestOrderStepMapper.insertSysInvestOrderStepList(sysInvestOrderStepList);
    }

    /**
     * 修改订单拆分大步骤
     * 
     * @param sysInvestOrderStep 订单拆分大步骤
     * @return 结果
     */
    @Override
    public int updateSysInvestOrderStep(SysInvestOrderStep sysInvestOrderStep)
    {
        sysInvestOrderStep.setUpdateTime(DateUtils.getNowDate());
        return sysInvestOrderStepMapper.updateSysInvestOrderStep(sysInvestOrderStep);
    }

    /**
     * 批量删除订单拆分大步骤
     * 
     * @param ids 需要删除的订单拆分大步骤主键
     * @return 结果
     */
    @Override
    public int deleteSysInvestOrderStepByIds(Long[] ids)
    {
        return sysInvestOrderStepMapper.deleteSysInvestOrderStepByIds(ids);
    }

    /**
     * 删除订单拆分大步骤信息
     * 
     * @param id 订单拆分大步骤主键
     * @return 结果
     */
    @Override
    public int deleteSysInvestOrderStepById(Long id)
    {
        return sysInvestOrderStepMapper.deleteSysInvestOrderStepById(id);
    }
}

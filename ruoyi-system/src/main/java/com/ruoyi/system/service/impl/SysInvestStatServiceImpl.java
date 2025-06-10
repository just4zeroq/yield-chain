package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysInvestStatMapper;
import com.ruoyi.system.domain.SysInvestStat;
import com.ruoyi.system.service.ISysInvestStatService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-06-01
 */
@Service
public class SysInvestStatServiceImpl implements ISysInvestStatService 
{
    @Autowired
    private SysInvestStatMapper sysInvestStatMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public SysInvestStat selectSysInvestStatById(Long id)
    {
        return sysInvestStatMapper.selectSysInvestStatById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysInvestStat 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<SysInvestStat> selectSysInvestStatList(SysInvestStat sysInvestStat)
    {
        return sysInvestStatMapper.selectSysInvestStatList(sysInvestStat);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysInvestStat 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSysInvestStat(SysInvestStat sysInvestStat)
    {
        return sysInvestStatMapper.insertSysInvestStat(sysInvestStat);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysInvestStat 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSysInvestStat(SysInvestStat sysInvestStat)
    {
        return sysInvestStatMapper.updateSysInvestStat(sysInvestStat);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysInvestStatByIds(Long[] ids)
    {
        return sysInvestStatMapper.deleteSysInvestStatByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysInvestStatById(Long id)
    {
        return sysInvestStatMapper.deleteSysInvestStatById(id);
    }
}

package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysInvestStat;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2025-06-01
 */
public interface ISysInvestStatService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public SysInvestStat selectSysInvestStatById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysInvestStat 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SysInvestStat> selectSysInvestStatList(SysInvestStat sysInvestStat);

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysInvestStat 【请填写功能名称】
     * @return 结果
     */
    public int insertSysInvestStat(SysInvestStat sysInvestStat);

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysInvestStat 【请填写功能名称】
     * @return 结果
     */
    public int updateSysInvestStat(SysInvestStat sysInvestStat);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteSysInvestStatByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSysInvestStatById(Long id);
}

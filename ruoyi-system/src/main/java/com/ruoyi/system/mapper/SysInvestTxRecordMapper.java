package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysInvestTxRecord;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2025-06-11
 */
public interface SysInvestTxRecordMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public SysInvestTxRecord selectSysInvestTxRecordById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysInvestTxRecord 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SysInvestTxRecord> selectSysInvestTxRecordList(SysInvestTxRecord sysInvestTxRecord);

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysInvestTxRecord 【请填写功能名称】
     * @return 结果
     */
    public int insertSysInvestTxRecord(SysInvestTxRecord sysInvestTxRecord);

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysInvestTxRecord 【请填写功能名称】
     * @return 结果
     */
    public int updateSysInvestTxRecord(SysInvestTxRecord sysInvestTxRecord);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSysInvestTxRecordById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysInvestTxRecordByIds(Long[] ids);
}

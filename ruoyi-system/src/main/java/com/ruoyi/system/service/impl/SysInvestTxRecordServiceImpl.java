package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysInvestTxRecordMapper;
import com.ruoyi.system.domain.SysInvestTxRecord;
import com.ruoyi.system.service.ISysInvestTxRecordService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-06-11
 */
@Service
public class SysInvestTxRecordServiceImpl implements ISysInvestTxRecordService 
{
    @Autowired
    private SysInvestTxRecordMapper sysInvestTxRecordMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public SysInvestTxRecord selectSysInvestTxRecordById(Long id)
    {
        return sysInvestTxRecordMapper.selectSysInvestTxRecordById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysInvestTxRecord 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<SysInvestTxRecord> selectSysInvestTxRecordList(SysInvestTxRecord sysInvestTxRecord)
    {
        return sysInvestTxRecordMapper.selectSysInvestTxRecordList(sysInvestTxRecord);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysInvestTxRecord 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSysInvestTxRecord(SysInvestTxRecord sysInvestTxRecord)
    {
        sysInvestTxRecord.setCreateTime(DateUtils.getNowDate());
        return sysInvestTxRecordMapper.insertSysInvestTxRecord(sysInvestTxRecord);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysInvestTxRecord 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSysInvestTxRecord(SysInvestTxRecord sysInvestTxRecord)
    {
        sysInvestTxRecord.setUpdateTime(DateUtils.getNowDate());
        return sysInvestTxRecordMapper.updateSysInvestTxRecord(sysInvestTxRecord);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysInvestTxRecordByIds(Long[] ids)
    {
        return sysInvestTxRecordMapper.deleteSysInvestTxRecordByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysInvestTxRecordById(Long id)
    {
        return sysInvestTxRecordMapper.deleteSysInvestTxRecordById(id);
    }
}

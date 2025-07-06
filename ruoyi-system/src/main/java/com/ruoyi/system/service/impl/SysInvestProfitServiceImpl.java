package com.ruoyi.system.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysInvestProfitMapper;
import com.ruoyi.system.domain.SysInvestProfit;
import com.ruoyi.system.service.ISysInvestProfitService;

/**
 * 实际收益信息记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-06-01
 */
@Service
public class SysInvestProfitServiceImpl implements ISysInvestProfitService 
{
    @Autowired
    private SysInvestProfitMapper sysInvestProfitMapper;

    /**
     * 查询实际收益信息记录
     * 
     * @param id 实际收益信息记录主键
     * @return 实际收益信息记录
     */
    @Override
    public SysInvestProfit selectSysInvestProfitById(Long id)
    {
        return sysInvestProfitMapper.selectSysInvestProfitById(id);
    }

    /**
     * 查询实际收益信息记录列表
     * 
     * @param sysInvestProfit 实际收益信息记录
     * @return 实际收益信息记录
     */
    @Override
    public List<SysInvestProfit> selectSysInvestProfitList(SysInvestProfit sysInvestProfit)
    {
        return sysInvestProfitMapper.selectSysInvestProfitList(sysInvestProfit);
    }

    /**
     * 新增实际收益信息记录
     * 
     * @param sysInvestProfit 实际收益信息记录
     * @return 结果
     */
    @Override
    public int insertSysInvestProfit(SysInvestProfit sysInvestProfit)
    {
        return sysInvestProfitMapper.insertSysInvestProfit(sysInvestProfit);
    }

    /**
     * 修改实际收益信息记录
     * 
     * @param sysInvestProfit 实际收益信息记录
     * @return 结果
     */
    @Override
    public int updateSysInvestProfit(SysInvestProfit sysInvestProfit)
    {
        return sysInvestProfitMapper.updateSysInvestProfit(sysInvestProfit);
    }

    /**
     * 批量删除实际收益信息记录
     * 
     * @param ids 需要删除的实际收益信息记录主键
     * @return 结果
     */
    @Override
    public int deleteSysInvestProfitByIds(Long[] ids)
    {
        return sysInvestProfitMapper.deleteSysInvestProfitByIds(ids);
    }

    /**
     * 删除实际收益信息记录信息
     * 
     * @param id 实际收益信息记录主键
     * @return 结果
     */
    @Override
    public int deleteSysInvestProfitById(Long id)
    {
        return sysInvestProfitMapper.deleteSysInvestProfitById(id);
    }

    @Override
    public List<SysInvestProfit> selectSysInvestProfitListByOrder(List<String> orderIds, Date beginDate,Date ednDate) {
        return  sysInvestProfitMapper.getSysinvestProfits(orderIds,beginDate,ednDate);
    }

    @Override
    public Double getTotalAmountByOrder(List<String> orderIds,Date endDay) {
        return sysInvestProfitMapper.getTotalAmountByOrder(orderIds,endDay);
    }
}

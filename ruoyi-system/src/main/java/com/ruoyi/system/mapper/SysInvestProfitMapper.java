package com.ruoyi.system.mapper;

import java.util.Date;
import java.util.List;
import com.ruoyi.system.domain.SysInvestProfit;
import org.apache.ibatis.annotations.Param;

/**
 * 实际收益信息记录Mapper接口
 * 
 * @author ruoyi
 * @date 2025-06-01
 */
public interface SysInvestProfitMapper 
{
    /**
     * 查询实际收益信息记录
     * 
     * @param id 实际收益信息记录主键
     * @return 实际收益信息记录
     */
    public SysInvestProfit selectSysInvestProfitById(Long id);

    /**
     * 查询实际收益信息记录列表
     * 
     * @param sysInvestProfit 实际收益信息记录
     * @return 实际收益信息记录集合
     */
    public List<SysInvestProfit> selectSysInvestProfitList(SysInvestProfit sysInvestProfit);

    /**
     * 新增实际收益信息记录
     * 
     * @param sysInvestProfit 实际收益信息记录
     * @return 结果
     */
    public int insertSysInvestProfit(SysInvestProfit sysInvestProfit);

    /**
     * 修改实际收益信息记录
     * 
     * @param sysInvestProfit 实际收益信息记录
     * @return 结果
     */
    public int updateSysInvestProfit(SysInvestProfit sysInvestProfit);

    /**
     * 删除实际收益信息记录
     * 
     * @param id 实际收益信息记录主键
     * @return 结果
     */
    public int deleteSysInvestProfitById(Long id);

    /**
     * 批量删除实际收益信息记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysInvestProfitByIds(Long[] ids);

    public List<SysInvestProfit> getSysinvestProfits(@Param("orderIds")List<String> orderIds, @Param("beginDate")Date beginDate, @Param("endDate")Date endDate);

    public Double getTotalAmountByOrder(@Param("orderIds") List<String> orderIds, @Param("endDate")Date endDate);
}

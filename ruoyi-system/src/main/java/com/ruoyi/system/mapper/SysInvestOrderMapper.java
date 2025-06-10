package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysInvestOrder;

/**
 * 订单信息Mapper接口
 * 
 * @author ruoyi
 * @date 2025-05-25
 */
public interface SysInvestOrderMapper 
{
    /**
     * 查询订单信息
     * 
     * @param id 订单信息主键
     * @return 订单信息
     */
    public SysInvestOrder selectSysInvestOrderById(Long id);

    /**
     * 查询订单信息列表
     * 
     * @param sysInvestOrder 订单信息
     * @return 订单信息集合
     */
    public List<SysInvestOrder> selectSysInvestOrderList(SysInvestOrder sysInvestOrder);

    /**
     * 新增订单信息
     * 
     * @param sysInvestOrder 订单信息
     * @return 结果
     */
    public int insertSysInvestOrder(SysInvestOrder sysInvestOrder);

    /**
     * 修改订单信息
     * 
     * @param sysInvestOrder 订单信息
     * @return 结果
     */
    public int updateSysInvestOrder(SysInvestOrder sysInvestOrder);

    /**
     * 删除订单信息
     * 
     * @param id 订单信息主键
     * @return 结果
     */
    public int deleteSysInvestOrderById(Long id);

    /**
     * 批量删除订单信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysInvestOrderByIds(Long[] ids);
}

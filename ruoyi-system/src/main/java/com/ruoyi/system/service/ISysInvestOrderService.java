package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysInvestOrder;
import com.ruoyi.system.domain.dto.OrderDTO;

/**
 * 订单信息Service接口
 * 
 * @author ruoyi
 * @date 2025-05-25
 */
public interface ISysInvestOrderService 
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
     * 批量删除订单信息
     * 
     * @param ids 需要删除的订单信息主键集合
     * @return 结果
     */
    public int deleteSysInvestOrderByIds(Long[] ids);

    /**
     * 删除订单信息信息
     * 
     * @param id 订单信息主键
     * @return 结果
     */
    public int deleteSysInvestOrderById(Long id);

    public SysInvestOrder selectSysInvestOrderByOrderId(String orderId);

}

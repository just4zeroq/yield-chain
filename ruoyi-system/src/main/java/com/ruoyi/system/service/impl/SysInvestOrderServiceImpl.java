package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysInvestOrderMapper;
import com.ruoyi.system.domain.SysInvestOrder;
import com.ruoyi.system.service.ISysInvestOrderService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 订单信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-05-25
 */
@Service
public class SysInvestOrderServiceImpl implements ISysInvestOrderService 
{
    @Autowired
    private SysInvestOrderMapper sysInvestOrderMapper;

    /**
     * 查询订单信息
     * 
     * @param id 订单信息主键
     * @return 订单信息
     */
    @Override
    public SysInvestOrder selectSysInvestOrderById(Long id)
    {
        return sysInvestOrderMapper.selectSysInvestOrderById(id);
    }

    /**
     * 查询订单信息列表
     * 
     * @param sysInvestOrder 订单信息
     * @return 订单信息
     */
    @Override
    public List<SysInvestOrder> selectSysInvestOrderList(SysInvestOrder sysInvestOrder)
    {
        return sysInvestOrderMapper.selectSysInvestOrderList(sysInvestOrder);
    }

    /**
     * 新增订单信息
     * 
     * @param sysInvestOrder 订单信息
     * @return 结果
     */
    @Override
    public int insertSysInvestOrder(SysInvestOrder sysInvestOrder)
    {
        sysInvestOrder.setCreateTime(DateUtils.getNowDate());
        return sysInvestOrderMapper.insertSysInvestOrder(sysInvestOrder);
    }

    /**
     * 修改订单信息
     * 
     * @param sysInvestOrder 订单信息
     * @return 结果
     */
    @Override
    public int updateSysInvestOrder(SysInvestOrder sysInvestOrder)
    {
        sysInvestOrder.setUpdateTime(DateUtils.getNowDate());
        return sysInvestOrderMapper.updateSysInvestOrder(sysInvestOrder);
    }

    /**
     * 批量删除订单信息
     * 
     * @param ids 需要删除的订单信息主键
     * @return 结果
     */
    @Override
    public int deleteSysInvestOrderByIds(Long[] ids)
    {
        return sysInvestOrderMapper.deleteSysInvestOrderByIds(ids);
    }

    /**
     * 删除订单信息信息
     * 
     * @param id 订单信息主键
     * @return 结果
     */
    @Override
    public int deleteSysInvestOrderById(Long id)
    {
        return sysInvestOrderMapper.deleteSysInvestOrderById(id);
    }

    @Override
    public SysInvestOrder selectSysInvestOrderByOrderId(String orderId) {
        SysInvestOrder sysInvestOrder = new SysInvestOrder();
        sysInvestOrder.setOrderId(orderId);
        List<SysInvestOrder> sysInvestOrders = sysInvestOrderMapper.selectSysInvestOrderList(sysInvestOrder);
        if(sysInvestOrders.isEmpty()){
            return null;
        }else{
            return sysInvestOrders.get(0);
        }
    }


}

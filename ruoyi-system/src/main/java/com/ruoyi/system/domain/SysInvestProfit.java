package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 实际收益信息记录对象 sys_invest_profit
 * 
 * @author ruoyi
 * @date 2025-06-01
 */
public class SysInvestProfit extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 订单id */
    @Excel(name = "订单id")
    private String orderId;

    /** 收益日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "收益日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date day;

    /** 实际收入 */
    @Excel(name = "实际收入")
    private Double realProfit;

    /** 当天年化 */
    @Excel(name = "当天年化")
    private Double apy;

    private Double totalAmount;

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setOrderId(String orderId) 
    {
        this.orderId = orderId;
    }

    public String getOrderId() 
    {
        return orderId;
    }

    public void setDay(Date day) 
    {
        this.day = day;
    }

    public Date getDay() 
    {
        return day;
    }

    public void setRealProfit(Double realProfit)
    {
        this.realProfit = realProfit;
    }

    public Double getRealProfit()
    {
        return realProfit;
    }

    public void setApy(Double apy)
    {
        this.apy = apy;
    }

    public Double getApy()
    {
        return apy;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderId", getOrderId())
            .append("day", getDay())
            .append("realProfit", getRealProfit())
            .append("apy", getApy())
            .toString();
    }
}

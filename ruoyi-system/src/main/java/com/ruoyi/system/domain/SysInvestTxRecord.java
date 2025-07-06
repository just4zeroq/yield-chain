package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 sys_invest_tx_record
 * 
 * @author ruoyi
 * @date 2025-06-11
 */
public class SysInvestTxRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 交易记录 */
    private Long id;

    /** 订单id */
    @Excel(name = "订单id")
    private String orderId;

    /** 交易类型 */
    @Excel(name = "交易类型")
    private String txType;

    /** 交易地址 */
    @Excel(name = "交易地址")
    private String txAddress;

    /** 交易数量 */
    @Excel(name = "交易数量")
    private Long txValue;

    /** 交易token */
    @Excel(name = "交易token")
    private String txToken;

    /** 交易状态 */
    @Excel(name = "交易状态")
    private Long txStatus;

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

    public void setTxType(String txType) 
    {
        this.txType = txType;
    }

    public String getTxType() 
    {
        return txType;
    }

    public void setTxAddress(String txAddress) 
    {
        this.txAddress = txAddress;
    }

    public String getTxAddress() 
    {
        return txAddress;
    }

    public void setTxValue(Long txValue) 
    {
        this.txValue = txValue;
    }

    public Long getTxValue() 
    {
        return txValue;
    }

    public void setTxToken(String txToken) 
    {
        this.txToken = txToken;
    }

    public String getTxToken() 
    {
        return txToken;
    }

    public void setTxStatus(Long txStatus) 
    {
        this.txStatus = txStatus;
    }

    public Long getTxStatus() 
    {
        return txStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderId", getOrderId())
            .append("txType", getTxType())
            .append("txAddress", getTxAddress())
            .append("txValue", getTxValue())
            .append("txToken", getTxToken())
            .append("txStatus", getTxStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}

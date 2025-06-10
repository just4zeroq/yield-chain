package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 订单信息对象 sys_invest_order
 * 
 * @author ruoyi
 * @date 2025-05-25
 */
public class SysInvestOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;
    private String orderId;
    /**  */
    @Excel(name = "")
    private Long buyerId;

    /**  */
    @Excel(name = "")
    private String buyerWalletAddress;

    /**  */
    @Excel(name = "")
    private Long traderId;

    /**  */
    @Excel(name = "")
    private String traderWalletAddress;

    /**  */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orderTime;

    /**  */
    @Excel(name = "")
    private Integer orderStatus;

    /**  */
    @Excel(name = "")
    private Double orderAmount;

    /**  */
    @Excel(name = "")
    private Double marginAmount;

    /**  */
    @Excel(name = "")
    private String tokenSymbol;

    /**  */
    @Excel(name = "")
    private Long tokenDecimal;

    /**  */
    @Excel(name = "")
    private String buyerAddressChain;

    /**  */
    @Excel(name = "")
    private String traderAddressChain;

    /** 商品id */
    @Excel(name = "商品id")
    private Long productId;

    /** 订单类型，0-CEX_USDT,1-CHAIN_USDT */
    @Excel(name = "订单类型，0-CEX_USDT,1-CHAIN_USDT")
    private Integer orderType;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String orderConfig;

    /** $column.columnComment */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date orderEndtime;

    @Excel(name = "")
    private Double confirmProfit;

    private Double stakeTokenAmount;

    public Double getStakeTokenAmount() {
        return stakeTokenAmount;
    }

    public void setStakeTokenAmount(Double stakeTokenAmount) {
        this.stakeTokenAmount = stakeTokenAmount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setBuyerId(Long buyerId) 
    {
        this.buyerId = buyerId;
    }

    public Long getBuyerId() 
    {
        return buyerId;
    }

    public void setBuyerWalletAddress(String buyerWalletAddress) 
    {
        this.buyerWalletAddress = buyerWalletAddress;
    }

    public String getBuyerWalletAddress() 
    {
        return buyerWalletAddress;
    }

    public void setTraderId(Long traderId) 
    {
        this.traderId = traderId;
    }

    public Long getTraderId() 
    {
        return traderId;
    }

    public void setTraderWalletAddress(String traderWalletAddress) 
    {
        this.traderWalletAddress = traderWalletAddress;
    }

    public String getTraderWalletAddress() 
    {
        return traderWalletAddress;
    }

    public void setOrderTime(Date orderTime) 
    {
        this.orderTime = orderTime;
    }

    public Date getOrderTime() 
    {
        return orderTime;
    }

    public void setOrderStatus(Integer orderStatus)
    {
        this.orderStatus = orderStatus;
    }

    public Integer getOrderStatus()
    {
        return orderStatus;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Double getMarginAmount() {
        return marginAmount;
    }

    public void setMarginAmount(Double marginAmount) {
        this.marginAmount = marginAmount;
    }

    public void setTokenSymbol(String tokenSymbol)
    {
        this.tokenSymbol = tokenSymbol;
    }

    public String getTokenSymbol() 
    {
        return tokenSymbol;
    }

    public void setTokenDecimal(Long tokenDecimal) 
    {
        this.tokenDecimal = tokenDecimal;
    }

    public Long getTokenDecimal() 
    {
        return tokenDecimal;
    }

    public void setBuyerAddressChain(String buyerAddressChain) 
    {
        this.buyerAddressChain = buyerAddressChain;
    }

    public String getBuyerAddressChain() 
    {
        return buyerAddressChain;
    }

    public void setTraderAddressChain(String traderAddressChain) 
    {
        this.traderAddressChain = traderAddressChain;
    }

    public String getTraderAddressChain() 
    {
        return traderAddressChain;
    }

    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }

    public void setOrderType(Integer orderType)
    {
        this.orderType = orderType;
    }

    public Integer getOrderType()
    {
        return orderType;
    }

    public void setOrderConfig(String orderConfig) 
    {
        this.orderConfig = orderConfig;
    }

    public String getOrderConfig() 
    {
        return orderConfig;
    }

    public void setOrderEndtime(Date orderEndtime) 
    {
        this.orderEndtime = orderEndtime;
    }

    public Date getOrderEndtime() 
    {
        return orderEndtime;
    }

    public Double getConfirmProfit() {
        return confirmProfit;
    }

    public void setConfirmProfit(Double confirmProfit) {
        this.confirmProfit = confirmProfit;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("buyerId", getBuyerId())
            .append("buyerWalletAddress", getBuyerWalletAddress())
            .append("traderId", getTraderId())
            .append("traderWalletAddress", getTraderWalletAddress())
            .append("orderTime", getOrderTime())
            .append("orderStatus", getOrderStatus())
            .append("orderAmount", getOrderAmount())
            .append("marginAmount", getMarginAmount())
            .append("tokenSymbol", getTokenSymbol())
            .append("tokenDecimal", getTokenDecimal())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("buyerAddressChain", getBuyerAddressChain())
            .append("traderAddressChain", getTraderAddressChain())
            .append("productId", getProductId())
            .append("orderType", getOrderType())
            .append("orderConfig", getOrderConfig())
            .append("orderEndtime", getOrderEndtime())
            .toString();
    }
}

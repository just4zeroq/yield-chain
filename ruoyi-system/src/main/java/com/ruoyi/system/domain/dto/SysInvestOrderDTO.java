package com.ruoyi.system.domain.dto;

import com.ruoyi.system.domain.SysInvestOrder;

public class SysInvestOrderDTO extends SysInvestOrder {
    private String productName;
    private String stakeToken;
    private Double stakeTokenAmount;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getStakeToken() {
        return stakeToken;
    }

    public void setStakeToken(String stakeToken) {
        this.stakeToken = stakeToken;
    }

    public Double getStakeTokenAmount() {
        return stakeTokenAmount;
    }

    public void setStakeTokenAmount(Double stakeTokenAmount) {
        this.stakeTokenAmount = stakeTokenAmount;
    }
    
    /**
     * 从 SysInvestOrder 实例转换为 SysInvestOrderDTO 实例
     * @param order SysInvestOrder 实例
     * @return SysInvestOrderDTO 实例
     */
    public static SysInvestOrderDTO from(SysInvestOrder order) {
        SysInvestOrderDTO dto = new SysInvestOrderDTO();
        // 复制 SysInvestOrder 的属性
        dto.setId(order.getId());
        dto.setOrderId(order.getOrderId());
        dto.setBuyerId(order.getBuyerId());
        dto.setBuyerWalletAddress(order.getBuyerWalletAddress());
        dto.setTraderId(order.getTraderId());
        dto.setTraderWalletAddress(order.getTraderWalletAddress());
        dto.setOrderTime(order.getOrderTime());
        dto.setOrderStatus(order.getOrderStatus());
        dto.setOrderAmount(order.getOrderAmount());
        dto.setMarginAmount(order.getMarginAmount());
        dto.setTokenSymbol(order.getTokenSymbol());
        dto.setTokenDecimal(order.getTokenDecimal());
        dto.setBuyerAddressChain(order.getBuyerAddressChain());
        dto.setTraderAddressChain(order.getTraderAddressChain());
        dto.setProductId(order.getProductId());
        dto.setOrderType(order.getOrderType());
        dto.setOrderConfig(order.getOrderConfig());
        dto.setOrderEndtime(order.getOrderEndtime());
        dto.setConfirmProfit(order.getConfirmProfit());
        return dto;
    }
}

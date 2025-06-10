package com.ruoyi.system.domain.dto;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.SysInvestOrder;
import com.ruoyi.system.domain.SysInvestOrderStep;
import com.ruoyi.system.domain.SysInvestProduct;
import com.ruoyi.system.domain.vo.UserWalletVo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class OrderDTO implements Serializable {
    private UserWalletVo trader;
    private UserWalletVo buyer;
    
    private  Double orderAmount;
    private  Double marginAmount;
    private Date orderEndTime;
    private Date orderTime;
    private SysInvestProduct product;
    private Integer orderType;
    private List<SysInvestOrderStep> spotPerpStep;
    private SysInvestOrderStep stakeStep;
    private  SysInvestOrderStep marginStep;

    public UserWalletVo getTrader() {
        return trader;
    }

    public void setTrader(UserWalletVo trader) {
        this.trader = trader;
    }

    public UserWalletVo getBuyer() {
        return buyer;
    }

    public void setBuyer(UserWalletVo buyer) {
        this.buyer = buyer;
    }

    public SysInvestOrderStep getMarginStep() {
        return marginStep;
    }

    public void setMarginStep(SysInvestOrderStep marginStep) {
        this.marginStep = marginStep;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Date getOrderEndTime() {
        return orderEndTime;
    }

    public void setOrderEndTime(Date orderEndTime) {
        this.orderEndTime = orderEndTime;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public SysInvestProduct getProduct() {
        return product;
    }

    public void setProduct(SysInvestProduct product) {
        this.product = product;
    }

    public List<SysInvestOrderStep> getSpotPerpStep() {
        return spotPerpStep;
    }

    public void setSpotPerpStep(List<SysInvestOrderStep> spotPerpStep) {
        this.spotPerpStep = spotPerpStep;
    }

    public SysInvestOrderStep getStakeStep() {
        return stakeStep;
    }

    public void setStakeStep(SysInvestOrderStep stakeStep) {
        this.stakeStep = stakeStep;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Double getMarginAmount() {
        return marginAmount;
    }

    public void setMarginAmount(Double marginAmount) {
        this.marginAmount = marginAmount;
    }

    public SysInvestOrder convertToSysInvestOrder(){
        SysInvestOrder order = new SysInvestOrder();
        UserWalletVo buyer = this.getBuyer();
        UserWalletVo trader = this.getTrader();
        order.setBuyerId(buyer.getUserId());
        order.setBuyerWalletAddress(buyer.getWalletAddress());
        order.setBuyerAddressChain(buyer.getWalletChain());
        order.setTraderId(trader.getUserId());
        order.setTraderAddressChain(trader.getWalletChain());
        order.setTraderWalletAddress(trader.getWalletAddress());
        order.setOrderAmount(this.getOrderAmount());
        order.setOrderStatus(1);
        order.setProductId(this.product.getId());
        order.setOrderType(this.getOrderType());
        order.setOrderTime(this.getOrderTime());
        order.setOrderEndtime(this.getOrderEndTime());
        order.setMarginAmount(this.getMarginAmount());
        return order;
    }
    public List<SysInvestOrderStep> convertToSysInvestOrderStep(String orderId){
        List<SysInvestOrderStep> orderSteps = new ArrayList<>();
        int stepOrder = 1;
        SysInvestOrderStep marginStep = this.getMarginStep();
        marginStep.setOrderStepStatus(1);
        marginStep.setOrderId(orderId);
        marginStep.setOrderStepCode("margin");
        marginStep.setOrderStep(stepOrder);
        marginStep.setCreateTime(DateUtils.getNowDate());
        if(Objects.equals(marginStep.getStepMode(), "amount") && null == marginStep.getStepValueType()){
            marginStep.setStepValueType("USDT");
        }
        orderSteps.add(marginStep);

        for(SysInvestOrderStep step : this.getSpotPerpStep()){
            stepOrder++;
            step.setOrderId(orderId);
            step.setOrderStepStatus(0);
            step.setOrderStepCode("spot_perp");
            step.setOrderStep(stepOrder);
            step.setCreateTime(DateUtils.getNowDate());
            if(null == step.getStepMode()){
                step.setStepMode("amount");
            }
            orderSteps.add(step);
        }
        stepOrder++;
        SysInvestOrderStep stakeStep = this.getStakeStep();
        stakeStep.setOrderId(orderId);
        stakeStep.setOrderStepStatus(0);
        stakeStep.setOrderStepCode("stake");
        stakeStep.setOrderStep(stepOrder);
        if(null ==stakeStep.getStepMode()){
            stakeStep.setStepMode("amount");
        }
        stakeStep.setCreateTime(DateUtils.getNowDate());
        orderSteps.add(stakeStep);
        return orderSteps;
    }

    /**
     * 将 SysInvestOrderStep 转换为 SysInvestOrderStep
     * @param SysInvestOrderStep 子步骤对象
     * @param orderId 订单 ID
     * @return 转换后的订单步骤对象
     */
    private SysInvestOrderStep convertSysInvestOrderStepToOrderStep(SysInvestOrderStep SysInvestOrderStep, String orderId,String stepCode,Integer stepOrder) {
        SysInvestOrderStep orderStep = new SysInvestOrderStep();
        // 假设 SysInvestOrderStep 有相应的 getter 方法，根据实际情况调整
        // 这里需要根据 SysInvestOrderStep 和 SysInvestOrderStep 的属性进行具体赋值
        orderStep.setOrderId(orderId);
        orderStep.setOrderStep(stepOrder);
        orderStep.setOrderStepCode(stepCode);
        orderStep.setStepMode(SysInvestOrderStep.getStepMode());

        if(Objects.equals(stepCode, "margin")){

        }
        return orderStep;
    }
}


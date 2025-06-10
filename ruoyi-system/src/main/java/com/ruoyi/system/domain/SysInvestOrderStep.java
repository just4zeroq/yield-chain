package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 订单拆分大步骤对象 sys_invest_order_step
 * 
 * @author ruoyi
 * @date 2025-05-25
 */
public class SysInvestOrderStep extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 拆分步骤id */
    private Long id;

    /** 订单id */
    @Excel(name = "订单id")
    private String orderId;

    /** 订单拆分大步骤 */
    @Excel(name = "订单拆分大步骤")
    private Integer orderStep;

    /** 子步骤状态 */
    @Excel(name = "子步骤状态")
    private Integer orderStepStatus;

    /** 订单步骤编码 */
    @Excel(name = "订单步骤编码")
    private String orderStepCode;

    /** 创建人 */
    @Excel(name = "创建人")
    private Long createdBy;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String stepConfig;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String stepMode;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Double stepValue;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String stepValueType;

    public String getOrderResult() {
        return orderResult;
    }

    public void setOrderResult(String orderResult) {
        this.orderResult = orderResult;
    }

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String orderResult;

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

    public void setOrderStep(Integer orderStep)
    {
        this.orderStep = orderStep;
    }

    public Integer getOrderStep()
    {
        return orderStep;
    }

    public void setOrderStepStatus(Integer orderStepStatus)
    {
        this.orderStepStatus = orderStepStatus;
    }

    public Integer getOrderStepStatus()
    {
        return orderStepStatus;
    }

    public void setOrderStepCode(String orderStepCode) 
    {
        this.orderStepCode = orderStepCode;
    }

    public String getOrderStepCode() 
    {
        return orderStepCode;
    }

    public void setCreatedBy(Long createdBy) 
    {
        this.createdBy = createdBy;
    }

    public Long getCreatedBy() 
    {
        return createdBy;
    }

    public void setStepConfig(String stepConfig) 
    {
        this.stepConfig = stepConfig;
    }

    public String getStepConfig() 
    {
        return stepConfig;
    }

    public void setStepMode(String stepMode) 
    {
        this.stepMode = stepMode;
    }

    public String getStepMode() 
    {
        return stepMode;
    }

    public void setStepValue(Double stepValue)
    {
        this.stepValue = stepValue;
    }

    public Double getStepValue()
    {
        return stepValue;
    }

    public void setStepValueType(String stepValueType) 
    {
        this.stepValueType = stepValueType;
    }

    public String getStepValueType() 
    {
        return stepValueType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderId", getOrderId())
            .append("orderStep", getOrderStep())
            .append("orderStepStatus", getOrderStepStatus())
            .append("orderStepCode", getOrderStepCode())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createdBy", getCreatedBy())
            .append("updateBy", getUpdateBy())
            .append("stepConfig", getStepConfig())
            .append("stepMode", getStepMode())
            .append("stepValue", getStepValue())
            .append("stepValueType", getStepValueType())
            .toString();
    }
}

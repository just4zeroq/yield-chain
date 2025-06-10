package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 订单拆分子步骤对象 sys_invest_order_sub_step
 * 
 * @author ruoyi
 * @date 2025-05-25
 */
public class SysInvestOrderSubStep extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 拆分子步骤id */
    private Long id;

    /** 订单id */
    @Excel(name = "订单id")
    private Long orderId;

    /** 拆分步骤id */
    @Excel(name = "拆分步骤id")
    private Long stepId;

    /** 订单拆分子步骤 */
    @Excel(name = "订单拆分子步骤")
    private Long orderSubStep;

    /** 子步骤状态 */
    @Excel(name = "子步骤状态")
    private Long orderSubStepStatus;

    /** 订单子步骤编码 */
    @Excel(name = "订单子步骤编码")
    private String orderSubStepCode;

    /** 创建人 */
    @Excel(name = "创建人")
    private Long createdBy;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String subStepConfig;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }

    public void setStepId(Long stepId) 
    {
        this.stepId = stepId;
    }

    public Long getStepId() 
    {
        return stepId;
    }

    public void setOrderSubStep(Long orderSubStep) 
    {
        this.orderSubStep = orderSubStep;
    }

    public Long getOrderSubStep() 
    {
        return orderSubStep;
    }

    public void setOrderSubStepStatus(Long orderSubStepStatus) 
    {
        this.orderSubStepStatus = orderSubStepStatus;
    }

    public Long getOrderSubStepStatus() 
    {
        return orderSubStepStatus;
    }

    public void setOrderSubStepCode(String orderSubStepCode) 
    {
        this.orderSubStepCode = orderSubStepCode;
    }

    public String getOrderSubStepCode() 
    {
        return orderSubStepCode;
    }

    public void setCreatedBy(Long createdBy) 
    {
        this.createdBy = createdBy;
    }

    public Long getCreatedBy() 
    {
        return createdBy;
    }

    public void setSubStepConfig(String subStepConfig) 
    {
        this.subStepConfig = subStepConfig;
    }

    public String getSubStepConfig() 
    {
        return subStepConfig;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderId", getOrderId())
            .append("stepId", getStepId())
            .append("orderSubStep", getOrderSubStep())
            .append("orderSubStepStatus", getOrderSubStepStatus())
            .append("orderSubStepCode", getOrderSubStepCode())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createdBy", getCreatedBy())
            .append("updateBy", getUpdateBy())
            .append("subStepConfig", getSubStepConfig())
            .toString();
    }
}

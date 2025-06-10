package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 sys_invest_product
 * 
 * @author ruoyi
 * @date 2025-05-10
 */
public class SysInvestProduct extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String productName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String productDesc;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date startTime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date endTime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long fixApy;

    private String  productLogo;

    public String getProductLogo() {
        return productLogo;
    }

    public void setProductLogo(String productLogo) {
        this.productLogo = productLogo;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductConfig() {
        return productConfig;
    }

    public void setProductConfig(String productConfig) {
        this.productConfig = productConfig;
    }

    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer productStatus;
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String productConfig;


    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
    }

    public void setProductDesc(String productDesc) 
    {
        this.productDesc = productDesc;
    }

    public String getProductDesc() 
    {
        return productDesc;
    }

    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }

    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }

    public void setFixApy(Long fixApy) 
    {
        this.fixApy = fixApy;
    }

    public Long getFixApy() 
    {
        return fixApy;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("productName", getProductName())
            .append("productDesc", getProductDesc())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("fixApy", getFixApy())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}

package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 sys_invest_stat
 * 
 * @author ruoyi
 * @date 2025-06-01
 */
public class SysInvestStat extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 订单id */
    @Excel(name = "订单id")
    private String statTypeCode;

    /** 统计日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "统计日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date day;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setStatTypeCode(String statTypeCode) 
    {
        this.statTypeCode = statTypeCode;
    }

    public String getStatTypeCode() 
    {
        return statTypeCode;
    }

    public void setDay(Date day) 
    {
        this.day = day;
    }

    public Date getDay() 
    {
        return day;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("statTypeCode", getStatTypeCode())
            .append("day", getDay())
            .toString();
    }
}

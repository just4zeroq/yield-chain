package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 sys_user_wallet
 * 
 * @author ruoyi
 * @date 2025-05-10
 */
public class SysUserWallet extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long userId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String walletAddress;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String walletChain;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long walletStatus;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public void setWalletAddress(String walletAddress) 
    {
        this.walletAddress = walletAddress;
    }

    public String getWalletAddress() 
    {
        return walletAddress;
    }

    public void setWalletChain(String walletChain) 
    {
        this.walletChain = walletChain;
    }

    public String getWalletChain() 
    {
        return walletChain;
    }

    public void setWalletStatus(Long walletStatus) 
    {
        this.walletStatus = walletStatus;
    }

    public Long getWalletStatus() 
    {
        return walletStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("walletAddress", getWalletAddress())
            .append("walletChain", getWalletChain())
            .append("walletStatus", getWalletStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}

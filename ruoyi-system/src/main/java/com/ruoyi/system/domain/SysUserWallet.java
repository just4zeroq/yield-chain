package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 钱包管理对象 sys_user_wallet
 *
 * @author ruoyi
 * @date 2025-06-14
 */
public class SysUserWallet extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 钱包地址 */
    @Excel(name = "钱包地址")
    private String walletAddress;

    /** 钱包来源 */
    @Excel(name = "钱包来源")
    private String walletChain;

    /** 钱包状态 */
    @Excel(name = "钱包状态")
    private int walletStatus;

    /** 钱包类型 */
    private String walletType;
    /** 钱包key */
    @Excel(name = "钱包key")
    private String apiKey;
    /** 钱包名称 */
    @Excel(name = "钱包名称")
    private String walletName;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getWalletName() {
        return walletName;
    }

    public void setWalletName(String walletName) {
        this.walletName = walletName;
    }

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

    public void setWalletStatus(int walletStatus)
    {
        this.walletStatus = walletStatus;
    }

    public int getWalletStatus()
    {
        return walletStatus;
    }

    public void setWalletType(String walletType)
    {
        this.walletType = walletType;
    }

    public String getWalletType()
    {
        return walletType;
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
                .append("walletType", getWalletType())
                .toString();
    }
}

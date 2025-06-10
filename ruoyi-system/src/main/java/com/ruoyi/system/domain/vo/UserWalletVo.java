package com.ruoyi.system.domain.vo;

import java.io.Serializable;

public class UserWalletVo implements Serializable {
    private static final long serialVersionUID = 1L;



    private Long id;
    private  String userName;
    private  Long userId;
    private String walletAddress;
    private String walletChain;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    public String getWalletChain() {
        return walletChain;
    }

    public void setWalletChain(String walletChain) {
        this.walletChain = walletChain;
    }
}

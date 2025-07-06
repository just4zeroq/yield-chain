package com.ruoyi.system.domain.dto;

import java.io.Serializable;
import java.util.Map;

public class WalletBalanceParamDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String walletAddress;
    private Long userId;
    private String symbol;
    private Map<String,Object> signedParam;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Map<String, Object> getSignedParam() {
        return signedParam;
    }

    public void setSignedParam(Map<String, Object> signedParam) {
        this.signedParam = signedParam;
    }
}

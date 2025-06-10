package com.ruoyi.common.enums;


public enum OrderStatus
{
    INIT(1, "开始"),
    MARGIN_DEPOSIT(2, "转入保证金"),
    TOKEN_BUY(3, "购买TOKEN"),
    TOKEN_TRANSFER(4, "存入TOKEN"),
    STAKE_TOKEN(5, "质押TOKEN"),
    YIELD(6, "收益"),
    FARM(7, "完成");

    private final Integer code;
    private final String info;

    OrderStatus(Integer code, String info)
    {
        this.code = code;
        this.info = info;
    }

    public Integer getCode()
    {
        return code;
    }

    public String getInfo()
    {
        return info;
    }
}

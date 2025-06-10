package com.ruoyi.common.utils.pendle;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.utils.http.HttpUtils;

public class PendleUtil {
    public static void swapTokenToPT(int chainId,String  market,String receiver ,double slippage ,String tokenIn,String tokenOut ,String amountIn ){
        String pathUrl = String.format("https://api-v2.pendle.finance/core/v1/sdk/%s/markets/%s/swap",chainId,market);
        String param = String.format("receiver=%s&slippage=%s&tokenIn=%s&tokenOut=%s&amountIn=%s",receiver,slippage,tokenIn,tokenOut,amountIn);
        String res = HttpUtils.sendGet(pathUrl,param);
        JSONObject json = JSON.parseObject(res);
        System.out.println(json.getJSONObject("tx"));
    }

    public static void main(String[] args) {
        swapTokenToPT(1,"0xda57abf95a7c21eb9df08fbaada182f749f6c62f","0x0d0370545e46dc936ae6412ba215fdab9fd3fcd4",0.01,"0x57e114b691db790c35207b2e685d4a43181e6061","0xfc66d247f577bfc87df8a5267c43676c4a088b8b","11111999999999999999");
    }
}

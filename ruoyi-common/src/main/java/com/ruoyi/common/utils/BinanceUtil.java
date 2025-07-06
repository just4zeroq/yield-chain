package com.ruoyi.common.utils;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import okhttp3.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.List;
public class BinanceUtil {
    private final String apiKey;
    private final OkHttpClient client;
    private final String baseUrl="https://api.binance.com";
    public BinanceUtil(String apiKey) {
        this.apiKey = apiKey;
        this.client = new OkHttpClient();
    }
    private String getRequest(Map<String,Object> signedParam, List<String> orderedKey, String queryPath){
        HttpUrl.Builder urlBuilder = HttpUrl.parse(baseUrl+queryPath).newBuilder();
        for (String key : orderedKey) {
            urlBuilder.addQueryParameter(key, signedParam.get(key).toString());
        }
        
        HttpUrl url = urlBuilder.build();
        Request request = new Request.Builder()
                .url(url)
                .header("Content-Type","application/json;charset=utf-8")
                .addHeader("X-MBX-APIKEY", apiKey)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return response.body().string();
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
    private String postRequest(Map<String,Object> signedParam, List<String> orderedKey, String queryPath){
        HttpUrl.Builder urlBuilder = HttpUrl.parse(baseUrl+queryPath).newBuilder();
        FormBody.Builder formBuilder = new FormBody.Builder();
//        for (String key : orderedKey) {
//            urlBuilder.addQueryParameter(key, signedParam.get(key).toString());
//        }
        for (String key : orderedKey) {
            formBuilder.addEncoded(key,signedParam.get(key).toString());
        }
        FormBody body = formBuilder.build();
        HttpUrl url = urlBuilder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .header("Content-Type","application/x-www-form-urlencoded")
                .addHeader("X-MBX-APIKEY", apiKey)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return response.body().string();
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    ///api/v3/account
    public Double getBalance(Map<String,Object> signedParam,String symbol) throws IOException {
            List<String> keys= Arrays.asList("recvWindow","timestamp","signature");
            String  result = getRequest(signedParam,keys,"/api/v3/account");
            JSONObject jsonResult = JSON.parseObject(result);
            JSONArray balanceArray = jsonResult.getJSONArray("balances");
            for(Object o : balanceArray){
                JSONObject o1 = (JSONObject)o;
                String bSymbol = o1.getString("asset");
                System.out.println(bSymbol);
                if(bSymbol.equals(symbol)){
                    return o1.getDouble("free");
                }
            }
            return 0.0;
    }
    ///api/v3/order
    //{
    //  "symbol": "BTCUSDT",
    //  "orderId": 28,
    //  "orderListId": -1, // Unless it's part of an order list, value will be -1
    //  "clientOrderId": "6gCrw2kRUAF9CvJDGP16IP",
    //  "transactTime": 1507725176595
    //}
    public void buySymbol(Map<String,Object> signedParam){
        List<String> keys= Arrays.asList("newOrderRespType","quoteOrderQty","recvWindow","side","symbol","timestamp","type","signature");
        String  result = postRequest(signedParam,keys,"/api/v3/order");
        JSONObject jsonResult = JSON.parseObject(result);

    }

    /**
     * 同步查询订单信息
     * @param symbol 交易对
     * @param orderId 订单ID
     * @return 响应字符串
     * @throws IOException 网络异常
     */
    public String queryOrder(String symbol, String orderId) throws IOException {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(baseUrl+"/api/v3/order").newBuilder();
        urlBuilder.addQueryParameter("symbol", symbol);
        urlBuilder.addQueryParameter("timestamp", String.valueOf(System.currentTimeMillis()));
        urlBuilder.addQueryParameter("orderId", orderId);
        urlBuilder.addQueryParameter("recvWindow", "59999");
        
        HttpUrl url = urlBuilder.build();
        Request request = new Request.Builder()
                .url(url)
                .header("Content-Type","application/json;charset=utf-8")
                .addHeader("X-MBX-APIKEY", apiKey)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return response.body().string();
        }
    }
}
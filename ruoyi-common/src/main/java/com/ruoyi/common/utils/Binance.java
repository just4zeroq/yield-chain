package com.ruoyi.common.utils;

import com.binance.connector.client.common.ApiResponse;
import com.binance.connector.client.common.configuration.ClientConfiguration;
import com.binance.connector.client.common.configuration.SignatureConfiguration;
import com.binance.connector.client.spot.rest.SpotRestApiUtil;
import com.binance.connector.client.spot.rest.api.SpotRestApi;
import com.binance.connector.client.spot.rest.model.GetAccountResponse;
import com.binance.connector.client.spot.rest.model.GetAccountResponseBalancesInner;
import com.binance.connector.client.spot.rest.model.GetOrderResponse;
import okhttp3.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Binance {

        private SpotRestApi api;

        public Binance(String apiKey,String apiSecret){
//            this.apiKey = apiKey;
//            this.apiSecret = apiSecret;
            ClientConfiguration clientConfiguration = SpotRestApiUtil.getClientConfiguration();
            SignatureConfiguration signatureConfiguration = new SignatureConfiguration();
            signatureConfiguration.setApiKey(apiKey);
            signatureConfiguration.setSecretKey(apiSecret);
            clientConfiguration.setSignatureConfiguration(signatureConfiguration);
            api = new SpotRestApi(clientConfiguration);
        }
        public String  getBalance(String symbol){
            Boolean omitZeroBalances = false;
            Long recvWindow = 5000L;
            ApiResponse<GetAccountResponse> response =
                    this.api.getAccount(omitZeroBalances, recvWindow);
           List<GetAccountResponseBalancesInner> balances =  response.getData().getBalances();
           for(GetAccountResponseBalancesInner b : balances){
               if(b.getAsset()==symbol){
                   return b.getFree();
               }
           }
            return "0";
        }
//        1961830413
        public void  getOrder(String symbol,Long orderId){
            String origClientOrderId = null;
            Long recvWindow = 5000L;
            ApiResponse<GetOrderResponse> response =
                    this.api.getOrder(symbol, orderId, origClientOrderId, recvWindow);
            System.out.println(response.getData());
        }

    public static void main(String[] args) {
        // Binance b = new Binance("Fu9O8WhfA2bbsFb2AxZDF0giKEAHord1nvAf4oigowCHUVKagNbR1GjN1G00j05a","4v5R1CHIB5SuR7jAQ4qY8GcpXfA3ElkgMxkEjWPEQlnL8zziPcmkyNn1IzKURUv8");
        OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.binance.com/api/v3/order").newBuilder();
        urlBuilder.addQueryParameter("symbol", "ENAUSDT");
        urlBuilder.addQueryParameter("timestamp", "1749745965289");
        urlBuilder.addQueryParameter("orderId", "1961830413");
        urlBuilder.addQueryParameter("recvWindow", "59999");
        urlBuilder.addQueryParameter("signature", "9d55ddd9f83b95212b094d60a92fdbd1ea067de3c20c439b1b1a419a018435da");
        HttpUrl url = urlBuilder.build();
        Request request = new Request.Builder()
                .url(url)
                .header("Content-Type","application/json;charset=utf-8") // 添加或更新 User-Agent heade
                .addHeader(   "X-MBX-APIKEY", "Fu9O8WhfA2bbsFb2AxZDF0giKEAHord1nvAf4oigowCHUVKagNbR1GjN1G00j05a") // 添加 Authorization header
                .build();
        // 发送请求
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                // 处理响应
                System.out.println(response.body().string());
            }

            @Override
            public void onFailure(Call call, IOException e) {
                // 处理失败情况
                System.out.println(e.getMessage());
            }
        });
    }
}

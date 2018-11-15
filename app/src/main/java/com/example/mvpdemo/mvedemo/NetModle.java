package com.example.mvpdemo.mvedemo;

import android.text.TextUtils;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetModle {

    String api = "http://api.apiopen.top/musicRankings";
    Response response;

    public String getApi() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(api)
                .build();
        response = client.newCall(request).execute();
        return response.body().string();
    }

    public NetResponse getResponse() {
        NetResponse netResponse;
        if (response != null && response.body() != null) {
            try {
                String dataStr = response.body().string();
                if (!TextUtils.isEmpty(dataStr)) {
                     netResponse = new Gson().fromJson(dataStr, NetResponse.class);
                    return  netResponse;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  null;
    }


}

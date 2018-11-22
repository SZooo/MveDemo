package com.example.mvpdemo.mvedemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetModle implements IModle {

    private Handler handler;
    private String api = "http://api.apiopen.top/musicRankings";


    public void getApi()  {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(api)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String body = response.body() != null ? response.body().string() : null;
                if (!TextUtils.isEmpty(body)) {
                    Message message = Message.obtain();
                    Bundle bundle = new Bundle();
                    bundle.putString("data", body);
                    message.setData(bundle);
                    handler.sendMessage(message);
                }
            }
        });
    }

    @Override
    public void getTasks(@NonNull final LoadTasksCallback callback) {
            handler = new Handler(new Handler.Callback() {
                @Override
                public boolean handleMessage(Message msg) {
                    Bundle bundle = msg.getData();
                    String bodyStr = bundle.getString("data");
                    callback.onTasksLoaded(bodyStr);
                    return false;
                }
            });
            getApi();
    }
}

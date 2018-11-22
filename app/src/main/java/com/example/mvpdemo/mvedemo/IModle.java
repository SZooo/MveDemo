package com.example.mvpdemo.mvedemo;

import android.support.annotation.NonNull;

public interface IModle{

    interface LoadTasksCallback {

        void onTasksLoaded(String dataStr);

        void onDataNotAvailable();
    }

    void getTasks(@NonNull LoadTasksCallback callback);

}

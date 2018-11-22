package com.example.mvpdemo.mvedemo;

import android.support.annotation.NonNull;

public class TasksRepository implements IModle {

    private final IModle dataModle;

    public TasksRepository(IModle dataModle) {
        this.dataModle = dataModle;
    }

    @Override
    public void getTasks(@NonNull final LoadTasksCallback callback) {
        dataModle.getTasks(new LoadTasksCallback() {
            @Override
            public void onTasksLoaded(String dataStr) {
                callback.onTasksLoaded(dataStr);
            }

            @Override
            public void onDataNotAvailable() {
                callback.onDataNotAvailable();
            }
        });

    }
}

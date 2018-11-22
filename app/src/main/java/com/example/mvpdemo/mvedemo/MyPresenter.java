package com.example.mvpdemo.mvedemo;

import android.support.annotation.NonNull;
import android.text.TextUtils;

public class MyPresenter implements ITaskContract.Presenter {

    private ITaskContract.View view;
    private TasksRepository repository;

    public MyPresenter(@NonNull ITaskContract.View view, @NonNull TasksRepository repository) {
        this.view = view;
        this.repository = repository;
        this.view.setPresenter(this);
    }


    @Override
    public void loadData() {
        load();
    }

    private void load() {
        repository.getTasks(new IModle.LoadTasksCallback() {
            @Override
            public void onTasksLoaded(String dataStr) {
                if (TextUtils.isEmpty(dataStr)) view.showError("");
                else view.showGetData(dataStr);
            }

            @Override
            public void onDataNotAvailable() {
                view.showError("");
            }
        });
    }
}

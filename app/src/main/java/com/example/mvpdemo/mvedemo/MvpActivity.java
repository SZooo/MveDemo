package com.example.mvpdemo.mvedemo;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

public class MvpActivity extends AppCompatActivity implements ITaskContract.View {
    NetModle netModle;
    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    ITaskContract.Presenter presenter;
    NetResponse response;
    DataAdapter adapter;
    TextView tvNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        tvNote = findViewById(R.id.tv_note);
        swipeRefreshLayout = findViewById(R.id.swipe);
        recyclerView = findViewById(R.id.rv);
        swipeRefreshLayout.setColorSchemeColors(Resources.getSystem().getColor(android.R.color.holo_orange_light));
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (presenter != null) {
                    presenter.loadData();
                }
            }
        });
        netModle = new NetModle();
        TasksRepository repository = new TasksRepository(netModle);
        new MyPresenter(this, repository);
        response = new NetResponse();
        adapter = new DataAdapter(response, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        Log.i("gvv", "onCreate当前线程：" + Thread.currentThread().getName());
    }

    @Override
    public void setPresenter(ITaskContract.Presenter presenter) {
        if (presenter != null) {
            this.presenter = presenter;
        }
    }

    @Override
    public void showGetData(String netData) {
        if (!TextUtils.isEmpty(netData)) {
            Log.i("gvv", "showData当前线程：" + Thread.currentThread().getName());
            Log.i("gvv", netData);
            tvNote.setVisibility(View.GONE);
            if (swipeRefreshLayout.isRefreshing()) {
                swipeRefreshLayout.setRefreshing(false);
            }
            response = new Gson().fromJson(netData, NetResponse.class);
            adapter.setResponse(response);
        } else {
            tvNote.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showError(String errorMsg) {
        if (swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }
    }
}

package com.example.mvpdemo.mvedemo;

import android.os.AsyncTask;
import android.os.Handler;

import java.io.IOException;

public class MyPresenter implements ITaskContract.Presenter {

    NetModle netModle;
    ITaskContract.View view;
    Handler handler;

    public MyPresenter(NetModle netModle, ITaskContract.View view) {
        if (netModle != null) {
            this.netModle = netModle;
        }
        if (view != null) {
            this.view = view;
        }
        this.view.setPresenter(this);
    }

    @Override
    public void loadData() {
        load();
    }


    private void load() {
        new SubAsyncTask().execute();
    }

    class SubAsyncTask extends AsyncTask<Void, Void, String>
    {
        @Override
        protected String doInBackground(Void... voids) {
            String apiStr = null;
            try {
                apiStr = netModle.getApi();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return apiStr;
        }

        @Override
        protected void onPostExecute(String s) {
            view.showGetData(s);
        }
    }


}

package com.example.mvpdemo.mvedemo;

public interface ITaskContract {

    interface BaseView<T> {
        void setPresenter(T presenter);
    }

    interface BasePresenter
    {
        void loadData();
    }

    interface View extends BaseView<Presenter>
    {
        void showGetData(String netData);

        void showError(String errorMsg);
    }


    interface Presenter extends BasePresenter{

    }

}

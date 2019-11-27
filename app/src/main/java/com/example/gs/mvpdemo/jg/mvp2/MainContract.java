package com.example.gs.mvpdemo.jg.mvp2;
import okhttp3.Callback;

/**
 * 契约接口，可以很直观的看到 M、V、P 层接口中提供的方法
 */
public interface MainContract {
    interface IMainModel {
        void requestBaidu(Callback callback);
    }

    interface IMainView extends IBaseView{
        void showDialog();

        void succes(String content);
    }

    interface IMainPresenter extends IBasePresenter {
        void handlerData();
    }
}
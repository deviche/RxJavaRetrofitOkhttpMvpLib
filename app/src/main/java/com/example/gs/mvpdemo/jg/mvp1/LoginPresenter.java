package com.example.gs.mvpdemo.jg.mvp1;

import rx.Subscriber;

public class LoginPresenter extends BaseMvpPresenter<LoginModel,LoginView> {

    public void TestGetApiData() {//请求数据
        model.dealHttpRequest(new Subscriber<MvpBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                getView().getLoginFailed(e.getMessage());
                getView().showToast(e.getMessage());
            }

            @Override
            public void onNext(MvpBean mvpBean) {
                getView().getLoginSuccessful(mvpBean);
            }
        });
    }


    @Override
    public void attach(LoginView testView) {
        setView(testView);//设置View层对象
    }

    @Override
    public void detach() {
        //移除网络请求
        model.removeSubscriber();
    }

    @Override
    public LoginModel createModel() {
        return new LoginModel();//创建M层对象
    }
}

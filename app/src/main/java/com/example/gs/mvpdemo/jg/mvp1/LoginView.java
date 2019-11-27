package com.example.gs.mvpdemo.jg.mvp1;

public interface LoginView extends BaseMvpView {
    void getLoginSuccessful(MvpBean mvpBean);//参数自己定义
    void getLoginFailed(String s);
}

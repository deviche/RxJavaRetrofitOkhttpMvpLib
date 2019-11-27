package com.example.gs.mvpdemo.jg.mvp2;


public interface IBasePresenter<V extends IBaseView> {

    void attech(V view);

    void detech();
}

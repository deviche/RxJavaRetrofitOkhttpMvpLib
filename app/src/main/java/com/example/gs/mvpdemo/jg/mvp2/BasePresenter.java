package com.example.gs.mvpdemo.jg.mvp2;



public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter {
    protected V mView;

    @SuppressWarnings("unchecked")
    @Override
    public void attech(IBaseView view) {
        mView = (V) view;
    }

    @Override
    public void detech() {
        mView = null;
    }
}

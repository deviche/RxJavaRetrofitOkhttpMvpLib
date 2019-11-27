package com.example.gs.mvpdemo.jg.mvp1;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseMvpActivity<V extends BaseMvpPresenter, K extends BaseMvpView> extends AppCompatActivity {

    public V presenter;
    public K mvpView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        initMvp();
        super.onCreate(savedInstanceState);
    }

    private void initMvp() {
        presenter = createPresenter();
        mvpView = createMvpView();
        if (presenter != null && mvpView != null) {
            presenter.attach(mvpView);//关联
        }
    }
    //让子类实现，创建对应的P对象
    public abstract V createPresenter();
    //让子类实现，创建对应的V对象
    public abstract K createMvpView();

    @Override
    protected void onDestroy() {
        if (presenter != null) {//取消关联
            presenter.detach();
        }
        super.onDestroy();
    }
}

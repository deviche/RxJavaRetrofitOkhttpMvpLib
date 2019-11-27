package com.example.gs.mvpdemo.jg.mvp2;


import android.content.Context;
import android.os.Bundle;

import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<P extends IBasePresenter> extends AppCompatActivity implements IBaseView {

    protected P mPresenter;

    protected abstract void initLayout(@Nullable Bundle savedInstanceState);

    protected abstract void initViews();

    protected abstract void initData();

    protected abstract P setPresenter();

    protected <T extends View> T $(@IdRes int viewId) {
        return findViewById(viewId);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initLayout(savedInstanceState);

        /**
         * 实例化和绑定 P 层
         */
        mPresenter = setPresenter();
        mPresenter.attech(this);

        initViews();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /**
         * 解绑，避免内存泄漏
         */
        mPresenter.detech();
        mPresenter = null;
    }

    @Override
    public Context getContext() {
        return this;
    }
}

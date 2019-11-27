package com.example.gs.mvpdemo.jg.mvp2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;

import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.gs.mvpdemo.R;


/**
 * MVP 的写法，Version 2: 使用模板方法模式 + 泛型 封装 mvp 基类
 *
 * @author 神探丶威威猫
 * @blog https://blog.csdn.net/smile_running
 * @warning 点个赞哦，评个论哦
 */
public class MainActivity extends BaseActivity<MainContract.IMainPresenter> implements MainContract.IMainView {

    private TextView tv;

    @Override
    protected void initLayout(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initViews() {
//        tv = $(R.id.tv);
    }

    @Override
    protected void initData() {
        mPresenter.handlerData();
    }

    @Override
    protected MainContract.IMainPresenter setPresenter() {
        return new MainPresenter();
    }

    @Override
    public void showDialog() {
        ProgressDialog dialog = new ProgressDialog(getContext());
        dialog.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
            }
        }, 1500);
    }

    @Override
    public void succes(String content) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getContext(), "" + content, Toast.LENGTH_SHORT).show();
                tv.setText(content);
            }
        });
    }
}

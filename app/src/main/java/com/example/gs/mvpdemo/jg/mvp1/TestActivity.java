package com.example.gs.mvpdemo.jg.mvp1;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.gs.mvpdemo.R;

public class TestActivity extends BaseMvpActivity<LoginPresenter, LoginView> {

    private static final String TAG = "TestActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter.TestGetApiData();
    }

    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    public LoginView createMvpView() {
        return mTestView;
    }

    private LoginView mTestView = new LoginView() {
        @Override
        public void showToast(String s) {

        }

        @Override
        public void getLoginSuccessful(MvpBean mvpBean) {
            Log.e(TAG, "success: " + mvpBean.getCode());
        }

        @Override
        public void getLoginFailed(String s) {

        }
    };

}

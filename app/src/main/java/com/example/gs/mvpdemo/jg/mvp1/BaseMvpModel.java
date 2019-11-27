package com.example.gs.mvpdemo.jg.mvp1;

import android.util.Log;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class BaseMvpModel {
    private static final String TAG = "BaseMvpModel";
    protected final CompositeSubscription mCompositeSubscription = new CompositeSubscription();

    public void addSubscriber(Subscription subscription) {
        mCompositeSubscription.add(subscription);
        Log.e(TAG, "addSubscriber: 添加");
    }

    public void removeSubscriber() {
        Log.e(TAG, "removeSubscriber: 移除");
        if (!mCompositeSubscription.isUnsubscribed()) {
            mCompositeSubscription.unsubscribe();
        }
    }
}

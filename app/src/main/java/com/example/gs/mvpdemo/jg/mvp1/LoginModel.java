package com.example.gs.mvpdemo.jg.mvp1;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class LoginModel extends BaseMvpModel{
    private static final String TAG = "LoginModel";

    public void dealHttpRequest(Subscriber<MvpBean> subscriber) {//模拟网络请求
        Subscription subscribe = Observable.timer(3, TimeUnit.SECONDS).flatMap(new Func1<Long, Observable<MvpBean>>() {
            @Override
            public Observable<MvpBean> call(Long aLong) {
                Observable<MvpBean> mvpBeanObservable = Observable.create(new Observable.OnSubscribe<MvpBean>() {
                    @Override
                    public void call(Subscriber<? super MvpBean> subscriber) {
                        MvpBean mvpBean = new MvpBean();
                        mvpBean.setCode(100);
                        subscriber.onNext(mvpBean);
                        subscriber.onCompleted();
                    }
                });
                return mvpBeanObservable;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
        //添加网络请求
        addSubscriber(subscribe);
    }
}

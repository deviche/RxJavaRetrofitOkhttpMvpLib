package com.example.gs.mvpdemo.jg.mvp1;

public abstract class BaseMvpPresenter<M extends BaseMvpModel,V extends BaseMvpView> {

    private V view;
    public final M model;

    public BaseMvpPresenter() {
        this.model = createModel();
    }
    //关联view层，得到view层的对象
    public abstract void attach(V v);
    //取消关联，移除网络请求操作，避免内存泄漏
    public abstract void detach();
    //创建对应的M层
    public abstract M createModel();

    public V getView() {
        return view;
    }

    public void setView(V view) {
        this.view = view;
    }
}

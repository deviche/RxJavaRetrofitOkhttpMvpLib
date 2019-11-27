package com.example.gs.mvpdemo.utils;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Administrator on 2018/7/4.
 */

public class EventBusUtil {
    public static void register(Object obj) {
        if (!EventBus.getDefault().isRegistered(obj)) {
            EventBus.getDefault().register(obj);
        }
    }

    public static void unregister(Object obj) {
        if (EventBus.getDefault().isRegistered(obj)) {
            EventBus.getDefault().unregister(obj);
        }
    }
}

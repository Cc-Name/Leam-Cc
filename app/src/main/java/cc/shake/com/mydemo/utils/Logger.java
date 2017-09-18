package cc.shake.com.mydemo.utils;

import com.orhanobut.logger.AndroidLogAdapter;

import cc.shake.com.mydemo.BuildConfig;

/**
 * Created by mac on 2017/9/7.
 */

public class Logger {


    //初始化Logger日志
    public void initLogger() {



        com.orhanobut.logger.Logger.addLogAdapter(new AndroidLogAdapter());
        com.orhanobut.logger.Logger.clearLogAdapters();
        com.orhanobut.logger.Logger.addLogAdapter(new AndroidLogAdapter() {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return BuildConfig.DEBUG;
            }
        });
    }


}



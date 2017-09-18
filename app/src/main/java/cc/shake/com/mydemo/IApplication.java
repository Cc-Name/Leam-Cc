package cc.shake.com.mydemo;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.util.Log;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;


/**
 * Created by mac on 2017/9/7.
 */

public class IApplication extends Application {


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);//处理minSdkVersion<21时在应用方法总数大于65536时应用能可执行文件分包

    }


    private static IApplication instance;

    public static IApplication getInstance() {
        return instance;
    }

    //在该方法里面初始化程序相关配置
    @Override
    public void onCreate() {
        super.onCreate();
        this.instance = this;
        //初始化Loger日志
        cc.shake.com.mydemo.utils.Logger logger = new cc.shake.com.mydemo.utils.Logger();
        logger.initLogger();



    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }


}

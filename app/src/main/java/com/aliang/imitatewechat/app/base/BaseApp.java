package com.aliang.imitatewechat.app.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.support.annotation.MainThread;
import android.support.multidex.MultiDexApplication;

import com.aliang.imitatewechat.ui.base.BaseFragment;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 * Created by AlvinMoon on 2018/4/27.
 */

public class BaseApp extends MultiDexApplication {
    public static List<Activity> activities = new LinkedList<>();
    //以下属性应用于整个应用程序，合理利用资源，减少资源浪费
    //上下文
    private static Context mContext;
    //主线程
    private static Thread mMainThread;
    //主线程id
    private static long mMainThreadId;
    //循环队列
    private static Looper mMainLooper;
    //主线程Handler
    private static Handler mHandler;

    @Override
    public void onCreate() {
        super.onCreate();

        //对全局属性赋值
        mContext = getApplicationContext();
        mMainThread = Thread.currentThread();
        mMainThreadId = Process.myTid();
        mHandler = new Handler();
    }

    /**完全退出程序功能**/
    public static void exit(){
        for (Activity activity : activities){
            activity.finish();
        }
    }

    /**重启当前应用**/
    public static void reStart(){
        Intent intent = mContext.getPackageManager().getLaunchIntentForPackage(mContext.getPackageName());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        mContext.startActivity(intent);
    }

    public static Context getContext(){
        return mContext;
    }
    public static void setContext(Context context){
        BaseApp.mContext = context;
    }
    public static Thread getMainThread(){
        return mMainThread;
    }
    public static void setMainThread(Thread thread){
        BaseApp.mMainThread = thread;
    }
    public static Handler getHandler(){
        return mHandler;
    }
    public static void setHandler(Handler handler){
        BaseApp.mHandler = handler;
    }

    public static long getMainThreadId() {
        return mMainThreadId;
    }

    public static void setMainThreadId(long mMainThreadId) {
        BaseApp.mMainThreadId = mMainThreadId;
    }
    public static Looper getMainThreadLooper() {
        return mMainLooper;
    }

    public static void setMainThreadLooper(Looper mMainLooper) {
        BaseApp.mMainLooper = mMainLooper;
    }
}

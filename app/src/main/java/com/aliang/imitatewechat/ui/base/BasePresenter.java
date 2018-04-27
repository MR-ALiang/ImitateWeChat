package com.aliang.imitatewechat.ui.base;


import java.lang.ref.WeakReference;

/**
 * Created by AlvinMoon on 2018/4/27.
 */

public class BasePresenter<V> {
    private final BaseActivity mContext;
    protected WeakReference<V> mViewRef;

    public BasePresenter(BaseActivity context) {
        this.mContext = context;
    }

    public void attachView(V v){
        mViewRef = new WeakReference<>(v);
    }

    public void detachView(){
        if(mViewRef != null){
            mViewRef.clear();
            mViewRef = null;
        }
    }

    public V getView(){
        return mViewRef != null ? mViewRef.get() : null;
    }
}

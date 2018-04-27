package com.aliang.imitatewechat.ui.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.aliang.imitatewechat.app.MyApp;

import butterknife.ButterKnife;

/**
 * Created by AlvinMoon on 2018/4/26.
 */

public abstract class BaseActivity<V,T extends BasePresenter<V>> extends AppCompatActivity {
    protected T mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApp.activities.add(this);
        init();

        /**判断是否使用MVP模式**/
        mPresenter = createPresenter();
        if(mPresenter != null){
            //之后所有的子类都要实现对应的View接口
            mPresenter.attachView((V) this);
        }
        /**子类不再需要设置布局ID，也不再需要使用ButterKnife.bind()**/
        setContentView(provideContentViewId());
        ButterKnife.bind(this);

        initView();
        initData();
        initListener();
    }

    protected void initView() {

    }

    protected void initData() {

    }

    protected void initListener() {

    }

    /**得到当前界面的布局文件id(由子类实现)**/
    protected abstract int provideContentViewId();

    /**用于创建Presenter和判断是否使用MVP模式(由子类实现)**/
    protected abstract T createPresenter();

    //在setContentView()调用之前调用，可以设置WindowFeature(如：this.requestWindowFeature(Window.FEATURE_NO_TITLE);)
    protected void init() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter != null){
            mPresenter.detachView();
        }
    }

    public void jumpToActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }
}

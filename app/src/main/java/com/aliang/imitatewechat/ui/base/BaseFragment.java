package com.aliang.imitatewechat.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by AlvinMoon on 2018/4/26.
 */

public abstract class BaseFragment<V,T extends BasePresenter> extends Fragment {
    protected T mPresenter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();

        /**判断是否要使用MVP模式**/
        mPresenter = createPresenter();
        if(mPresenter != null){
            /**因为之后所有的子类都要实现对应的view接口**/
            mPresenter.attachView(this);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /**子类不再需要设置布局ID，也不再需要使用ButterKnife.bind()**/
        View rootView = inflater.inflate(provideContentViewId(),container,false);
        ButterKnife.bind(this,rootView);
        initView(rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        initListener();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mPresenter != null){
            mPresenter.detachView();
        }
    }

    private void initListener() {

    }

    private void initData() {
    }

    private void initView(View rootView) {

    }

    /**得到当前布局文件的id(由子类实现)**/
    protected abstract int provideContentViewId();

    /**用于创建Presenter和判断是否使用MVP模式(由子类实现)**/
    protected abstract T createPresenter();

    private void init() {

    }


}

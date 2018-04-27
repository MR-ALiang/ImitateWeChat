package com.aliang.imitatewechat.ui.activity;

import android.widget.Button;
import android.widget.EditText;

import com.aliang.imitatewechat.R;
import com.aliang.imitatewechat.ui.base.BaseActivity;

import com.aliang.imitatewechat.ui.presenter.RegisterAtPresenter;
import com.aliang.imitatewechat.ui.view.IRegisterAtView;

/**
 * Created by AlvinMoon on 2018/4/27.
 */

public class RegisterActivity extends BaseActivity<IRegisterAtView,RegisterAtPresenter> implements IRegisterAtView{
    @Override
    public EditText getEtNickName() {
        return null;
    }

    @Override
    public EditText getEtPhone() {
        return null;
    }

    @Override
    public EditText getEtPwd() {
        return null;
    }

    @Override
    public EditText getVerifyCode() {
        return null;
    }

    @Override
    public Button getBtnSendCode() {
        return null;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_register;
    }

    @Override
    protected RegisterAtPresenter createPresenter() {
        return new RegisterAtPresenter(this);
    }
}

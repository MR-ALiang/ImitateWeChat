package com.aliang.imitatewechat.ui.activity;

import android.widget.EditText;

import com.aliang.imitatewechat.R;
import com.aliang.imitatewechat.ui.base.BaseActivity;
import com.aliang.imitatewechat.ui.presenter.LoginAtPresenter;
import com.aliang.imitatewechat.ui.view.ILoginAtView;

/**
 * Created by AlvinMoon on 2018/4/27.
 */

public class LoginActivity extends BaseActivity<ILoginAtView,LoginAtPresenter> implements ILoginAtView{
    @Override
    public EditText getEtPhone() {
        return null;
    }

    @Override
    public EditText getEtPwd() {
        return null;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected LoginAtPresenter createPresenter() {
        return new LoginAtPresenter(this);
    }
}

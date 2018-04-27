package com.aliang.imitatewechat.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.aliang.imitatewechat.R;
import com.aliang.imitatewechat.ui.base.BaseActivity;
import com.aliang.imitatewechat.ui.base.BasePresenter;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by AlvinMoon on 2018/4/27.
 */

public class SplashActivity extends BaseActivity {
    @Bind(R.id.ivToolbarNavigation)
    ImageView ivToolbarNavigation;
    @Bind(R.id.vToolbarDivision)
    View vToolbarDivision;
    @Bind(R.id.tvToolbarSubTitle)
    TextView tvToolbarSubTitle;
    @Bind(R.id.ibAddMenu)
    ImageButton ibAddMenu;
    @Bind(R.id.llToolbarAddFriend)
    AutoLinearLayout llToolbarAddFriend;
    @Bind(R.id.llToolbarSearch)
    AutoLinearLayout llToolbarSearch;
    @Bind(R.id.btnToolbarSend)
    Button btnToolbarSend;
    @Bind(R.id.ibToolbarMore)
    ImageButton ibToolbarMore;
    @Bind(R.id.btnLogin)
    Button btnLogin;
    @Bind(R.id.btnRegister)
    Button btnRegister;
    @Bind(R.id.rlButton)
    AutoRelativeLayout rlButton;

    @Override
    protected void init() {

    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_splash;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @OnClick({R.id.btnLogin, R.id.btnRegister})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                jumpToActivity(LoginActivity.class);
                finish();
                break;
            case R.id.btnRegister:
                jumpToActivity(RegisterActivity.class);
                finish();
                break;
        }
    }
}

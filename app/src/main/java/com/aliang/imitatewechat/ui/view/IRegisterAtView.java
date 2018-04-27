package com.aliang.imitatewechat.ui.view;

import android.widget.Button;
import android.widget.EditText;

/**
 * Created by AlvinMoon on 2018/4/27.
 */

public interface IRegisterAtView {

    EditText getEtNickName();

    EditText getEtPhone();

    EditText getEtPwd();

    EditText getVerifyCode();

    Button getBtnSendCode();
}

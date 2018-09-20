package com.tuphanthanh.phongtro.login.presenter;

import com.tuphanthanh.phongtro.login.view.LoginActivity;

public class LoginPresenter implements ILoginPresenter {
    private LoginActivity loginActivity;
    public LoginPresenter(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
    }

    @Override
    public void login(String email, String password) {
        if (email.equals("mr.tus97@gmail.com") && password.equals("123456")){
            loginActivity.loginSuccess();
        }else{
            loginActivity.loginFailure();
        }
    }
}

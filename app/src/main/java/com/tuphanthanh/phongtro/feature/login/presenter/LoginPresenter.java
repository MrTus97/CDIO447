package com.tuphanthanh.phongtro.feature.login.presenter;

import com.tuphanthanh.phongtro.api.ApiClient;
import com.tuphanthanh.phongtro.api.ApiInterface;
import com.tuphanthanh.phongtro.feature.login.model.LoginResult;
import com.tuphanthanh.phongtro.feature.login.view.LoginActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.tuphanthanh.phongtro.ultils.Constant.apiService;

public class LoginPresenter implements ILoginPresenter {
    private LoginActivity loginActivity;
    public LoginPresenter(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
    }

    @Override
    public void login(String email, String password) {
        Call<LoginResult> call = apiService.login(email, password);
        call.enqueue(new Callback<LoginResult>() {
            @Override
            public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                if (response.code() == 200){
                    loginActivity.loginSuccess();
                }else{
                    loginActivity.loginFailure();
                }
            }

            @Override
            public void onFailure(Call<LoginResult> call, Throwable t) {
                loginActivity.loginFailure();
            }
        });
    }
}

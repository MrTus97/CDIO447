package com.tuphanthanh.phongtro.feature.users.renter.presenter;



import com.tuphanthanh.phongtro.feature.users.model.UserResponse;
import com.tuphanthanh.phongtro.feature.users.renter.view.RenterFragment;
import com.tuphanthanh.phongtro.ultils.Constant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RenterPresenter implements IRenterPrensenter {
    private RenterFragment renterFragment;
    public RenterPresenter(RenterFragment renterFragment) {
        this.renterFragment = renterFragment;
    }

    @Override
    public void getListRenter() {
        Call<UserResponse> call = Constant.apiService.getRenter();
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.code() ==200){
                    renterFragment.getListSucess(response.body());
                }else{
                    renterFragment.getListFailure();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                renterFragment.getListError();
            }
        });
    }
}

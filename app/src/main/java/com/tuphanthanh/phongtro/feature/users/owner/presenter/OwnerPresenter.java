package com.tuphanthanh.phongtro.feature.users.owner.presenter;

import com.tuphanthanh.phongtro.feature.users.model.UserResponse;
import com.tuphanthanh.phongtro.feature.users.owner.view.OwnerFragment;
import com.tuphanthanh.phongtro.ultils.Constant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OwnerPresenter implements  IOwnerPresenter{
    private OwnerFragment ownerFragment;
    public OwnerPresenter(OwnerFragment ownerFragment) {
        this.ownerFragment = ownerFragment;
    }

    @Override
    public void getListOwner() {

        Call<UserResponse> call = Constant.apiService.getOwner();
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.code() ==200){
                    ownerFragment.getOwnerSuccess(response.body());
                }else{
                    ownerFragment.getOwnerFailure();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                ownerFragment.getError(t);
            }
        });
    }
}

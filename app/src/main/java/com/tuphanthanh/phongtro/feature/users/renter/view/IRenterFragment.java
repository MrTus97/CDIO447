package com.tuphanthanh.phongtro.feature.users.renter.view;

import com.tuphanthanh.phongtro.feature.users.model.UserResponse;

public interface IRenterFragment {
    public void getListSucess(UserResponse body);
    public void getListFailure();
    public void getListError();
}

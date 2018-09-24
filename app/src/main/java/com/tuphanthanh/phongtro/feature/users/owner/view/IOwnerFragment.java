package com.tuphanthanh.phongtro.feature.users.owner.view;

import com.tuphanthanh.phongtro.feature.users.model.UserResponse;

public interface IOwnerFragment {
    public void getOwnerSuccess(UserResponse body);
    public void getOwnerFailure();
    public void getError(Throwable t);
}

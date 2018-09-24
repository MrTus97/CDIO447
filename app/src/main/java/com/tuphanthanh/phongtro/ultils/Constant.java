package com.tuphanthanh.phongtro.ultils;

import com.tuphanthanh.phongtro.api.ApiClient;
import com.tuphanthanh.phongtro.api.ApiInterface;

public class Constant {
    public static final ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
    public static final String EXTRA_LOGIN_TO_HOME_USER = "TenDangNhap";

    //Menu model
    public static final String MENU_ID_DASBOARD = "mn_1_dashboard";
    public static final String MENU_ID_USER = "mn_1_user";
    public static final String MENU_ID_ROOM = "mn_1_room";
    public static final String MENU_ID_POST = "mn_1_post";
    public static final String MENU_ID_OWNER = "mn_1_owner";
    public static final String MENU_ID_RENTER = "mn_1_renter";


}

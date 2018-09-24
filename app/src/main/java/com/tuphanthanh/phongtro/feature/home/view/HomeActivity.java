package com.tuphanthanh.phongtro.feature.home.view;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tuphanthanh.phongtro.R;
import com.tuphanthanh.phongtro.feature.dashboard.view.DashBoardFragment;
import com.tuphanthanh.phongtro.feature.home.model.MenuModel;
import com.tuphanthanh.phongtro.feature.users.owner.view.OwnerFragment;
import com.tuphanthanh.phongtro.feature.users.renter.view.RenterFragment;
import com.tuphanthanh.phongtro.ultils.Constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    ExpandableListAdapter expandableListAdapter;
    ExpandableListView expandableListView;
    List<MenuModel> headerList = new ArrayList<>();
    HashMap<MenuModel, List<MenuModel>> childList = new HashMap<>();
    private NavigationView navigation_menu;
    private View navHeader;
    private ImageView imv_avatar;
    private TextView tv_nameProfile;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        createMenu();
        //first launch go to dashboard fragment
        getSupportFragmentManager()
                .beginTransaction().replace(R.id.fragment_container,new DashBoardFragment())
                .commit();
    }

    private void createMenu() {
        MenuModel menuModel;
        menuModel = new MenuModel(Constant.MENU_ID_DASBOARD,getString(R.string.mnDashboard),true,false,null);
        headerList.add(menuModel);
        menuModel = new MenuModel(Constant.MENU_ID_USER,getString(R.string.mnUser),true,true,null);
        headerList.add(menuModel);
        List<MenuModel> childModel = new ArrayList<>();
        MenuModel childNode;
        childNode = new MenuModel(Constant.MENU_ID_OWNER,getString(R.string.mnOwner),false,false,null);
        childModel.add(childNode);
        childNode = new MenuModel(Constant.MENU_ID_RENTER,getString(R.string.mnRenter),false,false,null);
        childModel.add(childNode);
        if (menuModel.hasChildren){
            childList.put(menuModel,childModel);
        }
        menuModel = new MenuModel(Constant.MENU_ID_ROOM,getString(R.string.mnRoom),true,false,null);
        headerList.add(menuModel);
        menuModel = new MenuModel(Constant.MENU_ID_POST,getString(R.string.mnPost),true,false,null);
        headerList.add(menuModel);
        expandableListAdapter = new com.tuphanthanh.phongtro.adapter.ExpandableListAdapter(this, headerList, childList);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                if (headerList.get(i).isGroup && !headerList.get(i).hasChildren ){
                    switch (headerList.get(i).id){
                        case Constant.MENU_ID_DASBOARD:
                            setTitle(headerList.get(i).menuName);
                            getSupportFragmentManager()
                                    .beginTransaction().replace(R.id.fragment_container,new DashBoardFragment())
                                    .commit();
                            break;
                        case Constant.MENU_ID_ROOM:
                            setTitle(headerList.get(i).menuName);
                            break;
                        case Constant.MENU_ID_POST:
                            setTitle(headerList.get(i).menuName);
                            break;
                        default:break;
                    }
                    onBackPressed();
                }
                return false;
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                if (childList.get(headerList.get(i)) != null) {
                    MenuModel model = childList.get(headerList.get(i)).get(i1);
                    if(model.id.equals(Constant.MENU_ID_OWNER)){
                        setTitle(headerList.get(i).menuName);
                        getSupportFragmentManager()
                                .beginTransaction().replace(R.id.fragment_container,new OwnerFragment())
                                .commit();
                    }else{
                        setTitle(headerList.get(i).menuName);
                        getSupportFragmentManager()
                                .beginTransaction().replace(R.id.fragment_container,new RenterFragment())
                                .commit();
                    }
                }
                onBackPressed();
                return false;
            }
        });
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.layoutHomeAct_home);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        //không gọi tới super.onBackPressed() để disable nút back về login activity

    }
    private void init() {
        navigation_menu = findViewById(R.id.nvHomeAct_Menu);
        navigation_menu.setNavigationItemSelectedListener(this);
        navHeader = navigation_menu.getHeaderView(0);
        imv_avatar = navHeader.findViewById(R.id.imvHeaderMain_avatar);
        navigation_menu.setSelected(true);
        tv_nameProfile =  navHeader.findViewById(R.id.tvHeaderMain_Name);
        tv_nameProfile.setText(getIntent().getStringExtra(Constant.EXTRA_LOGIN_TO_HOME_USER));
        toolbar = findViewById(R.id.tbContentHomeAct_toolbar);
        setSupportActionBar(toolbar);
        expandableListView = findViewById(R.id.elvHomeAct_Menu);

        mDrawerLayout = findViewById(R.id.layoutHomeAct_home);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}

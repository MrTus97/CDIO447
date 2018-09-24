package com.tuphanthanh.phongtro.feature.users.renter.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.tuphanthanh.phongtro.R;
import com.tuphanthanh.phongtro.adapter.UserAdapter;
import com.tuphanthanh.phongtro.feature.users.model.UserResponse;
import com.tuphanthanh.phongtro.feature.users.renter.presenter.RenterPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class RenterFragment extends Fragment implements IRenterFragment {
    private final String TAG = RenterFragment.class.getSimpleName();
    View view;
    private RecyclerView rvRenters;
    private TextView tvNothing;
    private RenterPresenter renterPresenter;
    private LinearLayoutManager layoutManager;

    private int total;
    public RenterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=  inflater.inflate(R.layout.fragment_renter, container, false);
        init();
        getApi();
        return view;
    }

    private void getApi() {
        renterPresenter.getListRenter();
    }

    private void init() {
        rvRenters = view.findViewById(R.id.rvRenterFra_List);
        tvNothing = view.findViewById(R.id.tvRenterFra_NothingToShow);

        renterPresenter = new RenterPresenter(this);
        layoutManager = new LinearLayoutManager(getContext());
        rvRenters.setLayoutManager(layoutManager);
    }

    @Override
    public void getListSucess(UserResponse body) {
        Log.d(TAG,"get list success");
        total = body.getTotal();
        if (total > 0){
            UserAdapter adapter = new UserAdapter(getContext(),body.getData());
            rvRenters.setAdapter(adapter);
        }else{
            rvRenters.setVisibility(View.GONE);
            tvNothing.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void getListFailure() {
        Log.d(TAG,"get list failure");
        Toast.makeText(getContext(),"get list failure",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getListError() {
        Log.d(TAG,"get list error");
        Toast.makeText(getContext(),"error server",Toast.LENGTH_SHORT).show();
    }
}

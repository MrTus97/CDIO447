package com.tuphanthanh.phongtro.feature.users.owner.view;


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
import com.tuphanthanh.phongtro.feature.users.owner.presenter.OwnerPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class OwnerFragment extends Fragment implements IOwnerFragment {
    private final String TAG = OwnerFragment.class.getSimpleName();
    View view;
    private RecyclerView rvOwners;
    private TextView tvNothing;
    private OwnerPresenter ownerPresenter;
    private LinearLayoutManager layoutManager;
    //get api
    private int total = 0;
    public OwnerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_owner, container, false);

        init();
        getApi();

        return  view;
    }
    private void getApi(){
        ownerPresenter.getListOwner();
    }
    private void init() {
        rvOwners = view.findViewById(R.id.rvOwnerFra_List);
        tvNothing = view.findViewById(R.id.tvOwnerFra_NothingToShow);

        ownerPresenter = new OwnerPresenter(this);
        layoutManager = new LinearLayoutManager(getContext());
        rvOwners.setLayoutManager(layoutManager);

    }

    @Override
    public void getOwnerSuccess(UserResponse body) {
        Log.d(TAG,"get user success");
        total = body.getTotal();
        if (total > 0){
            UserAdapter adapter = new UserAdapter(getContext(),body.getData());
            rvOwners.setAdapter(adapter);
        }else{
            rvOwners.setVisibility(View.GONE);
            tvNothing.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void getOwnerFailure() {
        Toast.makeText(getContext(),"Get value failure",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getError(Throwable t) {
        Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
    }
}

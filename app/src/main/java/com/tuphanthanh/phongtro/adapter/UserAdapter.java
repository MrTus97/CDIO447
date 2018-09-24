package com.tuphanthanh.phongtro.adapter;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.tuphanthanh.phongtro.R;
import com.tuphanthanh.phongtro.feature.users.model.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.Holder>  {
    private Context context;
    private List<User> list;
    public UserAdapter(Context context, List<User> data) {
        this.context = context;
        this.list = data;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new Holder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int position) {
        holder.tvUsername.setText(list.get(position).getTendangnhap());
        holder.tvName.setText(list.get(position).getTen());
        holder.tvAddress.setText(list.get(position).getDiachi());
        holder.tvPhoneNumber.setText(list.get(position).getSdt());
        holder.tvWrongfulNumber.setText(list.get(position).getSolanvipham());
//        if (list.get(position).getIsblock().equalsIgnoreCase("Yes")){
//            holder.tvStatus.setText("BLOCK");
//            holder.tvStatus.setBackgroundColor(Color.RED);
//        }
        holder.imbEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"edit" + String.valueOf(position),Toast.LENGTH_SHORT).show();
            }
        });
        holder.imbDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"delete" +String.valueOf(position),Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {
        private TextView tvUsername;
        private TextView tvName;
        private TextView tvAddress;
        private TextView tvPhoneNumber;
        private TextView tvWrongfulNumber;

        private TextView tvStatus;
        private ImageButton imbEdit;
        private ImageButton imbDelete;
        public Holder(View itemView) {
            super(itemView);
            tvUsername = itemView.findViewById(R.id.tvItemUser_Username);
            tvName = itemView.findViewById(R.id.tvItemUser_Name);
            tvAddress = itemView.findViewById(R.id.tvItemUser_Address);
            tvPhoneNumber = itemView.findViewById(R.id.tvItemUser_PhoneNumber);
            tvWrongfulNumber = itemView.findViewById(R.id.tvItemUser_WrongfulNumber);
            tvStatus = itemView.findViewById(R.id.tvItemUser_Status);

            imbEdit = itemView.findViewById(R.id.imbItemUser_Edit);
            imbDelete = itemView.findViewById(R.id.imbItemUser_Delete);
        }
    }

}

package com.zwh.xingyutest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zwh.xingyutest.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author Richard
 * @time 2020/1/21
 * @describe 行程页队长发布页，申请名单的 RecyclerView 的 Adapter
 */
public class RouteMyApplyItemAdapter extends RecyclerView.Adapter {

    private Context mContext;

    public RouteMyApplyItemAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_route_my_apply, parent,
                false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //do
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public CircleImageView head;
        public CircleImageView sex;
        public TextView id;
        public Button select;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            head = itemView.findViewById(R.id.civ_route_my_head);
            sex = itemView.findViewById(R.id.civ_my_apply_sex);
            select = itemView.findViewById(R.id.btn_route_my_select);
        }
    }
}

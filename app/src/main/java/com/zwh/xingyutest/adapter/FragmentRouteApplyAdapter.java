package com.zwh.xingyutest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zwh.xingyutest.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author Richard
 * @time 2020/1/20
 * @describe 行程页申请列表（RecyclerView）的 Adapter
 */
public class FragmentRouteApplyAdapter extends RecyclerView.Adapter {

    private Context mContext;

    public FragmentRouteApplyAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_route_applylist, parent,
                false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //do

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView startPlace;
        public TextView endPlace;
        public TextView data;
        public TextView time;
        public CircleImageView head;
        public TextView id;
        public TextView agree;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            startPlace = itemView.findViewById(R.id.tv_route_apply_start);
            endPlace = itemView.findViewById(R.id.tv_route_apply_end);
            data = itemView.findViewById(R.id.tv_route_apply_data);
            time = itemView.findViewById(R.id.tv_route_apply_time);
            head = itemView.findViewById(R.id.civ_route_apply_head);
            id = itemView.findViewById(R.id.tv_route_apply_id);
            agree = itemView.findViewById(R.id.tv_route_apply_agree);
        }
    }

}

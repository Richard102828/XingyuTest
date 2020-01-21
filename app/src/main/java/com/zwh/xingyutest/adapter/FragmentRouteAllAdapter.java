package com.zwh.xingyutest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zwh.xingyutest.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author Richard
 * @time 2020/1/20
 * @describe 行程页 所有行程页 RecyclerView 的 Adapter
 */
public class FragmentRouteAllAdapter extends RecyclerView.Adapter {

    private Context mContext;

    public FragmentRouteAllAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_route_all, parent,
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
        public TextView data;
        public TextView time;
        public TextView week;
        public ImageView delete;
        public TextView start;
        public TextView end;
        public CircleImageView captainSex;
        public TextView captain;
        public CircleImageView teammateSex;
        public TextView teammate;
        public TextView ended;
        public TextView communicate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            data = itemView.findViewById(R.id.tv_route_all_data);
            time = itemView.findViewById(R.id.tv_route_all_time);
            week = itemView.findViewById(R.id.tv_route_all_week);
            delete = itemView.findViewById(R.id.img_route_all_delete);
            start = itemView.findViewById(R.id.tv_route_all_start);
            end = itemView.findViewById(R.id.tv_route_all_end);
            captainSex = itemView.findViewById(R.id.civ_all_captain_sex);
            captain = itemView.findViewById(R.id.tv_route_all_captain);
            teammateSex = itemView.findViewById(R.id.civ_all_teammate_sex);
            teammate = itemView.findViewById(R.id.tv_route_all_teammate);
            ended = itemView.findViewById(R.id.tv_route_all_ended);
            communicate = itemView.findViewById(R.id.tv_route_all_communicate);
        }
    }
}

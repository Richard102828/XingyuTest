package com.zwh.xingyutest.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zwh.xingyutest.ItemDecoration;
import com.zwh.xingyutest.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author Richard
 * @time 2020/1/20
 * @describe 行程页队长发布页 RecyclerView 的 Adapter
 */
public class FragmentRouteMyAdapter extends RecyclerView.Adapter {

    private Context mContext;

    public FragmentRouteMyAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_route_my, parent,
                false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //do
        ViewHolder holder1 = (ViewHolder) holder;
        RouteMyApplyItemAdapter itemAdapter = new RouteMyApplyItemAdapter(mContext);
        LinearLayoutManager manager = new LinearLayoutManager(mContext, RecyclerView.VERTICAL,
                false);
        holder1.rcvApply.setAdapter(itemAdapter);
        holder1.rcvApply.setLayoutManager(manager);
        holder1.rcvApply.addItemDecoration(new ItemDecoration(20));
        holder1.rcvApply.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                if (e.getAction() == MotionEvent.ACTION_DOWN || e.getAction() ==
                        MotionEvent.ACTION_MOVE) {
                    rv.getParent().requestDisallowInterceptTouchEvent(true);
                } else if (e.getAction() == MotionEvent.ACTION_UP){
                    rv.getParent().requestDisallowInterceptTouchEvent(false);
                }
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return 3;
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
        public RecyclerView rcvApply;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            data = itemView.findViewById(R.id.tv_route_my_data);
            time = itemView.findViewById(R.id.tv_route_my_time);
            week = itemView.findViewById(R.id.tv_route_my_week);
            delete = itemView.findViewById(R.id.img_route_my_delete);
            start = itemView.findViewById(R.id.tv_route_my_start);
            end = itemView.findViewById(R.id.tv_route_my_end);
            captainSex = itemView.findViewById(R.id.civ_my_captain_sex);
            captain = itemView.findViewById(R.id.tv_route_my_captain);
            teammateSex = itemView.findViewById(R.id.civ_my_teammate_sex);
            teammate = itemView.findViewById(R.id.tv_route_my_teammate);
            ended = itemView.findViewById(R.id.tv_route_my_ended);
            communicate = itemView.findViewById(R.id.tv_route_my_communicate);
            rcvApply = itemView.findViewById(R.id.rcv_route_my_apply);
        }
    }
}

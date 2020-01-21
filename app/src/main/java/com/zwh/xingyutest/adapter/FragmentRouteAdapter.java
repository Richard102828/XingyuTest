package com.zwh.xingyutest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zwh.xingyutest.ItemDecoration;
import com.zwh.xingyutest.R;


/**
 * @author Richard
 * @time 2020/1/20
 * @describe 行程页主界面 RecyclerView 的 Adapter
 */
public class FragmentRouteAdapter extends RecyclerView.Adapter {

    private Context mContext;

    //ViewType 标识
    private static final int TYPE_Apply = 0;
    private static final int TYPE_My = 1;
    private static final int TYPE_All = 2;

    public FragmentRouteAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_Apply) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_route_applylist,
                    parent, false);
            return new ApplyViewHolder(view);
        }else if (viewType == TYPE_My) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_route_my,
                    parent, false);
            return new MyViewHolder(view);
        }else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_route_all,
                    parent, false);
            return new AllViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ApplyViewHolder) {
            //do
            ApplyViewHolder applyViewHolder = (ApplyViewHolder) holder;
            FragmentRouteApplyAdapter applyAdapter = new FragmentRouteApplyAdapter(mContext);
            LinearLayoutManager manager = new LinearLayoutManager(mContext, RecyclerView.VERTICAL,
                    false);
            applyViewHolder.recyclerView.setAdapter(applyAdapter);
            applyViewHolder.recyclerView.setLayoutManager(manager);
        }else if (holder instanceof MyViewHolder) {
            //do
            MyViewHolder myViewHolder = (MyViewHolder) holder;
            FragmentRouteMyAdapter myAdapter = new FragmentRouteMyAdapter(mContext);
            LinearLayoutManager manager = new LinearLayoutManager(mContext, RecyclerView.VERTICAL,
                    false);
            myViewHolder.recyclerView.setAdapter(myAdapter);
            myViewHolder.recyclerView.setLayoutManager(manager);
            myViewHolder.recyclerView.addItemDecoration(new ItemDecoration(60));

        }else {
            //do
            AllViewHolder allViewHolder = (AllViewHolder) holder;
            FragmentRouteAllAdapter allAdapter = new FragmentRouteAllAdapter(mContext);
            LinearLayoutManager manager = new LinearLayoutManager(mContext, RecyclerView.VERTICAL,
                    false);
            allViewHolder.recyclerView.setAdapter(allAdapter);
            allViewHolder.recyclerView.setLayoutManager(manager);
            allViewHolder.recyclerView.addItemDecoration(new ItemDecoration(65));
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_Apply;
        }else if (position == 1) {
            return TYPE_My;
        }else {
            return TYPE_All;
        }
    }

    class ApplyViewHolder extends RecyclerView.ViewHolder {
        public RecyclerView recyclerView;
        public ApplyViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.rcv_route_apply_list);
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public RecyclerView recyclerView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.rcv_route_my);
        }
    }

    class AllViewHolder extends RecyclerView.ViewHolder {
        public RecyclerView recyclerView;
        public AllViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.rcv_route_all);
        }
    }
}

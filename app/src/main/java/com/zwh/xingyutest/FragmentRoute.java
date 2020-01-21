package com.zwh.xingyutest;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zwh.xingyutest.adapter.FragmentRouteAdapter;

/**
 * @author Richard
 * @time 2020/1/20
 * @describe 行程页主界面
 */
public class FragmentRoute extends Fragment {

    private RecyclerView recyclerView;
    private LinearLayoutManager manager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(R.layout.fragment_route, container,
                false);
        init(view);
        return view;
    }

    private void init(View view) {
        recyclerView = view.findViewById(R.id.rcv_route);
        FragmentRouteAdapter adapter = new FragmentRouteAdapter(getContext());
        manager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,
                false);
        recyclerView.setLayoutManager(manager);
        recyclerView.scrollToPosition(1);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new RouteItemDecoration(40));
//        initListener();
    }

    public void initListener() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {

                    //有问题，这样比较正确吗？

                    View view = recyclerView.getChildAt(0);
                    if (view == manager.findViewByPosition(0)) {
                        //设置指示器颜色
                    }else if (view == manager.findViewByPosition(1)) {
                        //
                    }else {
                        //
                    }
                }
            }
        });
    }
}

package com.zwh.xingyutest;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zwh.xingyutest.adapter.FragmentRouteAdapter;

/**
 * @author Richard
 * @time 2020/1/20
 * @describe 行程页主界面 颜色：FCC512
 */
                    /*

//                if (recyclerView.computeHorizontalScrollOffset() >= (recyclerView.getChildAt(0).getWidth() / 2)) {
//                    Log.d(TAG, String.valueOf(recyclerView.computeHorizontalScrollOffset()));
//                    Log.d(TAG, String.valueOf(recyclerView.getChildAt(0).getWidth() / 2));
//                    if (newState == RecyclerView.SCROLL_STATE_IDLE) {
//
//                        View temp = recyclerView.getChildAt(0);
//
//                        Log.d(TAG, "temp为：" + temp);
//
//                        Log.d(TAG, String.valueOf(mIsSmoothLeft));
//                        if (mIsSmoothLeft) {
//                            //设置左滑
//                            if (temp == apply) {
//                                manager.smoothScrollToPosition(recyclerView, new RecyclerView.State(), 0);
//                                applyColor.setSelected(true);
//                                myColor.setSelected(false);
//                                allColor.setSelected(false);
//                                Log.d(TAG, "左滑：temp为apply");
//                            } else if (temp == my) {
//                                manager.smoothScrollToPosition(recyclerView, new RecyclerView.State(), 1);
//                                applyColor.setSelected(false);
//                                myColor.setSelected(true);
//                                allColor.setSelected(false);
//                                Log.d(TAG, "左滑：temp为my");
//                            }else if (temp == all) {
//                                manager.smoothScrollToPosition(recyclerView, new RecyclerView.State(), 2);
//                                applyColor.setSelected(false);
//                                myColor.setSelected(false);
//                                allColor.setSelected(true);
//                                Log.d(TAG, "左滑：temp为all");
//                            }
//                        } else {
//                            //设置右滑
//                            if (temp == apply) {
//                                manager.smoothScrollToPosition(recyclerView, new RecyclerView.State(), 0);
//                                applyColor.setSelected(true);
//                                myColor.setSelected(false);
//                                allColor.setSelected(false);
//                                Log.d(TAG, "右滑：temp为apply");
//                            } else if (temp == my) {
//                                manager.smoothScrollToPosition(recyclerView, new RecyclerView.State(), 1);
//                                applyColor.setSelected(false);
//                                myColor.setSelected(true);
//                                allColor.setSelected(false);
//                                Log.d(TAG, "右滑：temp为my");
//                            }else if (temp == all) {
//                                manager.smoothScrollToPosition(recyclerView, new RecyclerView.State(), 2);
//                                applyColor.setSelected(false);
//                                myColor.setSelected(false);
//                                allColor.setSelected(true);
//                                Log.d(TAG, "右滑：temp为all");
//                            }
//                        }
//                    }
//
//                } else {
//                    if (newState == RecyclerView.SCROLL_STATE_IDLE) {
//
//                        View temp = recyclerView.getChildAt(0);
//
//                        Log.d(TAG, "temp为：" + temp);
//
//                        if (temp == apply) {
//                            manager.smoothScrollToPosition(recyclerView, new RecyclerView.State(), 0);
//                            applyColor.setSelected(true);
//                            myColor.setSelected(false);
//                            allColor.setSelected(false);
//                        }else if (temp == my) {
//                            manager.smoothScrollToPosition(recyclerView, new RecyclerView.State(), 1);
//                            applyColor.setSelected(false);
//                            myColor.setSelected(true);
//                            allColor.setSelected(false);
//                        }else {
//                            manager.smoothScrollToPosition(recyclerView, new RecyclerView.State(), 2);
//                            applyColor.setSelected(false);
//                            myColor.setSelected(false);
//                            allColor.setSelected(true);
//                        }
//                    }
//                }*/
public class FragmentRoute extends Fragment {

    private RecyclerView recyclerView;
    private CenterLayoutManager manager;
    private ImageView applyColor;
    private ImageView myColor;
    private ImageView allColor;
    private View apply;
    private View my;
    private View all;
    private View lastView;
    private static boolean mIsFirstSmooth;
    private static int temp;


    /**
     * 左滑为：手指向左滑滑动
     */
    private static boolean mIsSmoothLeft;

    private static final String TAG = "FragmentRoute";

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
        manager = new CenterLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,
                false);
        recyclerView.setLayoutManager(manager);
        recyclerView.scrollToPosition(1);
        recyclerView.setAdapter(adapter);
        setLastView(manager.findViewByPosition(1));
        temp = recyclerView.getWidth() / 2;
        Log.d(TAG, String.valueOf(temp));
        recyclerView.addItemDecoration(new RouteItemDecoration(40));
        setIndicator(view);
        initListener();
    }

    private void setIndicator(View view) {
        applyColor = view.findViewById(R.id.img_route_color_apply);
        myColor = view.findViewById(R.id.img_route_color_my);
        allColor = view.findViewById(R.id.img_route_color_all);
        myColor.setSelected(true);
    }

    private void initListener() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                apply = manager.findViewByPosition(0);
                my = manager.findViewByPosition(1);
                all = manager.findViewByPosition(2);

                //getChildAt(0)：第一个可见的Item
                //判断滑动距离
                //滑动完毕（状态）进行其他逻辑
                //滑动方向
                    //左滑：逻辑
                    //右滑：逻辑

                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    int smoothDistance = getSmoothDistance();
                    int width = recyclerView.getChildAt(0).getWidth();
                    int threshold = (int) (width / 2.2);
                    if (smoothDistance >= threshold) {
                        //滑到目的地
                        if (mIsSmoothLeft) {
                            //apply没有消失
                            //从apply开始，滑动到my
                            if (apply != null && my != null && all == null) {
                                manager.smoothScrollToPosition(recyclerView,
                                        new RecyclerView.State(), 1);
                                setIndicatorColor(1);
                            } else if (apply == null && my != null) {
                                //apply消失
                                //从apply开始，滑动到看不见apply
                                if (smoothDistance >= width + threshold) {
                                    manager.smoothScrollToPosition(recyclerView,
                                            new RecyclerView.State(), 2);
                                    setIndicatorColor(2);
                                } else if (smoothDistance >= width && smoothDistance < width +
                                        threshold){
                                    manager.smoothScrollToPosition(recyclerView,
                                            new RecyclerView.State(), 1);
                                    setIndicatorColor(1);
                                } else if (smoothDistance >= threshold) {
                                    //从my开始，滑动到all
                                    manager.smoothScrollToPosition(recyclerView,
                                            new RecyclerView.State(), 2);
                                    setIndicatorColor(2);
                                }
                            } else if (apply == null && my == null && all != null) {
                                manager.smoothScrollToPosition(recyclerView,
                                        new RecyclerView.State(), 2);
                                setIndicatorColor(2);
                            }
                        } else {
                            //all到my
                            if (apply == null && my != null && all != null) {
                                manager.smoothScrollToPosition(recyclerView,
                                        new RecyclerView.State(), 1);
                                setIndicatorColor(1);
                            } else if (my != null && all == null) {
                                //all消失
                                //从all开始，滑动到看不见all
                                if (smoothDistance >= width + threshold) {
                                    manager.smoothScrollToPosition(recyclerView,
                                            new RecyclerView.State(), 0);
                                    setIndicatorColor(0);
                                } else if (smoothDistance >= width && smoothDistance < width +
                                        threshold) {
                                    manager.smoothScrollToPosition(recyclerView,
                                            new RecyclerView.State(), 1);
                                    setIndicatorColor(1);
                                } else if (smoothDistance >= threshold) {
                                    //从my开始，滑动到apply
                                    manager.smoothScrollToPosition(recyclerView,
                                            new RecyclerView.State(), 0);
                                    setIndicatorColor(0);
                                }
                            } else if (apply != null && my == null && all == null) {
                                manager.smoothScrollToPosition(recyclerView,
                                        new RecyclerView.State(), 0);
                                setIndicatorColor(0);
                            }
                        }
                    } else {
                        //回弹
                         if (mIsSmoothLeft) {
                             if (apply != null && my != null && all == null) {
                                 manager.smoothScrollToPosition(recyclerView,
                                         new RecyclerView.State(), 0);
                                 setIndicatorColor(0);
                             } else if (my != null && all != null && apply == null) {
                                 manager.smoothScrollToPosition(recyclerView,
                                         new RecyclerView.State(), 1);
                                 setIndicatorColor(1);
                             } else if (all != null && my == null && apply == null) {
                                 manager.smoothScrollToPosition(recyclerView,
                                         new RecyclerView.State(), 2);
                                 setIndicatorColor(2);
                             }
                         } else {
                             if (all != null && my != null && apply == null) {
                                 manager.smoothScrollToPosition(recyclerView,
                                         new RecyclerView.State(), 2);
                                 setIndicatorColor(2);
                             } else if (my != null && apply != null && all == null) {
                                 manager.smoothScrollToPosition(recyclerView,
                                         new RecyclerView.State(), 1);
                                setIndicatorColor(1);
                             } else if (apply != null && my == null && all == null) {
                                 manager.smoothScrollToPosition(recyclerView,
                                         new RecyclerView.State(), 0);
                                 setIndicatorColor(0);
                             }
                         }
                    }
                }



            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                if (dx > 0) {
                    mIsSmoothLeft = true;
                }else {
                    mIsSmoothLeft = false;
                }
            }

        });
    }

    public void setLastView(View v) {
        lastView = v;
    }

    /**
     * 计算 RecyclerView 的滑动距离
     * @return RecyclerView 的滑动距离
     */
    private int getSmoothDistance() {
        int now = recyclerView.computeHorizontalScrollOffset();
        if (mIsFirstSmooth) {
            int ret = Math.abs(now - temp);
            temp = now;
            mIsFirstSmooth = false;
            return ret;
        } else {
            int ret = Math.abs(now - temp);
            temp = now;
            return ret;
        }
    }

    /**
     * 设置指示器的颜色
     * @param position 指示器位置
     */
    private void setIndicatorColor(int position) {
        if (position == 0) {
            applyColor.setSelected(true);
            myColor.setSelected(false);
            allColor.setSelected(false);
        } else if (position == 1) {
            applyColor.setSelected(false);
            myColor.setSelected(true);
            allColor.setSelected(false);
        } else if (position == 2) {
            applyColor.setSelected(false);
            myColor.setSelected(false);
            allColor.setSelected(true);
        }
    }

}

package com.zwh.xingyutest.net;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Richard
 * @time 2020/1/16
 * @describe 构建 Retrofit 实例
 */
public class ApiRetrofit {

    private ApiRetrofit instance = null;

    private ApiRetrofit() {
    }

    /**
     * 创建网络连接所需的接口实例
     *
     * @param baseUrl 基本 Url
     * @param tClass 接口 Class 对象
     * @param <T> 类型参数
     * @return T 接口实例
     */
    public static <T> T create(String baseUrl, Class<T> tClass) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(HttpForRetrofit.getOkHttpClient())
                .build();
        return retrofit.create(tClass);
    }

    /**
     * 获取 ApiRetrofit 的单例
     * 一般用不到
     * @return ApiRetrofit 实例
     */
    public ApiRetrofit getInstance() {
        if (instance == null) {
            synchronized (ApiRetrofit.class) {
                if (instance == null) {
                    instance = new ApiRetrofit();
                }
            }
        }
        return instance;
    }

}

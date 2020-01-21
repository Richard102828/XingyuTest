package com.zwh.xingyutest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import com.zwh.xingyutest.net.ApiRetrofit;
import com.zwh.xingyutest.net.IYouDao;
import com.zwh.xingyutest.net.YouDao;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Richard
 * @time 2020/01/14
 * @describe 行遇App 各种功能的测试代码
 *          网络请求测试代码
 *          下面的例子最终得到的结果出现了错误，回调了onError()方法，原因好像是 服务器Json格式不一致的问题
 *          应该是到描述性接口中去找解决办法，注解？
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 测试网络封装的
     */
    private void testNet() {
        Log.d("MainActivity", "开始请求数据");
        ApiRetrofit.create("https://fanyi.youdao.com/", IYouDao.class)
                .getObservable("translate?doctype=json&jsonversion=&type" +
                                "=&keyfrom=&model=&mid=&imei=&vendor=&screen=&ssid=&network=&abtest=",
                        "i am richard")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                /*.subscribe(new Observer<YouDao>() {
                    @Override
                    public void onSuccess(YouDao youDao) {
                        Log.d("MainActivity", "开始打印数据");
                        String s = youDao.getTranslateResult().get(0).get(0).getTgt();
                        Log.d("MainActivity", s);
                    }
                });*/
                .subscribe(new Observer<YouDao>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                        Log.d("MainActivity", "开始打印数据");
                    }

                    @Override
                    public void onNext(YouDao youDao) {

                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.d("MainActivity", String.valueOf(e));
                    }

                    @Override
                    public void onComplete() {

                        Log.d("MainActivity", "开始打印数据");
                    }
                });
    }
}

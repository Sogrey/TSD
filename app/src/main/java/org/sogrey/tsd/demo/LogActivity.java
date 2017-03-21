package org.sogrey.tsd.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.sogrey.tsd.log.L;

/**
 * 演示Log
 * Created by Sogrey on 2017/3/21.
 */

public class LogActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        L.init(BuildConfig.DEBUG);
        L.v("测试日志");
        L.d("测试日志");
        L.i("测试日志");
        L.w("测试日志");
        L.e("测试日志");
        L.wtf("测试日志");
        String json = "{\"token\":\"XXXXXXXXXXXtokanXXXXXXXXX\",\"result\":\"1\",\"msg\":\"nulls\"}";
        L.json(json);

        L.v("My name is %s", "Sogrey");
    }
}

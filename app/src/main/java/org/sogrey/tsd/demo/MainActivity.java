package org.sogrey.tsd.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.sogrey.tsd.log.L;
import org.sogrey.tsd.toast.StyleableToast;
import org.sogrey.tsd.toast.T;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        L.init(BuildConfig.DEBUG);
        L.v("测试日志");
        L.d("测试日志");
        L.i("测试日志");
        L.w("测试日志");
        L.e("测试日志");
        L.wtf("测试日志");
        String json = "{\"token\":\"XXXXXXXXXXXtokanXXXXXXXXX\",\"result\":\"1\",\"msg\":\"nulls\"}";
        L.json(json);

        L.v("My name is %s","Sogrey");

//        StyleableToast.makeText()

    }
}

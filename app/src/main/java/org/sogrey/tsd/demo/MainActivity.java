package org.sogrey.tsd.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.sogrey.tsd.log.L;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        L.init(BuildConfig.DEBUG);
        L.d("测试日志");

        String json = "{\"token\":\"XXXXXXXXXXXtokanXXXXXXXXX\",\"result\":\"1\",\"msg\":\"nulls\"}";
        L.json(json);
    }
}

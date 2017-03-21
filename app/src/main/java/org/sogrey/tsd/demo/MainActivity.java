package org.sogrey.tsd.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toLogActivity(View v){
        startActivity(new Intent(this,LogActivity.class));
    }
    public void toToastActivity(View v){
        startActivity(new Intent(this,ToastActivity.class));
    }
    public void toSnackBarActivity(View v){
        startActivity(new Intent(this,SnackBarActivity.class));
    }
    public void toDialogActivity(View v){
        startActivity(new Intent(this,DialogActivity.class));
    }
}

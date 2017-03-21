package org.sogrey.tsd.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.sogrey.tsd.dialog.MaterialDialog;

public class DialogActivity extends AppCompatActivity {
    MaterialDialog mMaterialDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }

    public void MaterialDialog(View v){
         mMaterialDialog = new MaterialDialog(this)
                .setTitle("MaterialDialog")
                .setMessage("Hello world!")
                .setPositiveButton("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mMaterialDialog.dismiss();
                    }
                })
                .setNegativeButton("CANCEL", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mMaterialDialog.dismiss();
                    }
                });

        mMaterialDialog.show();

// You can change the message anytime. before show
        mMaterialDialog.setTitle("提示");
        mMaterialDialog.show();
// You can change the message anytime. after show
        mMaterialDialog.setMessage("你好，世界~");
    }
}

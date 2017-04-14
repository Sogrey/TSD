package org.sogrey.tsd.demo;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import org.sogrey.tsd.dialog.ActionSheetDialog;
import org.sogrey.tsd.dialog.LoadingDialog;
import org.sogrey.tsd.dialog.MaterialDialog;
import org.sogrey.tsd.dialog.listener.OnOperItemClickListener;
import org.sogrey.tsd.pop.BubblePopup;
import org.sogrey.tsd.toast.Tt;

public class DialogActivity extends AppCompatActivity {
    MaterialDialog mMaterialDialog;
    LoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }

    public void MaterialDialog(View v) {
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

    public void LoadingDialog(View v) {
        loadingDialog = new LoadingDialog();
        loadingDialog.handlerStart(this, "", "正在加载数据...");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadingDialog.handlerUpdate("", "正在加载模型结构文件...");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadingDialog.handlerStop("");
                    }
                }, 2000);
            }
        }, 2000);
    }

    public void ActionSheetDialog(View v){
        String[] item = {"选项一","选项二","选项三"};
        new ActionSheetDialog(this,item,null)
                .cancelText("取消")
                .cornerRadius(5)
                .dividerColor(Color.CYAN)
                .isTitleShow(true)
                .title("提示")
                .setOnOperItemClickL(new OnOperItemClickListener() {
                    @Override
                    public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                        new Tt.Builder(DialogActivity.this,position+"")
                                .withTextColor(Color.BLACK)
                                .withIcon(R.mipmap.ic_launcher)
                                .show();
                    }
                })
                .show();

    }
}

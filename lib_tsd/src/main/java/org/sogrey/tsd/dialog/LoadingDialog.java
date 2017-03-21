/**
 * 
 */
package org.sogrey.tsd.dialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.sogrey.tsd.R;

import java.util.HashMap;
import java.util.Map;



/**
 * @author Sogrey
 *
 */
public class LoadingDialog {
        /**
         * 得到自定义的progressDialog
         * @param context
         * @param msg
         * @return
         */
        public static Dialog createLoadingDialog(Context context, String msg) {

                LayoutInflater inflater = LayoutInflater.from(context);
                View v = inflater.inflate(R.layout.loading_dialog, null);// 得到加载view
                LinearLayout layout = (LinearLayout) v.findViewById(R.id.dialog_view);// 加载布局
                // main.xml中的ImageView
                ImageView spaceshipImage = (ImageView) v.findViewById(R.id.img);
                TextView tipTextView = (TextView) v.findViewById(R.id.tipTextView);// 提示文字
                // 加载动画
                Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(
                        context, R.anim.loading_animation);
                // 使用ImageView显示动画
                spaceshipImage.startAnimation(hyperspaceJumpAnimation);
                tipTextView.setText(msg);// 设置加载信息

                Dialog loadingDialog = new Dialog(context, R.style.loading_dialog);// 创建自定义样式dialog

                loadingDialog.setCancelable(false);// 不可以用“返回键”取消
                loadingDialog.setContentView(layout, new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT));// 设置布局
                return loadingDialog;

        }



    //进度条等待框
    public static final int LOADING_START = 0x1;
    public static final int LOADING_STOP = 0x2;
    public static final int LOADING_UPDATE = 0x3;

    private Dialog mLoadingDialog;
    private Handler _handler = new Handler() {
        @SuppressWarnings("unchecked")
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case LOADING_START: {
                    Map<String, Object> obj = (Map<String, Object>) msg.obj;
                    Context conetxt = (Context) obj.get("context");
                    String tag = (String) obj.get("tag");
                    String msg0 = (String) obj.get("msg");
                    showLoadingDialog(conetxt, tag,msg0);
                }
                break;
                case LOADING_UPDATE:{
                    Map<String, Object> obj = (Map<String, Object>) msg.obj;
                    String tag = (String) obj.get("tag");
                    String msg0 = (String) obj.get("msg");
                    updateLoadingDialog(tag,msg0);
                }
                break;
                case LOADING_STOP: {
                    Map<String, Object> obj = (Map<String, Object>) msg.obj;
                    String tag = (String) obj.get("tag");
                    dismissLoadingDialog(tag);
                }
                break;

                default:
                    break;
            }
        }
    };

    public Handler getLoadingHandler(){
        return _handler;
    }

    public void handlerStart(Context context, String tag,String msg0) {
        Message msg = new Message();
        msg.what = LOADING_START;
        Map<String, Object> map = new HashMap<>();
        map.put("context", context);
        map.put("tag", tag);
        map.put("msg", msg0);
        msg.obj = map;
        _handler.sendMessage(msg);
    }

    public void handlerStop(String tag) {
        Message msg = new Message();
        msg.what = LOADING_STOP;
        Map<String, Object> map = new HashMap<>();
        map.put("tag", tag);
        msg.obj = map;
        _handler.sendMessage(msg);
    }
    public void handlerUpdate(String tag,String msg0) {
        Message msg = new Message();
        msg.what = LOADING_UPDATE;
        Map<String, Object> map = new HashMap<>();
        map.put("tag", tag);
        map.put("msg", msg0);
        msg.obj = map;
        _handler.sendMessage(msg);
    }

    private void showLoadingDialog(Context context, String tag,String msg) {
        if (mLoadingDialog == null)
            mLoadingDialog = LoadingDialog.createLoadingDialog(context,
                    msg);
        if (!mLoadingDialog.isShowing()) {
            mLoadingDialog.show();
        }
    }

    private void dismissLoadingDialog(final String tag) {
        if (mLoadingDialog != null
                && mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
            mLoadingDialog = null;
        }
    }
    private void updateLoadingDialog(final String tag,String msg0) {
        if (mLoadingDialog != null
                && mLoadingDialog.isShowing()) {
            TextView tipTextView = (TextView) mLoadingDialog.findViewById(R.id.tipTextView);// 提示文字
            tipTextView.setText(msg0);
        }
    }
}
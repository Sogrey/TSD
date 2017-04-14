package org.sogrey.tsd;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
//import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Sogrey on 2017/3/22.
 * <br>
 * how to use: <br>
 * <pre>
 *
 * &lt;?xml version="1.0" encoding="utf-8"?&gt;
 * &lt;RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
 * xmlns:tools="http://schemas.android.com/tools"
 * android:layout_width="match_parent"
 * android:layout_height="match_parent"
 * android:background="@color/white"
 * tools:context="top.greendami.greendami.MainActivity"&gt;
 * &lt;org.sogrey.tsd.LoadingBar
 * android:layout_centerInParent="true"
 * android:layout_width="400dp"
 * android:layout_height="80dp" /&gt;
 * &lt;/RelativeLayout&gt;
 *
 *         </pre>
 * <br>
 *
 *   @see <a href="http://mp.weixin.qq.com/s?__biz=MzI0NDYzMzg0OQ==&mid=2247484095&idx=1&sn=6b067abe805ef665a072480b74aedb04&chksm=e95b9b29de2c123fa33ea267b33a303322fbc645dbbe2014af3e4cc75c33128f9a457583ff76&mpshare=1&scene=23&srcid=03228zmCyFG3jQRoISkAdlQI#rd">Android鬼点子-又来了一个LoadingBar</a>
 */

public class LoadingBar extends View {

    String TAG = "PPView";
    //动画开关
    boolean isLoading = true;
    Context mContext;
    private int mWidth = 100;
    private int mheight = 100;
    public int mColor;
    public Paint mPaint = new Paint();
    float time = 0;
    //小球与中间打球的最远距离
    float distance = 100;

    public LoadingBar(Context context) {
        super(context);
        mContext = context;
    }

    public LoadingBar(Context context, /*@Nullable*/ AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mColor = context.getResources().getColor(R.color.colorAccent);
        init();
    }

    private void init() {
        mPaint.setAntiAlias(true);
        mPaint.setColor(mColor);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        //宽度至少是高度的4倍
        if (widthSpecSize < 4 * heightSpecSize) {
            widthSpecSize = 4 * heightSpecSize;
        }

        mWidth = widthSpecSize;
        mheight = heightSpecSize;

        distance = 1.2f * mheight;
        setMeasuredDimension(widthSpecSize, heightSpecSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isLoading) {
            //大圆半径
            float bigR = mheight * 0.32f + mheight * 0.03f * Math.abs((float) Math.sin(Math.toRadians(time)));
            float smallR = mheight * 0.22f + mheight * 0.03f * Math.abs((float) Math.cos(Math.toRadians(time)));
            float bigx = (getWidth()) / 2;
            //画中间大圆
            canvas.drawCircle(bigx, mheight / 2, bigR, mPaint);
            float smalx = getSmallCenterX();
            //画小圆
            canvas.drawCircle(smalx, mheight / 2, smallR, mPaint);
            //画链接
            //小球在右侧
            if (smalx > bigx) {

                Path path = new Path();
                //上面的贝塞尔曲线的第一个点，在大圆身上
                float x1 = bigx + bigR * (float) Math.cos(Math.toRadians(time));
                float y1 = mheight / 2 - bigR * (float) Math.sin(Math.toRadians(time));
                if (y1 > mheight / 2 - smallR) {
                    y1 = mheight / 2 - smallR;
                    x1 = bigx + (float) (Math.sqrt(bigR * bigR - smallR * smallR));
                }
                //上面的贝塞尔曲线的第三个点，在小圆身上
                float x2 = smalx - smallR * (float) Math.cos(Math.toRadians(time));
                float y2 = mheight / 2 - smallR * (float) Math.sin(Math.toRadians(time));
                if (y2 > mheight / 2 - smallR * 0.8) {
                    y2 = mheight / 2 - smallR * 0.8f;
                    x2 = smalx - smallR * (float) (Math.sqrt(1 - 0.64f));
                }
                //下面的贝塞尔曲线的第三个点，在小圆身上
                float x3 = smalx - smallR * (float) Math.cos(Math.toRadians(time));
                float y3 = mheight / 2 + smallR * (float) Math.sin(Math.toRadians(time));
                if (y3 < mheight / 2 + smallR * 0.8) {
                    y3 = mheight / 2 + smallR * 0.8f;
                    x3 = smalx - smallR * (float) (Math.sqrt(1 - 0.64f));
                }
                //下面的贝塞尔曲线的第一个点，在大圆身上
                float x4 = bigx + bigR * (float) Math.cos(Math.toRadians(time));
                float y4 = mheight / 2 + bigR * (float) Math.sin(Math.toRadians(time));
                if (y4 < mheight / 2 + smallR) {
                    y4 = mheight / 2 + smallR;
                    x4 = bigx + (float) (Math.sqrt(bigR * bigR - smallR * smallR));
                }

                path.moveTo(x1, y1);

                path.quadTo((bigx + smalx) / 2, mheight / 2, x2, y2);                           // 绘制贝赛尔曲线（Path）

                path.lineTo(x3, y3);

                path.quadTo((bigx + smalx) / 2, mheight / 2, x4, y4);
                canvas.drawPath(path, mPaint);
            }
            //小球在左侧
            if (smalx < bigx) {
                Path path = new Path();
                float x1 = bigx + bigR * (float) Math.cos(Math.toRadians(time));
                float y1 = mheight / 2 - bigR * (float) Math.sin(Math.toRadians(time));
                if (y1 > mheight / 2 - smallR) {
                    y1 = mheight / 2 - smallR;
                    x1 = bigx - (float) (Math.sqrt(bigR * bigR - smallR * smallR));
                }
                float x2 = smalx - smallR * (float) Math.cos(Math.toRadians(time));
                float y2 = mheight / 2 - smallR * (float) Math.sin(Math.toRadians(time));
                if (y2 > mheight / 2 - smallR * 0.8) {
                    y2 = mheight / 2 - smallR * 0.8f;
                    x2 = smalx + smallR * (float) (Math.sqrt(1 - 0.64f));
                }
                float x3 = smalx - smallR * (float) Math.cos(Math.toRadians(time));
                float y3 = mheight / 2 + smallR * (float) Math.sin(Math.toRadians(time));
                if (y3 < mheight / 2 + smallR * 0.8) {
                    y3 = mheight / 2 + smallR * 0.8f;
                    x3 = smalx + smallR * (float) (Math.sqrt(1 - 0.64f));
                }
                float x4 = bigx + bigR * (float) Math.cos(Math.toRadians(time));
                float y4 = mheight / 2 + bigR * (float) Math.sin(Math.toRadians(time));
                if (y4 < mheight / 2 + smallR) {
                    y4 = mheight / 2 + smallR;
                    x4 = bigx - (float) (Math.sqrt(bigR * bigR - smallR * smallR));
                }

                path.moveTo(x1, y1);

                path.quadTo((bigx + smalx) / 2, mheight / 2, x2, y2);
                // 绘制贝赛尔曲线（Path）

                path.lineTo(x3, y3);

                path.quadTo((bigx + smalx) / 2, mheight / 2, x4, y4);
                canvas.drawPath(path, mPaint);
            }

            postInvalidate();
        }
    }

    //计算小球的X坐标
    private float getSmallCenterX() {
        //此处控制速度
        time = time + 2.5f;
        return mWidth / 2 + distance * (float) Math.cos(Math.toRadians(time));
    }
}
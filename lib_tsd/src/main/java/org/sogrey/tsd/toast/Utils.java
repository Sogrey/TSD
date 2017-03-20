package org.sogrey.tsd.toast;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.TypedValue;

/**
 * Created by Muddz on 26-01-2017.
 */

public class Utils {

    /**
     * 单位转换 --&gt; dp
     *
     * @param context 上下文
     * @param value 要转换单位的值
     * @return 返回dp单位的值
     */
    public static float getTypedValueInDP(Context context, float value) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, context.getResources().getDisplayMetrics());
    }
    /**
     * 字体大小单位转换 --&gt; sp
     *
     * @param context 上下文
     * @param value 要转换单位的值
     * @return 返回sp单位的值
     */
    public static float getTypedValueInSP(Context context, float value) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, value, context.getResources().getDisplayMetrics());
    }

    /**
     * 从自定义样式中获取颜色值
     * @param context 上下文
     * @param attrId 自定义样式ID
     * @param style 颜色样式ID
     * @return
     */
    public static TypedArray getStyleValuesColor(Context context, /*@AttrRes*/ int attrId, int style) {
        TypedArray a = null;
        int result;

        if (style > 0) {
            int[] AttrSet = {attrId};
            a = context.obtainStyledAttributes(style, AttrSet);
            result = a.getColor(0, Color.LTGRAY);

        }
        return a;

    }
    /**
     * 从自定义样式中获取int值
     * @param context 上下文
     * @param attrId 自定义样式ID
     * @param style 样式ID
     * @return
     */
    public static int getStyleValuesInt(Context context, /*@AttrRes*/ int attrId, int style) {
        TypedArray a = null;

        if (style > 0) {
            int[] AttrSet = {attrId};
            a = context.obtainStyledAttributes(style, AttrSet);
            a.recycle();
        }
        return a.getInt(0, 0);
    }
    /**
     * 从自定义样式中获取String值
     * @param context 上下文
     * @param attrId 自定义样式ID
     * @param style 样式ID
     * @return
     */
    public static String getStyleValuesString(Context context, /*@AttrRes*/ int attrId, int style) {
        TypedArray a = null;

        if (style > 0) {
            int[] AttrSet = {attrId};
            a = context.obtainStyledAttributes(style, AttrSet);
            a.recycle();
        }
        return a.getString(0);
    }
    /**
     * 从自定义样式中获取布尔值
     * @param context 上下文
     * @param attrId 自定义样式ID AttrRes
     * @param style 样式ID
     * @return
     */
    public static boolean getStyleValuesBoolean(Context context, /*@AttrRes*/ int attrId, int style) {
        TypedArray a = null;

        if (style > 0) {
            int[] AttrSet = {attrId};
            a = context.obtainStyledAttributes(style, AttrSet);
            a.recycle();
        }
        return a.getBoolean(0, false);
    }

}

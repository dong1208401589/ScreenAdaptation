package com.chenwd.screenadaptaion;

import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2017/12/30.
 * 屏幕适配工具类
 */

public class ViewCalculateUtil {
    /**
     * 设置view LayoutParam  当前只用于LinearLayout
     * @param view
     * @param w 宽
     * @param h 高
     * @param topMargin 上边距
     * @param rightMargin 右边距
     * @param bottomMargin 下边距
     * @param leftMargin 左边距
     */
    public static void setViewLinearLayoutParam(View view,int w,int h,int topMargin,int rightMargin,int bottomMargin,int leftMargin){
        LinearLayout.LayoutParams layoutParams= (LinearLayout.LayoutParams) view.getLayoutParams();
        if (w!= LinearLayout.LayoutParams.MATCH_PARENT&&w!= LinearLayout.LayoutParams.WRAP_CONTENT){
            layoutParams.width=UIUtils.getOurInstance(ScreenAdaptationApplication.getInstance()).getWidth(w);
        }else {
            layoutParams.width=w;
        }

        if (h!= LinearLayout.LayoutParams.MATCH_PARENT&&w!= LinearLayout.LayoutParams.WRAP_CONTENT){
            layoutParams.height=UIUtils.getOurInstance(ScreenAdaptationApplication.getInstance()).getHeight(h);
        }else {
            layoutParams.height=h;
        }

        layoutParams.topMargin=UIUtils.getOurInstance(ScreenAdaptationApplication.getInstance()).getHeight(topMargin);
        layoutParams.bottomMargin=UIUtils.getOurInstance(ScreenAdaptationApplication.getInstance()).getHeight(bottomMargin);

        layoutParams.leftMargin=UIUtils.getOurInstance(ScreenAdaptationApplication.getInstance()).getWidth(leftMargin);
        layoutParams.rightMargin=UIUtils.getOurInstance(ScreenAdaptationApplication.getInstance()).getWidth(rightMargin);

        view.setLayoutParams(layoutParams);

    }
}

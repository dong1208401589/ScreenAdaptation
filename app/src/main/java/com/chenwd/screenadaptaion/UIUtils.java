package com.chenwd.screenadaptaion;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2017/12/29.
 * 用来按照美工的基准值生成真实设备上需要的宽高值
 */

public class UIUtils {

    private static UIUtils ourInstance;

    public static UIUtils getOurInstance(Context context){
        if (ourInstance==null){
            synchronized (UIUtils.class){
                if (ourInstance==null){
                    ourInstance=new UIUtils(context);
                }
            }
        }
        return ourInstance;
    }

    public static final int STANDARD_WIDTH=1080;
    public static final int STANDARD_HEIGHT=1872;//1920-48   减去状态栏的高度  一般xxxhdpi上的屏幕都是48个像素
    private static final String DIMEN_CLASS="com.android.internal.R$dimen";//系统存放相关常量的类，主要用于拿到状态栏高度。
    //实际设备的分辨率
    public float displanMetricsWidth;
    public float displanMetricsHeight;

    private UIUtils(Context context){
        WindowManager windowManager= (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics=new DisplayMetrics();
        if (displanMetricsWidth==0.0f||displanMetricsHeight==0.0f){
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int systemBarHeight=getSystemBarHeight(context);  //部分手机可能还有一个虚拟按键的高度没有计算。
            if (displayMetrics.widthPixels>displayMetrics.heightPixels) {//横屏
                this.displanMetricsWidth=displayMetrics.heightPixels;
                this.displanMetricsHeight=displayMetrics.widthPixels-systemBarHeight;
            }else { //竖屏
                this.displanMetricsWidth=displayMetrics.widthPixels;
                this.displanMetricsHeight=displayMetrics.heightPixels-systemBarHeight;
            }
        }
    }

    private int getSystemBarHeight(Context context) {
        return getValue(context,DIMEN_CLASS,"system_bar_height",48);
    }

    /**
     *
     * @param attrGroupClass 安桌系统存放围度的类
     * @param attrName  状态栏的信息
     * @param defValue 默认值
     * @return
     */
    private int getValue(Context context,String attrGroupClass, String attrName, int defValue) {
        try {
            Class a = Class.forName(attrGroupClass);
            Object obj=a.newInstance();
            Field field=a.getField(attrName);
            //这里获取到的是ID
            int x = Integer.parseInt(field.get(obj).toString());
            return context.getResources().getDimensionPixelOffset(x);
        } catch (Exception e) {
            e.printStackTrace();
            return defValue;
        }
    }

    //开始获取缩放以后的结果
    public float getWidth(float width){
        return width*this.displanMetricsWidth/STANDARD_WIDTH;
    }
    public float getHeight(float height){
        return height*this.displanMetricsHeight/STANDARD_HEIGHT;
    }

    public int getWidth(int width){
        return (int) (width*this.displanMetricsWidth/STANDARD_WIDTH);
    }
    public int getHeight(int height){
        return (int) (height*this.displanMetricsHeight/STANDARD_HEIGHT);
    }


}

package com.chenwd.screenadaptaion;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2017/12/30.
 */

public class WDLinearLayout extends LinearLayout {
    public WDLinearLayout(Context context) {
        super(context);
    }

    public WDLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public WDLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public WDLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int childCount=getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view=getChildAt(i);
            LinearLayout.LayoutParams layoutParams= (LayoutParams) view.getLayoutParams();
            ViewCalculateUtil.setViewLinearLayoutParam(view,
                    layoutParams.width,
                    layoutParams.height,
                    layoutParams.topMargin,
                    layoutParams.rightMargin,
                    layoutParams.bottomMargin,
                    layoutParams.leftMargin);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}

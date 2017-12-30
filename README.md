# ScreenAdaptation
屏幕适配解决方案

​	不论什么样的屏幕都可以适配

只需要输入ui给出的px值即可，

```
<TextView
    android:layout_width="1080px"
    android:layout_height="200px"
    android:text="Hello World!"
    android:background="@color/colorAccent"
    />
```

使用（具体使用请看代码）

           LinearLayout.LayoutParams layoutParams= (LayoutParams) view.getLayoutParams();
           ViewCalculateUtil.setViewLinearLayoutParam(view,
                    layoutParams.width,
                    layoutParams.height,
                    layoutParams.topMargin,
                    layoutParams.rightMargin,
                    layoutParams.bottomMargin,
                    layoutParams.leftMargin);
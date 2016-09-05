package com.demo.zyd.wechatpic;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

/**
 * Created by Administrator on 2016/9/5 0005.
 */
public class GridViewEx extends GridView {

    public GridViewEx(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GridViewEx(Context context) {
        super(context);
    }

    public GridViewEx(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, View.MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}

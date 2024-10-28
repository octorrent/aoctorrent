package com.octorrent.android.ui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.WindowInsets;
import android.widget.LinearLayout;

import com.octorrent.android.R;

public class InsetLinearLayout extends LinearLayout {

    private int inset = 0;

    public InsetLinearLayout(Context context){
        super(context);
    }

    public InsetLinearLayout(Context context, AttributeSet attrs){
        super(context, attrs);
        init(context, attrs);
    }

    public InsetLinearLayout(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @Override
    public WindowInsets onApplyWindowInsets(WindowInsets insets){
        return super.onApplyWindowInsets(insets);
    }

    private void init(Context context, AttributeSet attrs){
        TypedArray t = context.getTheme().obtainStyledAttributes(attrs, R.styleable.InsetLayout, 0, 0);
        inset = t.getBoolean(R.styleable.InsetLayout_insetStatusBar, false) ? getStatusBarHeight() : 0;
        inset += t.getDimensionPixelSize(R.styleable.InsetLayout_android_insetTop, 0);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec)-inset;

        super.onMeasure(MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY),
                MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY));
    }

    private int getStatusBarHeight(){
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if(resourceId > 0){
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}

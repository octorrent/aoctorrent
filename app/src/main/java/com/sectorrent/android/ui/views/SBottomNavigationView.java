package com.sectorrent.android.ui.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.TooltipCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SBottomNavigationView extends BottomNavigationView {

    public SBottomNavigationView(@NonNull Context context){
        super(context);
    }

    public SBottomNavigationView(@NonNull Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
    }

    public SBottomNavigationView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow(){
        super.onAttachedToWindow();
        setItemIconTintList(null);

        for(int i = 0; i < getMenu().size(); i++){
            TooltipCompat.setTooltipText(findViewById(getMenu().getItem(i).getItemId()), null);
        }
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        for(int i = 0; i < getMenu().size(); i++){
            TooltipCompat.setTooltipText(findViewById(getMenu().getItem(i).getItemId()), null);
        }
    }
}

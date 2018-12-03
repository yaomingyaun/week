package com.bw.ymy.yaomingyuan1203;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

@SuppressLint("AppCompatCustomView")
public class CustorText extends TextView {
    private  Context mContext;
    public CustorText(Context context) {
        super(context);
        mContext=context;
    }

    public CustorText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
        TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.TextView);
        int color=typedArray.getColor(R.styleable.TextView_title_color,Color.RED);
        typedArray.recycle();
        setTextColor(color);
    }
}

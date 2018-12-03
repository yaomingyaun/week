package com.bw.ymy.yaomingyuan1203;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class Custor extends LinearLayout {
    //属性
    String str;

    //孩子最高的
    private  int mChildMaxHeight;

        //左边距
    private  int mHscape=20;
    //上下间距
    private  int mVspace=20;


    public Custor(Context context) {
        super(context);
    }

    public Custor(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);


    }

    //测量
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int sizeWidth=MeasureSpec.getSize(widthMeasureSpec);

        int sizeHeight=MeasureSpec.getSize(heightMeasureSpec);

        measureChildren(widthMeasureSpec,heightMeasureSpec);

        //
        findMaxChilder();

        int left=0,top=0;

        int chilecount=getChildCount();
        for (int i=0;i<chilecount;i++)
        {
            View view=getChildAt(i);
            if(left!=0)
            {
                if((left+view.getMeasuredWidth()>sizeWidth))
                {
                    top+=mChildMaxHeight+mVspace;
                    left=0;
                }
            }
            left+=view.getMeasuredWidth()+mHscape;
        }
        setMeasuredDimension(sizeWidth,(top+mChildMaxHeight)<sizeHeight?sizeHeight:top+mChildMaxHeight);
    }

    //布局
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        findMaxChilder();
        int left=0,top=0;

        int chilecount=getChildCount();
        for (int i=0;i<chilecount;i++)
        {
            View view=getChildAt(i);
            if(left!=0)
            {
                if((left+view.getMeasuredWidth()>getWidth()))
                {
                    top+=mChildMaxHeight+mVspace;
                    left=0;
                }
            }
            view.layout(left,top,left+view.getMeasuredWidth(),top+getMeasuredHeight());
            left+=view.getMeasuredWidth()+mHscape;

        }


    }

    //绘制
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    private void findMaxChilder() {

        mChildMaxHeight=0;
        int childcount=getChildCount();
        for (int i=0;i<childcount;i++)
        {
            View view=getChildAt(i);
            if(view.getMeasuredHeight()>mChildMaxHeight)
            {
                mChildMaxHeight=view.getMeasuredHeight();
            }
        }
    }
}

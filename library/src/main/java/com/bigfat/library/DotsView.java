package com.bigfat.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/**
 * Created by yueban on 27/7/15.
 */
public class DotsView extends View {
    public static final int ORIENTATION_HORIZONTAL = 0;
    public static final int ORIENTATION_VERTICAL = 1;

    private int colorSelected = Color.BLUE;
    private int colorUnselected = Color.GRAY;
    private int dotSpace;
    private int dotRadius;
    private int count;
    private int current;
    private int orientation;
    private Paint paint;

    public DotsView(Context context) {
        this(context, null);
    }

    public DotsView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DotsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.DotsView);

        colorSelected = a.getColor(R.styleable.DotsView_dv_colorSelected, Color.BLUE);
        colorUnselected = a.getColor(R.styleable.DotsView_dv_colorUnselected, Color.GRAY);
        //default 6dp
        dotSpace = a.getDimensionPixelOffset(R.styleable.DotsView_dv_dotSpace, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 6, getResources().getDisplayMetrics()));
        //default 2dp
        dotRadius = a.getDimensionPixelOffset(R.styleable.DotsView_dv_dotRadius, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, getResources().getDisplayMetrics()));
        count = a.getInt(R.styleable.DotsView_dv_count, 0);
        current = a.getInt(R.styleable.DotsView_dv_current, 0);
        orientation = a.getInt(R.styleable.DotsView_dv_orientation, ORIENTATION_HORIZONTAL);

        a.recycle();

        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //MeasureSpec.EXACTLY测量模式
        int sizeWith = MeasureSpec.getSize(widthMeasureSpec);
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);

        //MeasureSpec.AT_MOST测量模式，即宽/高设置为wrap_content时
        int width = 0;
        int height = 0;

        switch (orientation) {
            case ORIENTATION_HORIZONTAL:
                height = dotRadius * 2;//最小高度为点的直径
                if (count > 0) {
                    width = dotSpace * (count - 1) + dotRadius * 2 * count;
                }
                break;

            case ORIENTATION_VERTICAL:
                width = dotRadius * 2;//最小宽度为点的直径
                if (count > 0) {
                    height = dotSpace * (count - 1) + dotRadius * 2 * count;
                }
                break;
        }

        //根据测量模式设置宽高
        setMeasuredDimension(modeWidth == MeasureSpec.AT_MOST ? width + getPaddingLeft() + getPaddingRight() : sizeWith,
                modeHeight == MeasureSpec.AT_MOST ? height + getPaddingTop() + getPaddingBottom() : sizeHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (count > 0) {
            if (ORIENTATION_HORIZONTAL == orientation) {
                int leftStart = (getMeasuredWidth() - (dotSpace * (count - 1) + dotRadius * 2 * count)) / 2;//水平方向绘制起点
                for (int i = 0; i < count; i++) {
                    if (i == current) {
                        paint.setColor(colorSelected);
                    } else {
                        paint.setColor(colorUnselected);
                    }
                    int centerX = leftStart + dotRadius + (dotRadius * 2 + dotSpace) * i;
                    int centerY = getMeasuredHeight() / 2;
                    canvas.drawCircle(centerX, centerY, dotRadius, paint);
                }
            } else if (ORIENTATION_VERTICAL == orientation) {
                int topStart = (getMeasuredHeight() - (dotSpace * (count - 1) + dotRadius * 2 * count)) / 2;//竖直方向绘制起点
                for (int i = 0; i < count; i++) {
                    if (i == current) {
                        paint.setColor(colorSelected);
                    } else {
                        paint.setColor(colorUnselected);
                    }
                    int centerX = getMeasuredWidth() / 2;
                    int centerY = topStart + dotRadius + (dotRadius * 2 + dotSpace) * i;
                    canvas.drawCircle(centerX, centerY, dotRadius, paint);
                }
            }
        }
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
        invalidate();
    }

    public void setColorSelected(int colorSelected) {
        this.colorSelected = colorSelected;
        invalidate();
    }

    public void setColorUnselected(int colorUnselected) {
        this.colorUnselected = colorUnselected;
        invalidate();
    }

    public void setDotSpace(int dotSpace) {
        this.dotSpace = dotSpace;
        invalidate();
    }

    public void setDotRadius(int dotRadius) {
        this.dotRadius = dotRadius;
        invalidate();
    }

    public void setCount(int count) {
        this.count = count;
        requestLayout();
        invalidate();
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
        requestLayout();
        invalidate();
    }
}
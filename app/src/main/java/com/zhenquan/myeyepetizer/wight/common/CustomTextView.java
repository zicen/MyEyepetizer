package com.zhenquan.myeyepetizer.wight.common;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.DimenRes;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.xk.eyepetizer.util.DisplayManager;

import java.util.ArrayList;


public class CustomTextView extends AppCompatTextView {

        private Paint mPaint = null;
        private Paint.FontMetrics fm;
        private float offset;
        private String content = "测试数据";
        private float lineSpace = 0;

        public CustomTextView(Context context) {
            super(context);
        }

        public CustomTextView(Context context, AttributeSet set) {
            super(context, set, 0);
        }

        public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
        }



        private void initParams() {
            fm = mPaint.getFontMetrics();
            if (lineSpace > 0) {
                fm.leading = lineSpace;
            }else{
                fm.leading = dip2px(1);
            }
            offset = fm.descent - fm.ascent + fm.leading;
        }

        public static int dip2px(float dpValue) {
            return DisplayManager.INSTANCE.dip2px(dpValue);
        }

        private ArrayList<String> list = new ArrayList<>(0);

        private ArrayList<String> calculateLines(String content, int width) {
            list.clear();
            int length = content.length();
            float textWidth = mPaint.measureText(content);
            if (textWidth <= width) {
                list.add(content);
                return list;
            }

            int start = 0, end = 1;
            while (start < length) {
                if (mPaint.measureText(content, start, end) > width) {
                    list.add(content.substring(start, end - 1));
                    start = end - 1;
                } else if (end < length) {
                    end++;
                }
                if (end == length) {
                    list.add(content.subSequence(start, end).toString());
                    break;
                }
            }
            return list;
        }


        /**
         * @param spacing R.dimen.xx
         */
        public void setLineSpacingExtra(@DimenRes int spacing) {
            this.lineSpace = getResources().getDimension(spacing);
            initParams();
            invalidate();
        }
}

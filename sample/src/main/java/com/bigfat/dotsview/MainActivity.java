package com.bigfat.dotsview;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bigfat.library.DotsView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private DotsView dotsViewVertical;
    private DotsView dotsViewHorizontal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        dotsViewVertical = (DotsView) findViewById(R.id.dv_vertical);
        dotsViewHorizontal = (DotsView) findViewById(R.id.dv_horizontal);

        final List<View> viewList = generateViewList();

        PagerAdapter adapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return viewList.size();
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(viewList.get(position));
                return viewList.get(position);
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(viewList.get(position));
            }
        };
        ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                dotsViewVertical.setCurrent(position);
                dotsViewHorizontal.setCurrent(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(listener);

        dotsViewHorizontal.setCount(adapter.getCount());
        dotsViewVertical.setCount(adapter.getCount());

        listener.onPageSelected(0);
    }

    private List<View> generateViewList() {
        List<View> viewList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            TextView textView = new TextView(MainActivity.this);
            textView.setText("page" + i);
            textView.setTextSize(30);
            textView.setPadding(100, 100, 100, 100);
            viewList.add(textView);
        }
        return viewList;
    }
}
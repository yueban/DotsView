package com.bigfat.dotsview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bigfat.library.DotsView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private DotsView dotsViewVertical;
    private DotsView dotsViewHorizontal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dotsViewVertical = (DotsView) findViewById(R.id.dv_vertical);
        dotsViewHorizontal = (DotsView) findViewById(R.id.dv_horizontal);
        dotsViewHorizontal.setCount(5);

        new Timer().schedule(new TimerTask() {
            int current = 0;

            @Override
            public void run() {
                dotsViewVertical.post(new Runnable() {
                    @Override
                    public void run() {
                        dotsViewVertical.setCurrent(++current % 3);
                    }
                });
            }
        }, 0, 800);

        new Timer().schedule(new TimerTask() {
            int current = 0;

            @Override
            public void run() {
                dotsViewHorizontal.post(new Runnable() {
                    @Override
                    public void run() {
                        dotsViewHorizontal.setCurrent(++current % 5);
                    }
                });
            }
        }, 0, 300);
    }
}

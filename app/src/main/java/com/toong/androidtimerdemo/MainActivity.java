package com.toong.androidtimerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TimerTask t = new TimerTask() {
            @Override
            public void run() {
                Log.i("Linh", "1");
            }
        };

        findViewById(R.id.starTimer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer = new Timer();
                timer.scheduleAtFixedRate(t,1000,1000);
            }
        });

        findViewById(R.id.stopTimer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.cancel();
            }
        });
    }
}

/**
 * Reference:
 * -
 * Different between schedule and scheduleFixRate
 * https://stackoverflow.com/questions/22486997/what-is-the-difference-between-schedule-and-scheduleatfixedrate
 *
 */
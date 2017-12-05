package com.toong.androidtimerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private String TAG = getClass().getSimpleName();
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testTimer();
    }

    /**
     * Reference:
     * -
     * Different between schedule and scheduleFixRate
     * https://stackoverflow.com/questions/22486997/what-is-the-difference-between-schedule-and-scheduleatfixedrate
     */
    private void testTimer() {
        findViewById(R.id.starTimer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "starTimer clicked");
                final TimerTask t = new TimerTask() {
                    @Override
                    public void run() {
                        Log.i("Linh", "this run on background thread");
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Log.i(TAG, "timer called");
                                Toast.makeText(MainActivity.this, "timmer", Toast.LENGTH_SHORT)
                                        .show();
                            }
                        });
                    }
                };
                timer = new Timer();
                timer.scheduleAtFixedRate(t, 1000, 5000);
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
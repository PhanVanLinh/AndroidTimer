package com.toong.androidtimerdemo;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

public class CountDownTimerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down_timer);

        testCountDownTimer();
    }

    /**
     * Both onTick and onFinish run on ui thread
     */
    private void testCountDownTimer() {
        CountDownTimer countDownTimer = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Log.i("Linh",
                        "onTick this run on main thread millisUntilFinished" + millisUntilFinished);
                Toast.makeText(CountDownTimerActivity.this, "onTick", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFinish() {
                Log.i("Linh", "onFinish this run on main thread");
                Toast.makeText(CountDownTimerActivity.this, "onFinish", Toast.LENGTH_SHORT).show();
            }
        };

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, 2000);

        countDownTimer.start();
    }
}

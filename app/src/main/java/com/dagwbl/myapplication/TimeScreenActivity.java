package com.dagwbl.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;


public class TimeScreenActivity extends AppCompatActivity {
    long timecurrentTimeMillis = System.currentTimeMillis();
    long timeGetTime = new Date().getTime();
    long timeSeconds = System.currentTimeMillis();
    long timeMillis = Calendar.getInstance().getTimeInMillis();
    private TextView textView;


    SimpleDateFormat realTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_screen);
        Log.d("TimeScreen", "onCreate: ceui");


    }
}




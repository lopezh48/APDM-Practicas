package com.example.eva3_10_banner_post;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView imgVwBanner;
    SeekBar skVel;
    int i=0, mili=250;
    Thread thread;
    Handler handler= new Handler();

    Runnable background = new Runnable() {
        @Override
        public void run() {
            while (true){
                skVel.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        mili= progress;
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
                try {
                    Thread.sleep(mili);
                    handler.post(foreground);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    };

    Runnable foreground = new Runnable() {
        @Override
        public void run() {
            int img=0;
            if(i==0){
                img = R.drawable.f1;
                i++;
            } else if(i==1){
                img= R.drawable.f2;
                i++;
            }else if(i==2){
                img= R.drawable.f3;
                i=0;
            }
            imgVwBanner.setImageResource(img);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgVwBanner= findViewById(R.id.imgVwBanner);
        skVel = findViewById(R.id.skVel);
        thread = new Thread(background);
        thread.start();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        thread.interrupt();
    }


}
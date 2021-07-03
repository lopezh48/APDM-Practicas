package com.example.eva3_7_handler_banner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imgVwBanner;
    Thread tBanner;
    int i=1;

    Handler handler= new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            //Toast.makeText(getApplicationContext(), "Funciona ", Toast.LENGTH_SHORT).show();
            int img=1;
            if(i==1){
                img = R.drawable.f1;
                i++;
            } else if(i==2){
                img= R.drawable.f2;
                i++;
            }else if(i==3){
                img= R.drawable.f3;
                i=1;
            }
            imgVwBanner.setImageResource(img);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgVwBanner= findViewById(R.id.imgViewBanner);

        tBanner = new Thread(){
            @Override
            public void run() {
                super.run();
                while(true){
                    try {
                        Thread.sleep(3000);
                        Message message= handler.obtainMessage();
                        handler.sendMessage(message);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        tBanner.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tBanner.interrupt();
    }
}
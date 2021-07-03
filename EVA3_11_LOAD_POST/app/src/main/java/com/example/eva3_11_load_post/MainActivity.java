package com.example.eva3_11_load_post;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ImageView imgVwLoad;

    Handler handler= new Handler();
    Thread thread;
    Bitmap bitmap;

    Runnable background = new Runnable() {
        @Override
        public void run() {


            InputStream inputStream = null;
            try {
                inputStream = (InputStream) new URL("https://nintenduo.com/wp-content/uploads/2020/05/xenoblade-1.jpg").getContent();
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            handler.post(foreground);
        }
    };

    Runnable foreground = new Runnable() {
        @Override
        public void run() {
            imgVwLoad.setImageBitmap(bitmap);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgVwLoad= findViewById(R.id.imgVwLoad);
        thread = new Thread(background);
        thread.start();
    }

    private Bitmap descargarImagen(String url){

        return null;
    }
}
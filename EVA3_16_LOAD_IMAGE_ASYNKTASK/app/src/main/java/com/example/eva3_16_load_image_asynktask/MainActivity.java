package com.example.eva3_16_load_image_asynktask;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AsyncPlayer;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ImageView imgVwLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgVwLoad= findViewById(R.id.imgVwLoad);
        MiClaseAsincrona miCA = new MiClaseAsincrona();
        miCA.execute("https://nintenduo.com/wp-content/uploads/2020/05/xenoblade-1.jpg");
    }

    class MiClaseAsincrona extends AsyncTask<String,Bitmap,Void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
        }

        @Override
        protected void onProgressUpdate(Bitmap... values) {
            super.onProgressUpdate(values);
            imgVwLoad.setImageBitmap(values[0]);
        }

        @Override
        protected Void doInBackground(String... strings) {
            try {
                InputStream inputStream = (InputStream) new URL(strings[0]).getContent();
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                publishProgress(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}
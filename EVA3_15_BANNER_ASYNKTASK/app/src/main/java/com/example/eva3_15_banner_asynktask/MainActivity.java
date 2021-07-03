package com.example.eva3_15_banner_asynktask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imgVwBanner;
    int i=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgVwBanner = findViewById(R.id.imgVwBanner);
        MiClaseAsincrona miCA = new MiClaseAsincrona();
        miCA.execute(i);
    }

    class MiClaseAsincrona extends AsyncTask<Integer,Integer,Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            imgVwBanner.setImageResource(values[0]);
        }

        @Override
        protected Void doInBackground(Integer... strings) {
            int img=1;
            while(true){
                try {
                    Thread.sleep(1000);
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
                    publishProgress(img);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
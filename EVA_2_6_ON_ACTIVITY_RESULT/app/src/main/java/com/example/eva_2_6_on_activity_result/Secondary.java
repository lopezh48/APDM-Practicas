package com.example.eva_2_6_on_activity_result;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Secondary extends AppCompatActivity {

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        //intent= new Intent();
        intent=getIntent();
        Toast.makeText(this,intent.getStringExtra("Datos"),Toast.LENGTH_LONG).show();
    }
    public void OnClick(View v){
        intent.putExtra("Valor", "Hola mundo cruel");
        setResult(Activity.RESULT_OK,intent);
        finish();
    }
    public void OnClickCancel(View v){
        setResult(Activity.RESULT_CANCELED);
        finish();
    }
}
package com.example.eva_2_6_on_activity_result;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final static int CODIGO_SECUN= 420;
    final static int CODIGO_IMAGENES=8;
    final static int CODIGO_CONTACTOS=78;
    Button btnIni;
    Intent intent,intentCont,intentIma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent= new Intent(this,Secondary.class);
        intentCont=new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        intentIma=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case CODIGO_SECUN:
                if(resultCode== Activity.RESULT_OK){
                    Toast.makeText(this, data.getStringExtra("Valor"),Toast.LENGTH_LONG).show();
                }
                break;
            case CODIGO_CONTACTOS:
                if(resultCode==Activity.RESULT_OK){
                    String returnedData=data.getDataString();
                    Toast.makeText(this,returnedData,Toast.LENGTH_LONG).show();
                }
                break;
            case CODIGO_IMAGENES:
                if(resultCode==Activity.RESULT_OK){
                    String returnedData=data.getDataString();
                    Toast.makeText(this,returnedData,Toast.LENGTH_LONG).show();
                }
                break;
            default:
        }
    }

    public void OnClickCon (View v){
        startActivityForResult(intentCont,CODIGO_CONTACTOS);
    }

    public void OnClickImag (View v){
        startActivityForResult(intentIma,CODIGO_IMAGENES);
    }

    @Override
    protected void onStart(){
        super.onStart();
        btnIni=findViewById(R.id.btnIni);
        btnIni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("Datos","Información enviada desde principal!!");
                startActivityForResult(intent,CODIGO_SECUN);
            }
        });





    }
}
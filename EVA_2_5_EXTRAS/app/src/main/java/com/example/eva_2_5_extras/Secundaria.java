package com.example.eva_2_5_extras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Secundaria extends AppCompatActivity {

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);
        intent=getIntent();
        String sNom=intent.getStringExtra("NAME");
        Double dSal=intent.getDoubleExtra("SALARIO",0.0);
        boolean bInfo=intent.getBooleanExtra("INFO", false);
        int iEstado= intent.getIntExtra("ESTADO CIVIL",0);
        TextView txtVwDatos;
        txtVwDatos=findViewById(R.id.txtVwDatos);
        txtVwDatos.append("Nombre:  \n" );
        txtVwDatos.append(sNom+  "\n" );
        txtVwDatos.append("Salario:  \n" );
        txtVwDatos.append(dSal +"\n" );
        txtVwDatos.append("Informacion extra: \n" );
        //txtVwDatos.append(bInfo +"\n" );
        if(bInfo)
            txtVwDatos.append("Con informacion  \n");
        else
            txtVwDatos.append("Sin informacion  \n");

        //RadioButton rdTemp=findViewById(iEstado);
        txtVwDatos.append("Estado Civil \n");
        txtVwDatos.append(iEstado + "\n");

    }

    public void onClickSal (View v){
        finish();
    }
}
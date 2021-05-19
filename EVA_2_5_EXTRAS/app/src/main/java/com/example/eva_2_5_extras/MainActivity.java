package com.example.eva_2_5_extras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText edtTxtNom, edtTxtSal;
    CheckBox chkBxInfo;
    //RadioButton rdBtnSol, rdBtnCas, rdBtnDiv, rdBtnEtc;
    RadioGroup rdGrpEstadoCiv;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent=new Intent(this,Secundaria.class);
    }

    protected void onStart (){
        super.onStart();
        edtTxtNom=findViewById(R.id.edtTxtNom);
        edtTxtSal=findViewById(R.id.edtTxtSal);
        chkBxInfo=findViewById(R.id.chkBxInf);
        /*rdBtnSol=findViewById(R.id.rdBtnSol);
        rdBtnCas=findViewById(R.id.rdBtnCas);
        rdBtnDiv=findViewById(R.id.rdBtnDiv);
        rdBtnEtc=findViewById(R.id.rdBtnSin);*/
        rdGrpEstadoCiv=findViewById(R.id.rdGrpEstadoCiv);
    }

    public void onClick(View v){
        intent.putExtra("NAME",edtTxtNom.getText().toString());
        Double dSalario=0.0;
        dSalario=Double.parseDouble(edtTxtSal.getText().toString());
        intent.putExtra("SALARIO",dSalario);
        intent.putExtra("INFO",chkBxInfo.isChecked());
        intent.putExtra("ESTADO CIVIL", rdGrpEstadoCiv.getCheckedRadioButtonId());
        startActivity(intent);
    }
}
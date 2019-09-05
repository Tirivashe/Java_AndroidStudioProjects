package com.tirivashe.practicecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.app.*;
import android.content.*;

public class MyActivity2 extends AppCompatActivity {

    public TextView resultNB;
    public TextView successNB;
    public EditText returnNB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my2);

        resultNB = (TextView)findViewById(R.id.textView2);
        successNB = (TextView)findViewById(R.id.textView5);
        resultNB = (EditText)findViewById(R.id.editText1);

        Intent intent = getIntent();

        Double transferredRes;
        transferredRes = intent.getDoubleExtra("Area",0);
        String transText = intent.getStringExtra("Success");

        resultNB.setText("Your area is " + transferredRes);
        successNB.setText(transText);
        
    }

    public void switchActiv(View view){
        finish();
    }
}

package com.tirivashe.areacalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.*;
import android.widget.*;

public class MyActivity extends AppCompatActivity {
    private EditText heightET;
    private EditText widthET;
    private TextView areaET;
    private Button calculateET;

    private Area nArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        nArea = new Area();

        heightET = (EditText)findViewById(R.id.editText1);
        widthET = (EditText) findViewById(R.id.editText2);
        areaET = (TextView)findViewById(R.id.textView2);
        calculateET = (Button)findViewById(R.id.button);

    }

    public void computeArea(View view){
        double h = Double.valueOf(heightET.getText().toString());
        double w = Double.valueOf(widthET.getText().toString());

        nArea.setHeight(h);
        nArea.setWidth(w);

        areaET.setText("" + nArea.computeArea());
    }



}

package com.tirivashe.practicecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import android.app.*;

public class MyActivity extends AppCompatActivity {

    Area nArea = new Area();

    EditText heightET;
    EditText widthET;
    TextView resultET;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        heightET = (EditText) findViewById(R.id.editText1);
        widthET = (EditText)findViewById(R.id.editText2);
        resultET = (TextView)findViewById(R.id.textView2);
        btn = (Button)findViewById(R.id.button1);

    }

    public void compute(View view){
        int h = Integer.valueOf(heightET.getText().toString());
        int w = Integer.valueOf(widthET.getText().toString());

        nArea.setHeight(h);
        nArea.setWidth(w);
        double resultRT = nArea.computeArea();
        String success = "Your result has been successfully calculated";

        //resultET.setText("Your area is: " + nArea.computeArea());

        Intent intent = new Intent(this,MyActivity2.class);
        intent.putExtra("Success",success);
        intent.putExtra("Area",resultRT);
        startActivity(intent);
    }
}

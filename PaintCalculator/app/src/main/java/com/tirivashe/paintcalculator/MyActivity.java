package com.tirivashe.paintcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.EditText;

public class MyActivity extends Activity {
    private InteriorRoom mRoom;

    private EditText lengthET;
    private EditText widthET;
    private EditText heightET;
    private EditText nDoorsET;
    private EditText nWindowsET;

    private TextView nGallonsV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        referenceUIcomponents();
        mRoom = new InteriorRoom();
    }
    private void referenceUIcomponents(){
        lengthET = (EditText) findViewById(R.id.editText1);
        widthET = (EditText) findViewById(R.id.editText2);
        heightET = (EditText) findViewById(R.id.editText3);
        nDoorsET = (EditText) findViewById(R.id.editText4);
        nWindowsET = (EditText) findViewById(R.id.editText5);
        nGallonsV = (TextView) findViewById(R.id.textView9);
    }

    public void computeGallons(View view){
        double l = Double.valueOf(lengthET.getText().toString());
        double w = Double.valueOf(widthET.getText().toString());
        double h = Double.valueOf(heightET.getText().toString());

        mRoom.setLength(l);
        mRoom.setWidth(w);
        mRoom.setHeight(h);

        int doors = Integer.valueOf(nDoorsET.getText().toString());
        int windows = Integer.valueOf(nWindowsET.getText().toString());
        mRoom.setDoors(doors);
        mRoom.setWindows(windows);

        nGallonsV.setText("Interior surface area: " + mRoom.surfaceArea() + " feet");
    }
    public void gotoHelp(View view){
        Intent helpIntent = new Intent(MyActivity.this, HelpActivity.class);
        startActivity(helpIntent);
    }
}

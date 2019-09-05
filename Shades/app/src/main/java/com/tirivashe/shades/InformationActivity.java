package com.tirivashe.shades;
import android.app.*;
import android.content.*;
import android.content.res.Configuration;
import android.widget.*;
import android.os.Bundle;

public class InformationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            finish();
            return;
        }

        setContentView(R.layout.information_fragment);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String shdeInformation = intent.getStringExtra("Information");

        TextView informtion = (TextView)findViewById(R.id.textView);
        informtion.setText(shdeInformation);
    }
}

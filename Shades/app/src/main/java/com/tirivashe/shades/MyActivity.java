package com.tirivashe.shades;

import android.app.*;
import android.os.*;
import android.content.*;

public class MyActivity extends Activity implements ListFragment.OnItemSelectedListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }

    @Override
    public void onShadeItemSelected(String link){
        InformationFragment informationFragment = (InformationFragment)getFragmentManager().findFragmentById(R.id.fragment2);

        if(informationFragment != null && informationFragment.isInLayout()){
            informationFragment.setText(link);
        }
        else{
            Intent intent = new Intent(this,InformationActivity.class);
            intent.putExtra("Information",link);
            startActivity(intent);
        }
    }
}

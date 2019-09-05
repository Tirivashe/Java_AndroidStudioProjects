package com.tirivashe.burgercaloriecounter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MyActivity extends Activity {

    private RadioGroup pattyRG;
    private CheckBox proscuittoCBX;
    private RadioGroup cheeseRG;
    private SeekBar sauceSBR;
    private TextView caloriesTV;

    private Burger burger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        burger = new Burger();
        initialize();
        registerChangeListener();
    }

    private void initialize(){
        pattyRG = (RadioGroup) findViewById(R.id.radioGroup1);
        proscuittoCBX = (CheckBox) findViewById(R.id.checkBox1);
        cheeseRG = (RadioGroup) findViewById(R.id.radioGroup2);
        sauceSBR = (SeekBar)findViewById(R.id.seekBar1);
        caloriesTV = (TextView) findViewById(R.id.textView2);

        displayCalories();
    }

    private void registerChangeListener(){
        pattyRG.setOnCheckedChangeListener(foodListener);
        proscuittoCBX.setOnClickListener(baconListener);
        cheeseRG.setOnCheckedChangeListener(foodListener);
        sauceSBR.setOnSeekBarChangeListener(sauceListener);
    }

    private OnCheckedChangeListener foodListener = new OnCheckedChangeListener(){
        public void onCheckedChanged(RadioGroup rbGroup, int radioId){
            switch (radioId){
                case R.id.radio0:
                    burger.setPattyCalories(Burger.BEEF);
                    break;
                case R.id.radio1:
                    burger.setPattyCalories(Burger.LAMB);
                    break;
                case R.id.radio2:
                    burger.setPattyCalories(Burger.OSTRICH);
                    break;
                case R.id.radio3:
                    burger.setCheeseCalories(Burger.ASIAGO);
                    break;
                case R.id.radio4:
                    burger.setCheeseCalories(Burger.CREME_FRAICHE);
                    break;
            }
            displayCalories();
        }
    };

    private OnClickListener baconListener = new OnClickListener() {
      public void onClick (View v){
          if(((CheckBox)v).isChecked())
              burger.setProscuittoCalories(Burger.PROSCUITTO);
          else
              burger.clearProscuittoCalories();
          displayCalories();
      }
    };
    private OnSeekBarChangeListener sauceListener = new OnSeekBarChangeListener() {
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
            burger.setSauceCalories(seekBar.getProgress());
            displayCalories();
        }
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    private void displayCalories(){
        String calorieText = "Calories : " + burger.getTotalCalories();
        caloriesTV.setText(calorieText);
    }
}

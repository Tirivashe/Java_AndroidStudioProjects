package com.tirivashe.shippingcalc2;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TableLayout;
import android.widget.TableRow;


public class MainActivity extends Activity {
    private ShipItem shipItem;

    private EditText weightET;
    private TextView baseCostTV;
    private TextView addedCostTV;
    private TextView totalCostTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shipItem = new ShipItem();
        weightET = (EditText) findViewById(R.id.editText1);

        baseCostTV = (TextView)findViewById(R.id.textView4);
        addedCostTV = (TextView)findViewById(R.id.textView6);
        totalCostTV = (TextView)findViewById(R.id.textView8);

        weightET.addTextChangedListener(weightTextWatcher);

    }

    private TextWatcher weightTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try{
                shipItem.setWeight((int)Double.parseDouble(s.toString()));
            }catch (NumberFormatException e){
                shipItem.setWeight(0);
            }
            displayShipping();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private void displayShipping(){
        baseCostTV.setText("$" + String.format("%.02f",shipItem.getBaseCost()));
        addedCostTV.setText("$" + String.format("%.02f",shipItem.getAddedCost()));
        totalCostTV.setText("$" + String.format("%.02f",shipItem.getTotalCost()));
    }


}

package com.tirivashe.unitconversioncalculator;

import android.app.*;
import android.os.Bundle;
import android.text.*;
import android.view.*;
import android.widget.*;

public class MyActivity extends Activity {

    private TextView inputLabel;
    private TextView outputLabel;
    private EditText inputMeasurement;
    private TextView outputMeasurement;

    Conversion conversion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        conversion = new Conversion();
        setUpReferenceDisplay();
    }

    private void setUpReferenceDisplay() {
        inputLabel = (TextView) findViewById(R.id.textView1);
        inputLabel.setText(conversion.inputLabel);

        outputLabel = (TextView) findViewById(R.id.textView2);
        outputLabel.setText(conversion.outputLabel);

        outputMeasurement = (TextView) findViewById(R.id.textView3);
        outputMeasurement.setText(conversion.outputValue.toString());

        inputMeasurement = (EditText) findViewById(R.id.editText1);
        inputMeasurement.setText(conversion.inputValue.toString());
        inputMeasurement.addTextChangedListener(inputTextWatcher);
    }

    private TextWatcher inputTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                conversion.inputValue = Double.parseDouble(s.toString());
            } catch (NumberFormatException e) {
                conversion.inputValue = 0.0;
            }
            conversion.compute();
            outputMeasurement.setText(conversion.outputValue.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            toggleActionBar();
        }
        return true;
    }

    private void toggleActionBar() {
        ActionBar actionBar = getActionBar();

        if (actionBar != null) {
            if (actionBar.isShowing()) {
                actionBar.hide();
            } else {
                actionBar.show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menuitem_feet_meters) {
            conversion.switch_toInchesCentimeters();
            resetDisplay();
            return true;
        } else if (id == R.id.menuitem_inches_cent) {
            conversion.switch_toInchesCentimeters();
            resetDisplay();
            return true;
        } else if (id == R.id.menuitem_pounds_grams) {
            conversion.switch_toPoundsGrams();
            resetDisplay();
            return true;
        } else if (id == R.id.menuitem_quit) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void resetDisplay(){
        inputLabel.setText(conversion.inputLabel);
        outputLabel.setText(conversion.outputLabel);
        outputMeasurement.setText(conversion.outputValue.toString());
        inputMeasurement.setText(conversion.inputValue.toString());
    }
}

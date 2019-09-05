package com.tirivashe.userinput;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;
import android.widget.TextView;
import android.text.TextWatcher;

public class MyActivity extends AppCompatActivity {

    private EditText userInput;
    private TextView returnText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        userInput = (EditText) findViewById(R.id.editText1);
        returnText = (TextView) findViewById(R.id.textView1);

        userInput.addTextChangedListener(userTextWatcher);
    }

    private TextWatcher userTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            returnText.setText(userInput.getText().toString());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}

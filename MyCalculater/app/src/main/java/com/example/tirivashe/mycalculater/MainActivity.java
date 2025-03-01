package com.example.tirivashe.mycalculater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private TextView _screen;
    private String display = "";
    private String currentOperator = "";
    private String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _screen = (TextView)findViewById(R.id.textView);
        _screen.setText(display);


    }

    private void updateScreen(){
        _screen.setText(display);
    }

    public void onClickNumber(View v){
        if (result != ""){
            clear();
            updateScreen();
        }
        Button b = (Button) v;
        display += b.getText();
        updateScreen();
    }

    private boolean isOperator(char op){
        switch (op){
            case'+':
            case'-':
            case'X':
            case'/': return true;
            default: return false;
        }
    }

    public void onClickOperator(View v){
        if(display == "")return;

        Button b = (Button)v;

        if(result != ""){
            String _display = result;
            result = "";
            display = _display;
        }

        if(currentOperator != ""){
            Log.d("CalcX", "" + display.charAt(display.length()-1));
            if(isOperator(display.charAt(display.length()-1))){
               display = display.replace(display.charAt(display.length()-1),b.getText().charAt(0));
                updateScreen();
                return;
            }else {
                getResult();
                display = result;
                result = "";
            }
            currentOperator = b.getText().toString();
        }


        display +=b.getText();
        currentOperator = b.getText().toString();
        updateScreen();
    }

    private void clear(){
        display = "";
        currentOperator = "";
       result = "";
    }

    public void onCLickClear(View v){
        clear();
        updateScreen();
        result = "";
    }

    private double operate(String a, String b, String op){;
        switch (op){
            case"+": return Double.valueOf(a) + Double.valueOf(b);
            case"-": return Double.valueOf(a) - Double.valueOf(b);
            case"X": return Double.valueOf(a) * Double.valueOf(b);
            case"/": return Double.valueOf(a) / Double.valueOf(b);
            default: return -1;
        }
    }

    private boolean getResult(){
        if(currentOperator == "") return false;
        String [] operation = display.split(Pattern.quote(currentOperator));
        if(operation.length < 2) return false;
        result = String.valueOf(operate(operation[0], operation[1],currentOperator));
        return true;
    }

    public void onClickEqual(View v){
        if(display == "") return;
        if(getResult()) return;
       _screen.setText(display + "\n" + String.valueOf(result));
    }
}


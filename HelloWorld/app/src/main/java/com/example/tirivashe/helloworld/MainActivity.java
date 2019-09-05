package com.example.tirivashe.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;


public class MainActivity extends Activity {

    private TextView greetingTextView;
    private boolean isHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        greetingTextView = (TextView) findViewById(R.id.textView);
        initializeGreeting();

        Button exclaimBtn = (Button) findViewById(R.id.button);
        exclaimBtn.setOnClickListener(toggleGreeting);
    }
    private final View.OnClickListener toggleGreeting = new View.OnClickListener(){
        public void onClick (View btn){
            if (isHello){
                isHello = false;
                greetingTextView.setText(R.string.goodbye);
            }
            else{
                isHello = true;
                greetingTextView.setText(R.string.hello);
            }
        }
    };
    private void initializeGreeting(){
        isHello = true;
    }
}

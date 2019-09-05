package com.tirivashe.tapbuttoncounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.app.Activity;


public class MainActivity extends Activity {

    private Counter count;
    private TextView countView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        //setContentView(R.layout.activity_main);

        count = new Counter();
        countView = (TextView) findViewById(R.id.textView);

    }
    public void countTap (View view){
        count.addCount();
        countView.setText(count.getCount().toString());
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }*/

    /*@Override
    public boolean onOptionsItemsSelected(MenuItem item){
        int id = item.getItemId();
       if(id == R.id.action_settings){
           return true;
       }
       return super.onOptionsItemSelected(item);
    }*/

}

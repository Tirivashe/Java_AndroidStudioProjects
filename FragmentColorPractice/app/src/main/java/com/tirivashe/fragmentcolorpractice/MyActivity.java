package com.tirivashe.fragmentcolorpractice;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity extends Activity {

    private static final String TAB_KEY_INDEX = "tab_key";
    private Fragment redFragment;
    private Fragment blueFragment;
    private Fragment greenFragment;
    private Fragment whiteFragment;
    private Fragment lightFragment;
    private Fragment mileFragment;

    private TextView inputLabel;
    private TextView outputLabel;
    private EditText inputMeasurement;
    private TextView outputMeasurement;

    Conversion conversion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(false);

        ActionBar.Tab redTab = actionBar.newTab().setText(getString(R.string.ui_tabname_red));
        ActionBar.Tab greenTab = actionBar.newTab().setText(getString(R.string.ui_tabname_green));
        ActionBar.Tab blueTab = actionBar.newTab().setText(getString(R.string.ui_tabname_blue));
        ActionBar.Tab whiteTab = actionBar.newTab().setText(getString(R.string.ui_tabname_white));
        ActionBar.Tab lightTab = actionBar.newTab().setText(getString(R.string.ui_tabname_light));
        ActionBar.Tab mileTab = actionBar.newTab().setText(getString(R.string.ui_tabname_mile));

        redFragment = new RedFragment();
        greenFragment = new GreenFragment();
        blueFragment = new BlueFragment();
        whiteFragment = new WhiteFragment();
        lightFragment = new LightYearFrag();
        mileFragment = new MileFrag();

        redTab.setTabListener(new MyTabsListener(redFragment, getApplicationContext()));
        greenTab.setTabListener(new MyTabsListener(greenFragment, getApplicationContext()));
        blueTab.setTabListener(new MyTabsListener(blueFragment, getApplicationContext()));
        whiteTab.setTabListener(new MyTabsListener(whiteFragment, getApplicationContext()));
        lightTab.setTabListener(new MyTabsListener(lightFragment, getApplicationContext()));
        mileTab.setTabListener(new MyTabsListener(mileFragment, getApplicationContext()));


        actionBar.addTab(redTab);
        actionBar.addTab(greenTab);
        actionBar.addTab(blueTab);
        actionBar.addTab(whiteTab);
        actionBar.addTab(lightTab);
        actionBar.addTab(mileTab);



        if(savedInstanceState != null){
            actionBar.setSelectedNavigationItem(savedInstanceState.getInt(TAB_KEY_INDEX, 0));
        }
    }

}
class MyTabsListener implements ActionBar.TabListener{
    public Fragment fragment;

    public MyTabsListener(Fragment f,Context context){
        fragment = f;
    }
    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft){
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft){
        ft.replace(R.id.fragment_container, fragment);
    }
    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft){
        ft.remove(fragment);
    }
}

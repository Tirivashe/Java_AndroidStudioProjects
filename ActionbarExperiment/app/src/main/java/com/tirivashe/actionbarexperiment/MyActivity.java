package com.tirivashe.actionbarexperiment;

import android.app.*;
import android.os.Bundle;
import android.content.Context;
import android.view.*;

public class MyActivity extends Activity{

    private static final String TAB_KEY_INDEX = "tab_key";
    private Fragment breakfastFragment;
    private Fragment lunchFragment;
    private Fragment snackFragment;
    private Fragment dinnerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(false);

        ActionBar.Tab breakfastTab = actionBar.newTab().setText(getString(R.string.ui_tabname_breakfast));
        ActionBar.Tab lunchTab = actionBar.newTab().setText(getString(R.string.ui_tabname_lunch));
        ActionBar.Tab snackTab = actionBar.newTab().setText(getString(R.string.ui_tabname_snack));
        ActionBar.Tab dinnerTab = actionBar.newTab().setText(getString(R.string.ui_tabname_dinner));

        breakfastFragment = new BreakfastFragment();
        snackFragment = new SnackFragment();
        lunchFragment = new LunchFragment();
        dinnerFragment = new DinnerFragment();

        breakfastTab.setTabListener(new MyTabsListener(breakfastFragment, getApplicationContext()));
        snackTab.setTabListener(new MyTabsListener(snackFragment, getApplicationContext()));
        lunchTab.setTabListener(new MyTabsListener(lunchFragment, getApplicationContext()));
        dinnerTab.setTabListener(new MyTabsListener(dinnerFragment, getApplicationContext()));

        actionBar.addTab(breakfastTab);
        actionBar.addTab(lunchTab);
        actionBar.addTab(snackTab);
        actionBar.addTab(dinnerTab);

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

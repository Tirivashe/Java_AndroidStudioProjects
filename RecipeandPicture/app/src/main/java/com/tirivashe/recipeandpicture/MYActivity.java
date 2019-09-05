package com.tirivashe.recipeandpicture;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;

public class MYActivity extends Activity {

    private static final String TAB_KEY_INDEX = "tab_key";
    private Fragment pictureFragment;
    private Fragment recipeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(false);

        ActionBar.Tab pictureTab = actionBar.newTab().setText(getString(R.string.ui_tabname_picture));
        ActionBar.Tab recipeTab = actionBar.newTab().setText(getString(R.string.ui_tabname_recipe));

        pictureFragment = new PictureFragment();
        recipeFragment = new RecipeFragment();

        pictureTab.setTabListener(new MyTabsListener(pictureFragment, getApplicationContext()));
        recipeTab.setTabListener(new MyTabsListener(recipeFragment, getApplicationContext()));

        actionBar.addTab(pictureTab);
        actionBar.addTab(recipeTab);

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

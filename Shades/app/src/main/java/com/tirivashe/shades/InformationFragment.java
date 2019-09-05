package com.tirivashe.shades;
import android.app.*;
import android.view.*;
import android.os.*;
import android.widget.*;

public class InformationFragment extends Fragment{

    public View onCreteView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.information_fragment,container,false);
        return view;
    }

    public void setText (String shadeInfo){
        TextView view = (TextView)getView().findViewById(R.id.textView);
        view.setText(shadeInfo);
    }
}

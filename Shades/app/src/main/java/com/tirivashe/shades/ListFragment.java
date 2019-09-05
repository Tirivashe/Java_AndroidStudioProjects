package com.tirivashe.shades;
import android.view.*;
import android.app.*;
import android.os.*;
import android.widget.*;

public class ListFragment extends Fragment {
    private OnItemSelectedListener listener;
    private String information;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstnceState){
        View view = inflater.inflate(R.layout.list_fragment, container, false);

        Button button1 = (Button)view.findViewById(R.id.button1);
        button1.setOnClickListener(ShadeChangeListener);

        Button button2 = (Button)view.findViewById(R.id.button2);
        button2.setOnClickListener(ShadeChangeListener);

        Button button3 = (Button)view.findViewById(R.id.button3);
        button3.setOnClickListener(ShadeChangeListener);

        return view;
    }

    private View.OnClickListener ShadeChangeListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String description = (String) getView().getContentDescription();
            information = description;
            updateDetail();
        }
    };

    public interface OnItemSelectedListener{
        public void onShadeItemSelected(String link);
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        if(activity instanceof OnItemSelectedListener){
            listener = (OnItemSelectedListener)activity;
        }else{
            throw new ClassCastException(activity.toString()+"must implement MyListFragment.OnItemSelectedListener");
        }
    }

    public void updateDetail(){
        listener.onShadeItemSelected(information);
    }
}
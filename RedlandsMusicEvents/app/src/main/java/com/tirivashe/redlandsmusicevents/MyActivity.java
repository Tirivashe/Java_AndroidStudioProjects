package com.tirivashe.redlandsmusicevents;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.util.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        if(savedInstanceState == null){
            getFragmentManager().beginTransaction().add(R.id.container, new MusicEventFragment()).commit();
        }
    }

    public static class MusicEventFragment extends Fragment{
        public MusicEventFragment(){
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
            String[] eventData = MusicEvents.data;
            List<String> seasonEvent = new ArrayList<String>(Arrays.asList(eventData));

            ArrayAdapter<String> musicEventAdapter = new ArrayAdapter<String>(getActivity(),R.layout.list_item_event, R.id.list_item_event_textView, seasonEvent);

            View rootView = inflater.inflate(R.layout.fragment_my, container,false);

            ListView listView = (ListView)rootView.findViewById(R.id.listView_event);
            listView.setAdapter(musicEventAdapter);
            return rootView;
        }
    }
}

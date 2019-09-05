package com.tirivashe.actionbarexperiment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.*;

public class SnackFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_snack, container,false);
    }
}

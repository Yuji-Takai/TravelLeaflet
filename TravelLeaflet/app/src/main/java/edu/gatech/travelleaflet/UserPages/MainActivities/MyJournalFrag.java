package edu.gatech.travelleaflet.UserPages.MainActivities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.gatech.travelleaflet.R;


public class MyJournalFrag extends Fragment {

    public MyJournalFrag() {
        // Required empty public constructor
    }

    public static MyJournalFrag newInstance() {
        MyJournalFrag fragment = new MyJournalFrag();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_journal, container, false);
    }

}

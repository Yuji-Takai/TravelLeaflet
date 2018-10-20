package edu.gatech.travelleaflet.UserPages.LeafletActivities;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.gatech.travelleaflet.R;

public class ScheduleFrag extends Fragment {

    public ScheduleFrag() {
        // Required empty public constructor
    }

    public static ScheduleFrag newInstance() {
        ScheduleFrag fragment = new ScheduleFrag();
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
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);




        return view;
    }

}

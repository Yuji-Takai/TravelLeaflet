package edu.gatech.travelleaflet.UserPages.LeafletActivities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.gatech.travelleaflet.R;


public class ExtraFrag extends Fragment {
    private String tripId;
    public ExtraFrag() {
        // Required empty public constructor
    }

    public static ExtraFrag newInstance(String tripId) {
        ExtraFrag fragment = new ExtraFrag();
        Bundle args = new Bundle();
        args.putString("tripId", tripId);
        fragment.setArguments(args);
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
        return inflater.inflate(R.layout.fragment_extra, container, false);
    }
}

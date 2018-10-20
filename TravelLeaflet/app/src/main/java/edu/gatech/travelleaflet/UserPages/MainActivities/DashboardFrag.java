package edu.gatech.travelleaflet.UserPages.MainActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;

import edu.gatech.travelleaflet.Models.User;
import edu.gatech.travelleaflet.R;
import edu.gatech.travelleaflet.UserPages.LeafletActivities.LeafletMainActivity;


public class DashboardFrag extends Fragment {
    public DashboardFrag() {
        // Required empty public constructor
    }

    public static DashboardFrag newInstance() {
        DashboardFrag fragment = new DashboardFrag();
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
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        FloatingActionButton addTripBtn = (FloatingActionButton) view.findViewById(R.id.addTripBtn);
        addTripBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LeafletMainActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }


}

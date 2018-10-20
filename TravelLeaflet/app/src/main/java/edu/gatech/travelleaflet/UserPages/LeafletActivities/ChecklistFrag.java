package edu.gatech.travelleaflet.UserPages.LeafletActivities;

import android.content.ClipData;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.travelleaflet.Models.Item;
import edu.gatech.travelleaflet.Models.Trip;
import edu.gatech.travelleaflet.R;

public class ChecklistFrag extends Fragment {

    public ChecklistFrag() {
        // Required empty public constructor
    }

    public static ChecklistFrag newInstance() {
        ChecklistFrag fragment = new ChecklistFrag();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_checklist, container, false);
        List<Item> checklist = ;

        ListView listView = (ListView) view.findViewById(R.id.checklist_listview);
        ItemAdapter listViewAdapter = new ItemAdapter(checklist ,getActivity());

        listView.setAdapter(listViewAdapter);
        // Inflate the layout for this fragment
        return view;
    }
}

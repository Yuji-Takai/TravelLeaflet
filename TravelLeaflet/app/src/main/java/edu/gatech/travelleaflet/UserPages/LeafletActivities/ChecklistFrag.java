package edu.gatech.travelleaflet.UserPages.LeafletActivities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.travelleaflet.Models.Item;
import edu.gatech.travelleaflet.R;



public class ChecklistFrag extends Fragment implements AddItem.OnItemListener{

    @Override
    public void sendItem(Item i) {
        checklist.add(i);
    }

    private Button addItem;
    private List<Item> checklist;


    public ChecklistFrag() {
        // Required empty public constructor
    }


    public static ChecklistFrag newInstance(String tripId) {
        ChecklistFrag fragment = new ChecklistFrag();
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
        View view = inflater.inflate(R.layout.fragment_checklist, container, false);
        checklist = new ArrayList<Item>();

        addItem = view.findViewById(R.id.addItem);
        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddItem dialog = new AddItem();
                dialog.show(getFragmentManager(), "Add Item");
            }
        });

        ListView listView = (ListView) view.findViewById(R.id.checklist_listview);
        ItemAdapter listViewAdapter = new ItemAdapter(checklist, getActivity());

        listView.setAdapter(listViewAdapter);
        // Inflate the layout for this fragment
        return view;
    }
}

package edu.gatech.travelleaflet.UserPages.LeafletActivities;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.travelleaflet.Models.Event;
import edu.gatech.travelleaflet.Models.Trip;
import edu.gatech.travelleaflet.R;

public class ScheduleFrag extends Fragment {
    private String tripId;
    // Firebase Related Instances
    private FirebaseDatabase mDatabase;
    private DatabaseReference mTripRef;

    private ListView scheduleField;

    public ScheduleFrag() {
        // Required empty public constructor
    }

    public static ScheduleFrag newInstance(String tripId) {
        ScheduleFrag fragment = new ScheduleFrag();
        Bundle args = new Bundle();
        args.putString("tripId", tripId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            tripId = getArguments().getString("tripId");
        } else {
            tripId = "";
        }

        setUpFirebase();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);
        scheduleField = (ListView) view.findViewById(R.id.eventListView);
        mTripRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Trip trip = dataSnapshot.getValue(Trip.class);
                List<Event> schedule = trip.getSchedule();
                if (schedule != null) {
                    ListAdapter adapter = new ArrayAdapter<>(getContext(), R.layout.fragment_schedule, R.id.eventListView, schedule);
                    scheduleField.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        return view;
    }

    /**
     * Sets up all the Firebase-related instances
     */
    private void setUpFirebase() {
        mDatabase = FirebaseDatabase.getInstance();
        mTripRef = mDatabase.getReference("trip").child(tripId);
    }

}

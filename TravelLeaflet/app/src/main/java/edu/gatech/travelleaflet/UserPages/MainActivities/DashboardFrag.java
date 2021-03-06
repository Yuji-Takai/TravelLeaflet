package edu.gatech.travelleaflet.UserPages.MainActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

<<<<<<< HEAD
=======
import com.google.firebase.auth.FirebaseAuth;
>>>>>>> 777731d788c0aee71c7df8bcfb4b9245e5a992f7
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

<<<<<<< HEAD
import java.util.ArrayList;

import edu.gatech.travelleaflet.Models.Trip;
=======
>>>>>>> 777731d788c0aee71c7df8bcfb4b9245e5a992f7
import edu.gatech.travelleaflet.Models.User;
import edu.gatech.travelleaflet.R;
import edu.gatech.travelleaflet.UserPages.LeafletActivities.AddEventActivity;
import edu.gatech.travelleaflet.UserPages.LeafletActivities.LeafletMainActivity;


public class DashboardFrag extends Fragment {
    public DashboardFrag() {
        // Required empty public constructor
    }

    ListView current_trips;
    FirebaseDatabase database;
    DatabaseReference ref;
    ArrayList<Trip> list;
    ArrayAdapter<Trip> adapter;

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
                FirebaseAuth mAuth = FirebaseAuth.getInstance();
                String uid = mAuth.getCurrentUser().getUid();
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference mUserRef = database.getReference("user");
                mUserRef.child(uid).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        User user = dataSnapshot.getValue(User.class);
                        Intent intent = new Intent(getActivity(), AddEventActivity.class);
                        intent.putExtra("tripCount", user.getTripCount());
                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        current_trips = (ListView) view.findViewById(R.id.current_trips);
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("user");
        list = new ArrayList<>();
        adapter = new ArrayAdapter<Trip>(this, R.layout.trip_info, R.id.trip_info, list);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds: dataSnapshot.getChildren()) {
                    User user = ds.getValue(User.class);
                    list = user.getTrips();
                }
                current_trips.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        return view;
    }




}

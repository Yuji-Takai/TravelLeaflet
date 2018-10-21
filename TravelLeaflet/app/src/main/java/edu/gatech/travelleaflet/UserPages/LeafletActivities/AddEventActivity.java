package edu.gatech.travelleaflet.UserPages.LeafletActivities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import edu.gatech.travelleaflet.Models.Trip;
import edu.gatech.travelleaflet.Models.User;
import edu.gatech.travelleaflet.R;
import edu.gatech.travelleaflet.UserPages.MainActivities.UserMainActivity;


public class AddEventActivity extends AppCompatActivity implements View.OnClickListener {
    // Firebase Related Instances
    private FirebaseAuth mAuth;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mUserRef;
    private DatabaseReference mTripRef;

    private String uid;

    private Button startDateBtn;
    private Button endDateBtn;
    private TextView startDateField;
    private TextView endDateField;
    private int mStartYear, mStartMonth, mStartDay, mEndYear, mEndMonth, mEndDay;

    private Button createBtn;
    private Button cancelBtn;
    private EditText cityField;

    private String city;
    private Date startDate;
    private Date endDate;

    private String tripId;

    final String TAG = "AddEventActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        setUpFirebase();
        findViewByIds();

        startDateBtn.setOnClickListener(this);
        endDateBtn.setOnClickListener(this);
        createBtn.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);

    }

    /**
     * Sets up all the Firebase-related instances
     */
    private void setUpFirebase() {
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance();
    }

    private void findViewByIds() {
        startDateBtn = (Button) findViewById(R.id.startDateBtn);
        endDateBtn = (Button) findViewById(R.id.endDateBtn);
        startDateField = (TextView) findViewById(R.id.startDateField);
        endDateField = (TextView) findViewById(R.id.endDateField);
        createBtn = (Button) findViewById(R.id.createBtn);
        cancelBtn = (Button) findViewById(R.id.cancelBtn);
        cityField = (EditText) findViewById(R.id.cityField);
    }

    @Override
    public void onClick(View view) {
        if (view == startDateBtn) {
            final Calendar c = Calendar.getInstance();
            mStartYear = c.get(Calendar.YEAR);
            mStartMonth = c.get(Calendar.MONTH);
            mStartDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            startDateField.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                        }
                    }, mStartYear, mStartMonth, mStartDay);
            datePickerDialog.show();
        } else if (view == endDateBtn) {
            final Calendar c = Calendar.getInstance();
            mEndYear = c.get(Calendar.YEAR);
            mEndMonth = c.get(Calendar.MONTH);
            mEndDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            endDateField.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                        }
                    }, mEndYear, mEndMonth, mEndDay);
            datePickerDialog.show();
        } else if (view == createBtn) {
            city = cityField.getText().toString();
            Calendar c = Calendar.getInstance();
            c.set(mStartYear, mStartMonth - 1, mStartDay);
            startDate = c.getTime();
            c.set(mEndYear, mEndMonth - 1, mEndDay);
            endDate = c.getTime();
            uid = mAuth.getCurrentUser().getUid();
            mUserRef = mDatabase.getReference("user").child(uid);
            mTripRef = mDatabase.getReference("trip");
            mUserRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    User user = dataSnapshot.getValue(User.class);
                    int tripcount = user.getTripCount();
                    String tripId = uid + "" + tripcount;
                    if (user.getTrips() == null) { user.setTrips(new ArrayList<String>()); }
                    user.addTrip(tripId);
                    user.addTripCount();
                    mUserRef.setValue(user);
                    mTripRef.child(tripId).setValue(new Trip(city, startDate, endDate, uid));
                    Intent intent = new Intent(getApplicationContext(), LeafletMainActivity.class);
                    intent.putExtra("tripId", tripId);
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });


        } else if (view == cancelBtn){
            Intent intent = new Intent(getBaseContext(), UserMainActivity.class);
            startActivity(intent);
        }
    }

}

package edu.gatech.travelleaflet.UserPages.LeafletActivities;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import edu.gatech.travelleaflet.Models.Item;
import edu.gatech.travelleaflet.R;

public class AddItem extends DialogFragment {

    private static final String TAG = "Add Item";

    public interface OnItemListener {
        void sendItem(Item i);
    }

    public OnItemListener mOnItemListener;

    private EditText mName;
    private EditText mCount;
    private Button mAdd;
    private Spinner mType;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_item, container, false);
        mAdd = view.findViewById(R.id.add_item_button);
        mName = view.findViewById(R.id.add_item_name);
        mCount = view.findViewById(R.id.add_item_count);
        mType = view.findViewById(R.id.item_type_spinner);

        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int type = mType.getSelectedItemPosition();
                String name = mName.getText().toString();
                int count = Integer.parseInt(mCount.getText().toString());
                Item i = new Item(type, name, count);
                if (!name.equals("")) {
                    mOnItemListener.sendItem(i);
                }
                getDialog().dismiss();
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mOnItemListener = (OnItemListener) getActivity();
        } catch (ClassCastException e) {

        }
    }
}
package edu.gatech.travelleaflet.UserPages.LeafletActivities;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.gatech.travelleaflet.R;

public class AlbumFrag extends Fragment {
    public AlbumFrag() {
        // Required empty public constructor
    }
    public static AlbumFrag newInstance() {
        AlbumFrag fragment = new AlbumFrag();
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
        return inflater.inflate(R.layout.fragment_album, container, false);
    }
}
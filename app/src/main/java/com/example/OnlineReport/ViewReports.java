package com.example.OnlineReport;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.example.OnlineReport.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class ViewReports extends Fragment {

    public ViewReports() {
    }

    private static final String TAG = "WriteReport";

    /**
     *  This retrieves the reports for the View Reports option
     *
     * @param inflater  The layout inflater class takes the layout XML file and builds the view object from it.
     * @param container This is the parent view that the fragment's UI should be attached to.
     * @param savedInstanceState    This fragment is re-constructed from this previous saved state.
     * @return The view
     *
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Toast.makeText(getActivity(), "In onCreateView", Toast.LENGTH_LONG).show();
        View root = inflater.inflate(R.layout.historicalreport, container, false);

        //get a reference to the database.
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

        /////////////////////////////
        Log.d(TAG, "about to addListenerForSingleValueEvent");
        mDatabase.child("Kilkenny").child("John").addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Get user value
                        //String test = dataSnapshot.getValue().toString();

                        //Toast.makeText(getActivity(), '9' + test, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                        Toast.makeText(getActivity(), "onCancelled ", Toast.LENGTH_LONG).show();
                    }

                });
////////////////////////////

        // Get site
        //declare our lat/longiude and the new FusedLocationProviderClient
        FusedLocationProviderClient mFusedLocationClient;


        return root;
    }



}

  //  public class getData{
        //DatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
    //    }
      //  }
//public void onDataChange(DataSnapshot dataSnapshot){
  //      for (DataSnapshot ds : dataSnapshot.getChildren()) {
    //    if (ds.getValue().equals("Kilkenny")) {
      //  }
        //}
        //}
        //}

    //public View onCreateView(LayoutInflater inflater, ViewGroup container,
    //                         Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        //View root = inflater.inflate(R.layout.historicalreport, container, false);

        //public void onClick (View) {
        /**
      //   * return a report from the database
        // *
         */
        //DatabaseReference = FirebaseDatabase.getInstance().getReference();
       //    @Override

   //     return root;
    //}
  //  }}
package com.example.OnlineReport;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;

import static android.content.Context.MODE_PRIVATE;

/**
 *
 */
// CreateNewReport fragment subclass
public class WriteReport extends Fragment {

    private Object View;

    public WriteReport() {
    }
    private static final String TAG = "WriteReport";

    /**
     * This loads and stores the'Write a new report' option
     *
     * @param inflater  The layout inflater class takes the layout XML file and builds the view object from it.
     * @param container This is the parent view that the fragment's UI should be attached to.
     * @param savedInstanceState this fragment is re-constructed from this previous saved state.
     * @return The view.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View root = inflater.inflate(R.layout.newreport, container, false);
        Log.e(TAG, "just inflated newreport");

        EditText edittext = root.findViewById(R.id.editText);
        String et = edittext.getText().toString();
        final EditText reporttext = edittext;

        //get a reference to the database.
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

/////////////////////////////
        Log.d(TAG, "about to addListenerForSingleValueEvent");
        mDatabase.child("Kilkenny").child("John").addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Get user value
                        String test = dataSnapshot.getValue().toString();

                        Toast.makeText(getActivity(), '9' + test, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
////////////////////////////
        FirebaseAuth mAuth;

        // Get the current date
        String currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());
        mAuth = FirebaseAuth.getInstance();
        String auth = mAuth.toString();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        Toast.makeText(getActivity(), '1' + auth, Toast.LENGTH_LONG).show();
        Toast.makeText(getActivity(), (CharSequence) currentUser, Toast.LENGTH_LONG).show();

        GetLocation gl = new GetLocation();
        GetLocation activity = (GetLocation) getActivity();
        String Address = gl.getMyData();           // from Stackoverfow    //non-static method getMydata() cannot be referenced from a static context
                                                    // => need to retrieve non-static method by attaching class object to it //geeksforgeeks.org

        //use SharedPreferences to get name from login
        SharedPreferences prefs = getActivity().getSharedPreferences("userdetails", MODE_PRIVATE);

        String name = prefs.getString("username", "");      // get the engineer's name using SharedPreferences

        mDatabase.child(Address).child(name).child(currentDateTimeString).setValue("ABC");  //Write the info to Firebase

        Toast.makeText(getActivity(), "test0" + name + "zz", Toast.LENGTH_SHORT).show();


        // test writing to the database - "Waterford.auth.currenttime.ABC"
        Log.d("WriteReport", "About to write to Firebase:" + "mDatabase.child(\"Waterford\").child(\"auth\").child(currentDateTimeString).setValue(\"GHI\")");
        mDatabase.child(Address).child(name).child(currentDateTimeString).setValue("ABC");
        Log.d("WriteReport", "value is:" + "JKL");
        Log.d("WriteReport", "value is:" + currentDateTimeString);
        //mDatabase.child("Site:Kilkenny").child("Name:John").child("Date:22-Apr-2020").setValue(et);
        Toast.makeText(getActivity(), '3' + "John).29-Jun-2020.XYZ", Toast.LENGTH_LONG).show();

         // Get the Save button
        Button button = root.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener()
        {
          /*  *//**
             * This method is used to store data in the database after it has been written to the screen
             * in the format Site.Engineer.CurrentDate.Report
             *
             * @param view view(button) that has been clicked
             */
            public void onClick(View view) {
                Toast.makeText(getActivity(), '4' + "button clicked", Toast.LENGTH_LONG).show();
                /*//**
                 * Get the report written to the editText and save it to the database, along with engineer's name, current date and site
                 */
                FirebaseAuth mAuth;
                //String User = FirebaseAuth.getInstance().getCurrentUser().getDisplayName();
                mAuth = FirebaseAuth.getInstance();
                String auth = mAuth.toString();

                String currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());
                String rt = reporttext.getText().toString();

                // Get the root of the Firebase database
                DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().getRoot();

                Log.d("Clicked", "value is:" + "site.engineer.timeanddate.YZA");
                mDatabase.child("site").child("engineer").child("timeanddate").setValue("YZA");
                mDatabase.child("Cork").child("test").child(currentDateTimeString).setValue("PQR");             }

            ;

        });

    return root;}}
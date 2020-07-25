package com.example.OnlineReport;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private EditText emailId;
    private EditText passwd;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(MainActivity.this.getApplicationContext(), "starting MainActivity",Toast.LENGTH_LONG
        ).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.ETemail);
        passwd = findViewById(R.id.ETpassword);
        Button btnSignUp = findViewById(R.id.btnSignUp);
        TextView signIn = findViewById(R.id.TVSignIn);

        //controls the button entries calls createAccount if the user wants to register
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailID = emailId.getText().toString();
                String paswd = passwd.getText().toString();
                if (emailID.isEmpty()) {
                    emailId.setError("Provide your Email first!");
                    emailId.requestFocus();
                } else if (paswd.isEmpty()) {
                    passwd.setError("Set your password");
                    passwd.requestFocus();
                } else {
                    //creates a new account
                    createAccount(emailID, paswd);
                }
            }
        });

        //simply opens the login if the user already has an account
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Login = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(Login);
            }
        });
    }

    /**
     * Checking here to makes sure the user hasn't already logged in
     */
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is already signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        Toast.makeText(MainActivity.this.getApplicationContext(), (CharSequence) mAuth.getCurrentUser(),Toast.LENGTH_LONG
                ).show();
        startActivity(new Intent(MainActivity.this, ReportActivity.class));
    }

    /**
     * Creates an account in firebase
     * @param emailID users Email
     * @param paswd users password
     */
    private void createAccount(String emailID, String paswd) {

        mAuth.createUserWithEmailAndPassword(emailID, paswd)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(MainActivity.this.getApplicationContext(),
                                    "SignUp unsuccessful: " + Objects.requireNonNull(task.getException()).getMessage(),
                                    Toast.LENGTH_SHORT).show();
                            updateGUI(null);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateGUI(user);
                        }
                    }
                });
        Toast.makeText(MainActivity.this, emailID, Toast.LENGTH_SHORT).show();
    }


    /*
      Currently this this updates the UI if the user already exists and is logged in
      (we can use this for other items as well if we wish.
      @param currentUser firebase user data
     */
    /**
     * Having successfully logged in the user is presented withe the option of the tabs for Viewing historical reports or writing a new report
     * @param currentUser Successfully logged in user
     */
    private void updateGUI(FirebaseUser currentUser) {
        if(currentUser != null) {
            Toast.makeText(MainActivity.this, ".....Reports", Toast.LENGTH_LONG).show();
            /**
             * Start activity where user can choose historical reports to view or write a new report
             */

        }
    }

}

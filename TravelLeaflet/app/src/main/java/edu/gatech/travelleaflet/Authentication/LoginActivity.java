package edu.gatech.travelleaflet.Authentication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import edu.gatech.travelleaflet.R;
import edu.gatech.travelleaflet.UserPages.UserDashboardActivity;

public class LoginActivity extends AppCompatActivity {
    // widgets
    private Button mLoginBtn;
    private EditText mEmailField;
    private EditText mPasswordField;
    private TextView mSignupField;

    // Firebase Related Declaration
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mUserRef;

    // Constants
    final String TAG = "SignInActivity";
    final int LOGIN = 0;
    final int SIGNUP = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setUpFirebase();

        mUser = mAuth.getCurrentUser();
        // Check if the user is signed in
        if (mUser != null) {
            // User is signed in so start the user's home activity
            updateUI(LOGIN);
        } else {
            // User is not signed in
            findViewByIds();

            // SignIn button
            mLoginBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    emailSignIn();
                }
            });

            // Create new account
            mSignupField.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) { updateUI(SIGNUP); }
            });
        }

    }

    /**
     * Sets up all the Firebase-related instances
     */
    private void setUpFirebase() {
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance();
        mUserRef = mDatabase.getReference("user");
    }

    /**
     * Initialize the views
     */
    private void findViewByIds() {
        mLoginBtn = (Button) findViewById(R.id.signinBtn);
        mEmailField = (EditText) findViewById(R.id.emailField);
        mPasswordField = (EditText) findViewById(R.id.passwordField);
        mSignupField = (TextView) findViewById(R.id.signUpField);
    }

    /**
     * Attempt to sign in the user using email and password authentication
     */
    private void emailSignIn() {
        String email = mEmailField.getText().toString();
        String password = mPasswordField.getText().toString();
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()) {
                    Log.d(TAG, "Email-password authentication failed");
                    Toast.makeText(LoginActivity.this, R.string.prompt_proper_auth_info,
                            Toast.LENGTH_LONG).show();
                } else {
                    updateUI(LOGIN);
                }
            }

        });

    }

    /**
     *
     * Updating the UI based on the sign in status
     * @param activity
     */
    private void updateUI(int activity) {
        if (activity == LOGIN) {
            Intent intent = new Intent(LoginActivity.this, UserDashboardActivity.class);
            startActivity(intent);
        } else if (activity == SIGNUP) {
            Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
            startActivity(intent);
        }

    }

}

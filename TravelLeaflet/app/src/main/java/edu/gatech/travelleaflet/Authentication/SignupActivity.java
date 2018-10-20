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

import edu.gatech.travelleaflet.Models.User;
import edu.gatech.travelleaflet.R;
import edu.gatech.travelleaflet.UserPages.UserDashboardActivity;

public class SignupActivity extends AppCompatActivity {
    // Widgets
    private EditText nameField;
    private EditText emailField;
    private EditText emailField2;
    private EditText passwordField;
    private EditText passwordField2;
    private Button completeBtn;
    private TextView signInPrompt;

    // Firebase Authentication related
    private FirebaseAuth mAuth;

    // Constants
    private final int PW_MIN_LENGTH = 8;
    private final String TAG = "SignUpActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        findViewByIds();
        completeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((checkName()) && (checkEmail()) && (checkPassword())) {
                    String email = emailField.getText().toString();
                    String password = passwordField.getText().toString();

                    mAuth = FirebaseAuth.getInstance();
                    // Attempting to create a new account based on the email and password provided
                    mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign Up Successful!
                                        Log.d(TAG, "Create User with Email: success");
                                        FirebaseUser mUser = mAuth.getCurrentUser();
                                        String uid = mUser.getUid();
                                        String name = nameField.getText().toString();
                                        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                                        DatabaseReference mUserRef = firebaseDatabase.getReference("user");
                                        // Adding the user to the database
                                        mUserRef.child(uid).setValue(new User(name));
                                        Intent intent = new Intent(SignupActivity.this, UserDashboardActivity.class);
                                        startActivity(intent);
                                    } else {
                                        // Sign Up Failed...
                                        Log.d(TAG, "Create User with Email: failure");
                                        Toast.makeText(SignupActivity.this, R.string.error_creating_new_account, Toast.LENGTH_LONG).show();
                                    }
                                }
                            }
                    );

                }
            }
        });
        signInPrompt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * Initialize the views
     */
    private void findViewByIds() {
        nameField = (EditText) findViewById(R.id.nameField);
        emailField = (EditText) findViewById(R.id.emailField);
        emailField2 = (EditText) findViewById(R.id.emailField2);
        passwordField = (EditText) findViewById(R.id.passwordField);
        passwordField2 = (EditText) findViewById(R.id.passwordField2);
        completeBtn = (Button) findViewById(R.id.completeBtn);
        signInPrompt = (TextView) findViewById(R.id.signInPrompt);
    }

    /**
     * Checks if the name input is valid
     * @return true if the name is valid
     */
    private boolean checkName() {
        String name = nameField.getText().toString();
        if (name.isEmpty()){
            Toast.makeText(SignupActivity.this, R.string.error_empty_name, Toast.LENGTH_LONG).show();
            return false;
        } else if (!name.contains(" ")) {
            Toast.makeText(SignupActivity.this, R.string.error_invalid_name, Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    /**
     * Checks if the email inputs are valid
     * @return true if no faults are discovered regarding the email inputs
     */
    private boolean checkEmail() {
        String emailInput = emailField.getText().toString();
        String emailInput2 = emailField2.getText().toString();
        if (emailInput.isEmpty() || emailInput2.isEmpty()) {
            Toast.makeText(SignupActivity.this, R.string.error_field_required, Toast.LENGTH_SHORT).show();
            return false;
        } else if (!emailInput.contains("@")) {
            Toast.makeText(SignupActivity.this, R.string.error_invalid_email, Toast.LENGTH_SHORT).show();
            return false;
        } else if (!emailInput.equals(emailInput2)) {
            Toast.makeText(SignupActivity.this, R.string.error_email_mismatch, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    /**
     * Checks if the password inputs are valid
     * @return true if no faults are discovered regarding the password inputs
     */
    private boolean checkPassword () {
        String pwInput = passwordField.getText().toString();
        String pwInput2 = passwordField2.getText().toString();
        if (pwInput.isEmpty() || pwInput2.isEmpty()) {
            Toast.makeText(SignupActivity.this, R.string.error_field_required, Toast.LENGTH_SHORT).show();
            return false;
        } else if (pwInput.length() <  PW_MIN_LENGTH) {
            Toast.makeText(SignupActivity.this, R.string.error_invalid_password, Toast.LENGTH_SHORT).show();
            return false;
        } else if (!pwInput.equals(pwInput2)) {
            Toast.makeText(SignupActivity.this, R.string.error_pw_mismatch, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}

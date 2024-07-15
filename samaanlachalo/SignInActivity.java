package com.example.samaanlachalo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInActivity extends AppCompatActivity {

    private static final String TAG = "TAG";
    SwitchCompat switchCompat;
    LoadingDialog loadingDialog;

    Button btnSignIn2;
    EditText userName, password;
    TextView tvForget;
    private GoogleSignInClient mGoogleSignInClient;
    private final static int RC_SIGN_IN = 123;
    private Task<Object> completedTask;
    private FirebaseAuth auth;
    FirebaseUser User;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        auth = FirebaseAuth.getInstance();
        User = auth.getCurrentUser();
        userName = findViewById(R.id.etUsername);
        password = findViewById(R.id.etPassword);
        btnSignIn2 = findViewById(R.id.btnSignIn2);
        tvForget = findViewById(R.id.tvForgot);
        loadingDialog = new LoadingDialog(SignInActivity.this);

        btnSignIn2.setOnClickListener(new View.OnClickListener() {

            class Handler {
                public void postDelayed(Runnable runnable, int i) {
                }

            }

            @Override
            public void onClick(View view) {
                String Email = userName.getText().toString().trim();
                String  Password = password.getText().toString().trim();

                Log.d(TAG, "onClick: email is "+Email);
                Log.d(TAG, "onClick: password is "+password);
                if (TextUtils.isEmpty(Email)) {
                    userName.setError("Please enter Email ID");
                    return;
                } else if (TextUtils.isEmpty(Password)) {
                    password.setError("Please enter Password");
                    return;
                }
                Intent intent = new Intent(SignInActivity.this, HomeActivity.class);
                startActivity(intent);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadingDialog.dismissDialog();
                    }
                }, 5000);


                auth.signInWithEmailAndPassword(Email, Password)
                        .addOnCompleteListener(SignInActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                        String EMAIL = userName.getText().toString().trim();


                                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                                        intent.putExtra("email", EMAIL);
                                        startActivity(intent);
                                    }
                                else {
                                        Toast.makeText(SignInActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                            GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                                    .requestEmail()
                                    .build();
                            mGoogleSignInClient = GoogleSignIn.getClient(SignInActivity.this, gso);
                            GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(SignInActivity.this);
                            updateUI(account);
                            signIn();

                            gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                                    .requestEmail()
                        .build();
                            mGoogleSignInClient = GoogleSignIn.getClient(SignInActivity.this, gso);
                            account = GoogleSignIn.getLastSignedInAccount(SignInActivity.this);
                            updateUI(account);


                        }

            private void signIn() {
                Intent signinintent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signinintent, RC_SIGN_IN);
            }

            private void updateUI(GoogleSignInAccount account) {
            }
        });
    }
}
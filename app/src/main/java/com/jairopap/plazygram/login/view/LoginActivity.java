package com.jairopap.plazygram.login.view;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthCredential;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.jairopap.plazygram.R;
import com.jairopap.plazygram.login.presenter.LoginPresenter;
import com.jairopap.plazygram.login.presenter.LoginPresenterImpl;
import com.jairopap.plazygram.view.ContainerActivity;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity  implements LoginView{

    private TextInputEditText username, password;
    private Button login;
    private LoginButton loginButtonFacebook;
    private ProgressBar progressbarLogin;
    private LoginPresenter presenter;
    private CallbackManager callbackManager;

    private static final String TAG ="LoginRepositoryImpl";
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener; //si alguine entra error algo el escuchcas


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();

        firebaseAuth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                if (firebaseUser != null){
                    Log.w(TAG, "Usuario Logeado" + firebaseUser.getEmail());
                    presenter.loginSuccess();
                }else{
                    Log.w(TAG, "Usuario no Logeado");

                }
            }
        };

        username = (TextInputEditText) findViewById(R.id.username);
        password = (TextInputEditText) findViewById(R.id.password);
        login    = (Button) findViewById(R.id.login);
        loginButtonFacebook    = (LoginButton) findViewById(R.id.login_facebook);
        progressbarLogin   = (ProgressBar) findViewById(R.id.progressbarLogin);
        hideProgresBar();

        presenter = new LoginPresenterImpl(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                singIn(username.getText().toString(), password.getText().toString());

                }
        });

        loginButtonFacebook.setReadPermissions(Arrays.asList("email"));
        loginButtonFacebook.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.w(TAG, "Facebook Login Sucees Token:" + loginResult.getAccessToken().getApplicationId());
                        singInFacebookFirebase(loginResult.getAccessToken());
                        presenter.loginSuccess();
            }

            @Override
            public void onCancel() {
                Log.w(TAG, "Facebook Login Cancelado Token:");
            }

            @Override
            public void onError(FacebookException error) {
                Log.w(TAG, "Facebook Login error Token:" + error.toString());
                error.printStackTrace();
            }
        });
    }

    private void singInFacebookFirebase(AccessToken accessToken) {
        Log.w(TAG, accessToken.getToken());
        AuthCredential authCredential = FacebookAuthProvider.getCredential(accessToken.getToken());

        firebaseAuth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Login Facebok Exitoso", Toast.LENGTH_SHORT).show();
                    presenter.loginSuccess();
                }else {
                    Toast.makeText(LoginActivity.this, "Login Facebok NO Exitoso FireBase", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void singIn(String username, String password) {
        presenter.singIn(username, password, this, firebaseAuth);
    }

    public void goCreateAccount(View view){
        goCreateAccount();
    }


    @Override
    public void enableInputs() {
        username.setEnabled(true);
        password.setEnabled(true);
        login.setEnabled(true);
    }

    @Override
    public void disableInputs() {
        username.setEnabled(false);
        password.setEnabled(false);
        login.setEnabled(false);
    }

    @Override
    public void showProgresBar() {
        progressbarLogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgresBar() {
        progressbarLogin.setVisibility(View.GONE);
    }

    @Override
    public void loginError(String error) {
        Toast.makeText(this, getString(R.string.login_error)+ error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void goCreateAccount() {
            Intent intent = new Intent(this, CreateAccountActivity.class);
            startActivity(intent);
        }

    @Override
    public void goHome() {

            Intent intent1 = new Intent(this, ContainerActivity.class);
            startActivity(intent1);
        }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        firebaseAuth.removeAuthStateListener(authStateListener);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}

package com.jairopap.plazygram;

import android.app.Application;
import android.support.annotation.NonNull;
import android.util.Log;

import com.facebook.FacebookSdk;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Administrador on 15/07/2017.
 */

public class PlazygramApplication extends Application {

    private FirebaseAuth firebaseAuth;
    private static final String TAG ="CreateAccountActivity";
    private FirebaseAuth.AuthStateListener authStateListener; //si alguine entra error algo el escuchcas

    @Override
    public void onCreate() {
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());

        firebaseAuth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                if (firebaseUser != null){
                    Log.w(TAG, "Usuario Logeado" + firebaseUser.getEmail());
                }else{
                    Log.w(TAG, "Usuario no Logeado");

                }
            }
        };
    }
}

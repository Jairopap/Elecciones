package com.jairopap.plazygram.login.Interactor;

import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Administrador on 02/07/2017.
 */

public interface LoginInteractor {
    void singIn(String username, String password, Activity activity, FirebaseAuth firebaseAuth);
}

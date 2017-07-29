package com.jairopap.plazygram.login.repository;

import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Administrador on 02/07/2017.
 */

public interface LoginRepository {
    void singIn(String username, String password,Activity activity,FirebaseAuth firebaseAuth);
}

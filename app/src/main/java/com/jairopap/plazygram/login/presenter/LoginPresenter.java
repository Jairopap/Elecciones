package com.jairopap.plazygram.login.presenter;

import android.app.Activity;
import android.view.View;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Administrador on 02/07/2017.
 */

public interface LoginPresenter {
    void singIn(String username, String password, Activity activity, FirebaseAuth firebaseAuth);//Interactor
    void loginSuccess();
    void loginError(String error);
  }

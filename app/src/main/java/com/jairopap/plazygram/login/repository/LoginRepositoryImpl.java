package com.jairopap.plazygram.login.repository;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.jairopap.plazygram.login.presenter.LoginPresenter;
import com.jairopap.plazygram.login.presenter.LoginPresenterImpl;

/**
 * Created by Administrador on 02/07/2017.
 */

public class LoginRepositoryImpl implements LoginRepository {

    LoginPresenter presenter;




    public LoginRepositoryImpl(LoginPresenter presenter){this.presenter = presenter;}

    @Override
    public void singIn(String username, String password, Activity activity, FirebaseAuth firebaseAuth) {
        firebaseAuth.signInWithEmailAndPassword(username, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            presenter.loginSuccess();
                        } else {
                            presenter.loginError("Ocurrio un Error");
                        }
                    }
                });

//        boolean success = true;
//        if (success) {
//            presenter.loginSuccess();
//
//        } else {
//            presenter.loginError("Ocurrio un Error");
//        }
    }
}

package com.jairopap.plazygram.login.repository;

import com.jairopap.plazygram.login.presenter.LoginPresenter;

/**
 * Created by Administrador on 02/07/2017.
 */

public class LoginRepositoreImpl implements LoginRepository {

    LoginPresenter presenter;


    @Override
    public void singIn(String username, String password) {
        boolean success = true;

        if(success){
            presenter.loginSuccess();

        }else {
            presenter.loginError("Ocurrio un Error");
    }
}

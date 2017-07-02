package com.jairopap.plazygram.login.repository;

import com.jairopap.plazygram.login.presenter.LoginPresenter;
import com.jairopap.plazygram.login.presenter.LoginPresenterImpl;

/**
 * Created by Administrador on 02/07/2017.
 */

public class LoginRepositoryImpl implements LoginRepository {

    LoginPresenter presenter;

    public LoginRepositoryImpl(LoginPresenter presenter){
        this.presenter = presenter;

    }

    @Override
    public void singIn(String username, String password) {
        boolean success = false;

        if (success) {
            presenter.loginSuccess();

        } else {
            presenter.loginError("Ocurrio un Error");
        }
    }
}
package com.jairopap.plazygram.login.Interactor;

import com.jairopap.plazygram.login.presenter.LoginPresenter;
import com.jairopap.plazygram.login.presenter.LoginPresenterImpl;

/**
 * Created by Administrador on 02/07/2017.
 */

public class LoginInteractorImpl implements LoginInteractor{

    private LoginPresenter presenter;

    public LoginPresenterImpl(LoginPresenter presenter){
        this.presenter =presenter;

    }

    @Override
    public void singIn(String username, String password) {

    }
}

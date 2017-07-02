package com.jairopap.plazygram.login.Interactor;

import com.jairopap.plazygram.login.presenter.LoginPresenter;
import com.jairopap.plazygram.login.presenter.LoginPresenterImpl;
import com.jairopap.plazygram.login.repository.LoginRepositoryImpl;
import com.jairopap.plazygram.login.repository.LoginRepository;

/**
 * Created by Administrador on 02/07/2017.
 */

public class LoginInteractorImpl implements LoginInteractor{

    private LoginPresenter presenter;
    private LoginRepository repository;

    public LoginInteractorImpl(LoginPresenter presenter){
        this.presenter =presenter;
        repository = new LoginRepositoryImpl(presenter);

    }

    @Override
    public void singIn(String username, String password) {
        repository.singIn(username, password);
    }
}

package com.jairopap.plazygram.login.presenter;

/**
 * Created by Administrador on 02/07/2017.
 */

public interface LoginPresenter {
    void singIn(String username, String password);//Interector
    void loginSuccess();
    void loginError(String error);

}

package com.jairopap.plazygram.login.view;

/**
 * Created by Administrador on 01/07/2017.
 */

public interface LoginView {

    void enableInputs();
    void disableInputs();

    void showProgresBar();
    void hideProgresBar();

    void loginError(String error);

    void goCreateAccount();
    void goHome();

}

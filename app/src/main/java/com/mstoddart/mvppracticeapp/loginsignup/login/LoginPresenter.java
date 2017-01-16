package com.mstoddart.mvppracticeapp.loginsignup.login;

import com.mstoddart.mvppracticeapp.utils.FieldValidationCallback;

/**
 * Created by MichaelApposing on 10/01/2017.
 */

public class LoginPresenter implements LoginContract.Presenter {

    private final LoginContract.View mLoginView;


    public LoginPresenter(LoginContract.View loginView){
        if(loginView != null) {
            mLoginView = loginView;
        } else {
            throw new RuntimeException();
        }

        mLoginView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void validateFields(FieldValidationCallback callback) {

    }
}

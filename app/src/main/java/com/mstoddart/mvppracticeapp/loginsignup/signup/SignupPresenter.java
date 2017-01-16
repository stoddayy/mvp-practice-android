package com.mstoddart.mvppracticeapp.loginsignup.signup;


import com.mstoddart.mvppracticeapp.utils.FieldValidationCallback;

/**
 * Created by MichaelApposing on 16/01/2017.
 */

public class SignupPresenter implements SignupContract.Presenter {

    private final SignupContract.View mSignupView;

    public SignupPresenter(SignupContract.View signupView) {
        if (signupView != null) {
            mSignupView = signupView;
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public void start() {

    }


    @Override
    public void validateSignupFields(String name, String email, String password, FieldValidationCallback callback) {
        if (name.length() > 0 && email.length() > 0 && password.length() > 0){
            callback.onSuccess();
        } else {
            callback.onFail(null);
        }
    }

    @Override
    public void saveUser() {

    }
}

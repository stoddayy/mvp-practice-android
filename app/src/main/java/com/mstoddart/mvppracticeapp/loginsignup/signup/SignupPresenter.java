package com.mstoddart.mvppracticeapp.loginsignup.signup;


import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import com.mstoddart.mvppracticeapp.data.User;
import com.mstoddart.mvppracticeapp.data.local.RealmController;
import com.mstoddart.mvppracticeapp.data.local.onRealmOperationCompleted;
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
        if (name.length() > 0 && email.length() > 0 && password.length() > 0) {
            callback.onSuccess();
        } else {
            callback.onFail(null);
        }
    }

    @Override
    public void saveUser(User user, Context mContext) {
        RealmController dbController = new RealmController(mContext);
        dbController.addUser(user, new onRealmOperationCompleted() {
            @Override
            public void onCompleted() {
                mSignupView.showToast("Sign up complete");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSignupView.navigateToPokemonActivity();
                    }
                }, Toast.LENGTH_SHORT);

            }
        });
    }
}

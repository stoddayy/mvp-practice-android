package com.mstoddart.mvppracticeapp.loginsignup.signup;

import android.content.Context;

import com.mstoddart.mvppracticeapp.BasePresenter;
import com.mstoddart.mvppracticeapp.BaseView;
import com.mstoddart.mvppracticeapp.data.User;
import com.mstoddart.mvppracticeapp.utils.FieldValidationCallback;

/**
 * Created by MichaelApposing on 16/01/2017.
 */

public interface SignupContract {

    interface View extends BaseView<Presenter> {

        void navigateToPokemonActivity();
        void showToast(String message);

    }

    interface Presenter extends BasePresenter {

        void validateSignupFields(String name, String email, String password, FieldValidationCallback callback);
        void saveUser(User user, Context mContext);

    }

}

package com.mstoddart.mvppracticeapp.loginsignup.signup;

import com.mstoddart.mvppracticeapp.BasePresenter;
import com.mstoddart.mvppracticeapp.BaseView;
import com.mstoddart.mvppracticeapp.utils.FieldValidationCallback;

/**
 * Created by MichaelApposing on 16/01/2017.
 */

public interface SignupContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {

        void validateSignupFields(String name, String email, String password, FieldValidationCallback callback);
        void saveUser();

    }

}

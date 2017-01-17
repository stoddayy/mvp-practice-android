package com.mstoddart.mvppracticeapp.loginsignup.login;


import com.mstoddart.mvppracticeapp.BasePresenter;
import com.mstoddart.mvppracticeapp.BaseView;
import com.mstoddart.mvppracticeapp.utils.FieldValidationCallback;

/**
 * Created by MichaelApposing on 10/01/2017.
 */

public interface LoginContract {


    /**
     * View alters any UI that the PRESENTER may need ie.
     * setTitle(), setDescription(), showProgressIndicator(), showErrorr(), showPopUp()
     */
    interface View extends BaseView<Presenter> {

        void switchToSignUp();
        void navigateToPokemonActivity();
        void showToast(String message);

    }

    /**
     * Presenter does work (Business logic) ie.
     * addTask(), saveTask(), makeAPICall(), validateFields()
     */
    interface Presenter extends BasePresenter {

        void validateLoginFields(String email, String Password, FieldValidationCallback callback);
        void checkUserExists();

    }

}

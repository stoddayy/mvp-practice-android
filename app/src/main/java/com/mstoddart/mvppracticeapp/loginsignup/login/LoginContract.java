package com.mstoddart.mvppracticeapp.loginsignup.login;

import android.widget.EditText;

import com.mstoddart.mvppracticeapp.BasePresenter;
import com.mstoddart.mvppracticeapp.BaseView;
import com.mstoddart.mvppracticeapp.utils.FieldValidationCallback;

/**
 * Created by MichaelApposing on 10/01/2017.
 */

public interface LoginContract {

    interface View extends BaseView<Presenter>{

        EditText getLoginEmailEt();
        EditText getLoginPasswordEt();

        void switchToSignUp();


    }

    interface Presenter extends BasePresenter{

        void validateFields(FieldValidationCallback callback);

    }

}

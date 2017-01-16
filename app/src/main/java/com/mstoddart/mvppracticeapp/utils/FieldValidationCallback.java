package com.mstoddart.mvppracticeapp.utils;

/**
 * Created by MichaelApposing on 16/01/2017.
 */

public interface FieldValidationCallback {

    void onSuccess();
    void onFail(String errorCode);

}

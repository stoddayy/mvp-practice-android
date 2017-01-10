package com.mstoddart.mvppracticeapp.data.remote;

/**
 * Created by MichaelApposing on 10/01/2017.
 */

public interface VolleySingletonListener<T> {
    void onResult(T object);
}
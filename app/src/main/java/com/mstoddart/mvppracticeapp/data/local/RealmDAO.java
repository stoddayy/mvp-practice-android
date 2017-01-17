package com.mstoddart.mvppracticeapp.data.local;

import com.mstoddart.mvppracticeapp.data.User;

import io.realm.RealmResults;

/**
 * Created by MichaelApposing on 16/01/2017.
 */

public interface RealmDAO {

    void addUser(User user, onRealmOperationCompleted mListener);
    User getUser(String email, onRealmOperationCompleted mListener);
    void getAllUsers(onRealmOperationCompleted mListener);

}

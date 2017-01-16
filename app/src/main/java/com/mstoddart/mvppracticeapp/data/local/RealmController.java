package com.mstoddart.mvppracticeapp.data.local;

import android.content.Context;

import com.mstoddart.mvppracticeapp.data.User;

import io.realm.Realm;

/**
 * Created by MichaelApposing on 10/01/2017.
 */

public class RealmController implements RealmDAO {

    Context mContext;

    public RealmController(Context mContext){
        Realm.init(mContext);
        this.mContext = mContext;
    }


    @Override
    public void addUser(final User user, final onRealmOperationCompleted mListener) {

        Realm realm = Realm.getDefaultInstance();

        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(user);
                mListener.onCompleted();
            }
        });
    }

    @Override
    public void getUser(String email, onRealmOperationCompleted mListener) {
        Realm realm = Realm.getDefaultInstance();
        User user = realm.where(User.class).equalTo(email.toLowerCase(), "email").findFirst();
        mListener.onCompleted(user);
    }

    @Override
    public void getAllUsers(onRealmOperationCompleted mListener) {

    }
}

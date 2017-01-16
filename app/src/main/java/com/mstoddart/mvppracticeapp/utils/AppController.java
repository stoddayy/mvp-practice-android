package com.mstoddart.mvppracticeapp.utils;

import android.app.Application;

import com.mstoddart.mvppracticeapp.data.remote.NetworkManager;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by MichaelApposing on 10/01/2017.
 */

public class AppController extends Application {

    protected static AppController instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        NetworkManager.getInstance(this);

    }
}
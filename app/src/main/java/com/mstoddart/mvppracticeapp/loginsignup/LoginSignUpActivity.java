package com.mstoddart.mvppracticeapp.loginsignup;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mstoddart.mvppracticeapp.R;

public class LoginSignUpActivity extends AppCompatActivity implements LoginSignupFragmentInteractionListener{

    private FragmentManager fragMan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sign_up);


        setupFrameLayout();
        setupFragManager();

        setLoginFrag();
    }

    private void setupFrameLayout(){

    }

    private void setupFragManager(){
        fragMan = getSupportFragmentManager();
    }


    @Override
    public void setLoginFrag() {

    }

    @Override
    public void setSignupFrag() {

    }

    @Override
    public void navigateToPokemonActivity() {

    }
}

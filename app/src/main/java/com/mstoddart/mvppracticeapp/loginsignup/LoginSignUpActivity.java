package com.mstoddart.mvppracticeapp.loginsignup;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.mstoddart.mvppracticeapp.R;
import com.mstoddart.mvppracticeapp.loginsignup.login.LoginFragment;
import com.mstoddart.mvppracticeapp.loginsignup.signup.SignupFragment;
import com.mstoddart.mvppracticeapp.pokemons.PokemonActivity;

public class LoginSignUpActivity extends AppCompatActivity implements LoginSignupFragmentInteractionListener{

    private FrameLayout flFragContainer;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sign_up);


        setupFrameLayout();
        setupFragManager();

        setLoginFrag();
    }

    private void setupFrameLayout(){
        flFragContainer = (FrameLayout) findViewById(R.id.fl_frag_container);
    }

    private void setupFragManager(){
        mFragmentManager = getSupportFragmentManager();
    }


    @Override
    public void setLoginFrag() {
        mTransaction = mFragmentManager.beginTransaction();
        mTransaction.replace(flFragContainer.getId(), LoginFragment.newInstance());
        mTransaction.commit();
    }

    @Override
    public void setSignupFrag() {
        mTransaction = mFragmentManager.beginTransaction();
        mTransaction.replace(flFragContainer.getId(), SignupFragment.newInstance());
        mTransaction.addToBackStack(null);
        mTransaction.commit();
    }

    @Override
    public void navigateToPokemonActivity() {
        Intent pokemonIntent = new Intent(this, PokemonActivity.class);
        startActivity(pokemonIntent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

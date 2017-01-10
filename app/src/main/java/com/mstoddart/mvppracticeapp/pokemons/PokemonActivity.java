package com.mstoddart.mvppracticeapp.pokemons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mstoddart.mvppracticeapp.R;

public class PokemonActivity extends AppCompatActivity implements PokemonFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void setPokeListFrag() {

    }

    @Override
    public void setPokeDetailFrag() {

    }
}

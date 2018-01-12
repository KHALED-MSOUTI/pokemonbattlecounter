package com.example.android.pokemonbattlecounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity  implements View.OnClickListener{

    //Creates the variables corresponding to the views.
    private LinearLayout mMewtwoRed, mZoroarkRed, mSylveonRed, mGengarRed;
    private LinearLayout mMewtwoBlue, mZoroarkBlue, mSylveonBlue, mGengarBlue;
    private Button mStartBattle;

    //Creates the two arrays in which the characteristics of the selected Pokemon will be stored.
    private static String redPokemon[] = new String[16];
    private static String bluePokemon[] = new String[16];

    private boolean teamRedSelected;
    private boolean teamBlueSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        mMewtwoRed = findViewById(R.id.mewtwoRed);
        mZoroarkRed = findViewById(R.id.zoroarkRed);
        mSylveonRed = findViewById(R.id.sylveonRed);
        mGengarRed = findViewById(R.id.gengarRed);
        mMewtwoBlue = findViewById(R.id.mewtwoBlue);
        mZoroarkBlue = findViewById(R.id.zoroarkBlue);
        mSylveonBlue = findViewById(R.id.sylveonBlue);
        mGengarBlue = findViewById(R.id.gengarBlue);
        mStartBattle = findViewById(R.id.startBattle);

        mMewtwoRed.setOnClickListener(this);
        mZoroarkRed.setOnClickListener(this);
        mSylveonRed.setOnClickListener(this);
        mGengarRed.setOnClickListener(this);
        mMewtwoBlue.setOnClickListener(this);
        mZoroarkBlue.setOnClickListener(this);
        mSylveonBlue.setOnClickListener(this);
        mGengarBlue.setOnClickListener(this);
        mStartBattle.setOnClickListener(this);

        teamRedSelected = false;
        teamBlueSelected = false;
    }

    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.mewtwoRed: {
                setRedPokemon(R.array.mewtwo, mMewtwoRed,
                        mZoroarkRed, mSylveonRed, mGengarRed);
                break;
            }
            case R.id.zoroarkRed: {
                setRedPokemon(R.array.zoroark, mZoroarkRed,
                        mSylveonRed, mGengarRed, mMewtwoRed);
                break;
            }
            case R.id.sylveonRed: {
                setRedPokemon(R.array.sylveon, mSylveonRed,
                        mGengarRed, mMewtwoRed, mZoroarkRed);
                break;
            }
            case R.id.gengarRed: {
                setRedPokemon(R.array.gengar, mGengarRed,
                        mMewtwoRed, mZoroarkRed, mSylveonRed);
                break;
            }
            case R.id.mewtwoBlue: {
                setBluePokemon(R.array.mewtwo, mMewtwoBlue,
                        mZoroarkBlue, mSylveonBlue, mGengarBlue);
                break;
            }
            case R.id.zoroarkBlue: {
                setBluePokemon(R.array.zoroark, mZoroarkBlue,
                        mSylveonBlue, mGengarBlue, mMewtwoBlue);
                break;
            }
            case R.id.sylveonBlue: {
                setBluePokemon(R.array.sylveon, mSylveonBlue,
                        mGengarBlue, mMewtwoBlue, mZoroarkBlue);
                break;
            }
            case R.id.gengarBlue: {
                setBluePokemon(R.array.gengar, mGengarBlue,
                        mMewtwoBlue, mZoroarkBlue, mSylveonBlue);
                break;
            }
            case R.id.startBattle: {
                startBattle();
                break;
            }
        }
    }

    /**
     * Method called to store the Pokemon selected by the Red player.
     * Changes the buttons' colors.
     * @param pokemonName
     * @param selected
     * @param notSelectedOne
     * @param notSelectedTwo
     * @param notSelectedThree
     */
    public void setRedPokemon(int pokemonName, LinearLayout selected, LinearLayout notSelectedOne,
                              LinearLayout notSelectedTwo, LinearLayout notSelectedThree) {
        redPokemon = getResources().getStringArray(pokemonName);
        teamRedSelected = true;

        selected.setBackground(getResources().getDrawable(R.drawable.red_team_selected));
        notSelectedOne.setBackground(getResources().getDrawable(R.drawable.red_team_button));
        notSelectedTwo.setBackground(getResources().getDrawable(R.drawable.red_team_button));
        notSelectedThree.setBackground(getResources().getDrawable(R.drawable.red_team_button));
    }

    /**
     * Method called to store the Pokemon selected by the Blue player.
     * Changes the buttons' colors.
     * @param pokemonName
     * @param selected
     * @param notSelectedOne
     * @param notSelectedTwo
     * @param notSelectedThree
     */
    public void setBluePokemon(int pokemonName, LinearLayout selected, LinearLayout notSelectedOne,
                               LinearLayout notSelectedTwo, LinearLayout notSelectedThree){
        bluePokemon =  getResources().getStringArray(pokemonName);
        teamBlueSelected = true;

        selected.setBackground(getResources().getDrawable(R.drawable.blue_team_selected));
        notSelectedOne.setBackground(getResources().getDrawable(R.drawable.blue_team_button));
        notSelectedTwo.setBackground(getResources().getDrawable(R.drawable.blue_team_button));
        notSelectedThree.setBackground(getResources().getDrawable(R.drawable.blue_team_button));
    }

    /**
     * Method called when the Battle button is clicked. Starts the Battle Activity.
     * Both player have to choose a Pokemon for the Activity to start.
     */
    public void startBattle() {
        if (teamRedSelected == true && teamBlueSelected == true) {
                startActivity(new Intent(this, BattleActivity.class));
        } else {
            //Message to show if the Battle button is clicked and less than two Pokemon are selected.
            Toast.makeText(this, R.string.startWarning, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Returns the Pokemon selected by the Red player.
     * @return
     */
    public static String[] returnRedPokemon(){
        return redPokemon;
    }

    /**
     * Returns the Pokemon selected by the Blue player.
     * @return
     */
    public static String[] returnBluePokemon(){
        return bluePokemon;
    }
}

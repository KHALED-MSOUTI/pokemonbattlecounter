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
    private LinearLayout mMewtwoRed, mZoroarkRed, mSylveonRed, mGengarRed, mNinetalesRed,
            mMimikyuRed, mGyaradosRed, mCharizardRed, mAmpharosRed, mSceptileRed;
    private LinearLayout mMewtwoBlue, mZoroarkBlue, mSylveonBlue, mGengarBlue, mNinetalesBlue,
    mMimikyuBlue, mGyaradosBlue, mCharizardBlue, mAmpharosBlue, mSceptileBlue;
    private Button mStartBattle;

    //Creates the two arrays in which the characteristics of the selected Pokemon will be stored.
    private static String redPokemon[] = new String[17];
    private static String bluePokemon[] = new String[17];

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
        mNinetalesRed = findViewById(R.id.ninetalesRed);
        mMimikyuRed = findViewById(R.id.mimikyuRed);
        mGyaradosRed = findViewById(R.id.gyaradosRed);
        mCharizardRed = findViewById(R.id.charizardRed);
        mAmpharosRed = findViewById(R.id.ampharosRed);
        mSceptileRed = findViewById(R.id.sceptileRed);

        mMewtwoBlue = findViewById(R.id.mewtwoBlue);
        mZoroarkBlue = findViewById(R.id.zoroarkBlue);
        mSylveonBlue = findViewById(R.id.sylveonBlue);
        mGengarBlue = findViewById(R.id.gengarBlue);
        mStartBattle = findViewById(R.id.startBattle);
        mNinetalesBlue = findViewById(R.id.ninetalesBlue);
        mMimikyuBlue = findViewById(R.id.mimikyuBlue);
        mGyaradosBlue = findViewById(R.id.gyaradosBlue);
        mCharizardBlue = findViewById(R.id.charizardBlue);
        mAmpharosBlue = findViewById(R.id.ampharosBlue);
        mSceptileBlue = findViewById(R.id.sceptileBlue);

        mMewtwoRed.setOnClickListener(this);
        mZoroarkRed.setOnClickListener(this);
        mSylveonRed.setOnClickListener(this);
        mGengarRed.setOnClickListener(this);
        mNinetalesRed.setOnClickListener(this);
        mMimikyuRed.setOnClickListener(this);
        mGyaradosRed.setOnClickListener(this);
        mCharizardRed.setOnClickListener(this);
        mAmpharosRed.setOnClickListener(this);
        mSceptileRed.setOnClickListener(this);

        mMewtwoBlue.setOnClickListener(this);
        mZoroarkBlue.setOnClickListener(this);
        mSylveonBlue.setOnClickListener(this);
        mGengarBlue.setOnClickListener(this);
        mNinetalesBlue.setOnClickListener(this);
        mMimikyuBlue.setOnClickListener(this);
        mGyaradosBlue.setOnClickListener(this);
        mCharizardBlue.setOnClickListener(this);
        mAmpharosBlue.setOnClickListener(this);
        mSceptileBlue.setOnClickListener(this);

        mStartBattle.setOnClickListener(this);

        teamRedSelected = false;
        teamBlueSelected = false;
    }

    /**
     * This method calls the other methods with the parameters corresponding
     * to the clicked button.
     * @param view
     */
    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.mewtwoRed: {
                setRedPokemon(R.array.mewtwo, mMewtwoRed,
                        mZoroarkRed, mSylveonRed, mGengarRed, mNinetalesRed, mMimikyuRed, mGyaradosRed, mCharizardRed, mAmpharosRed, mSceptileRed);
                break;
            }
            case R.id.zoroarkRed: {
                setRedPokemon(R.array.zoroark, mZoroarkRed,
                        mMewtwoRed, mSylveonRed, mGengarRed, mNinetalesRed, mMimikyuRed, mGyaradosRed, mCharizardRed, mAmpharosRed, mSceptileRed);
                break;
            }
            case R.id.sylveonRed: {
                setRedPokemon(R.array.sylveon, mSylveonRed,
                        mMewtwoRed, mZoroarkRed, mGengarRed, mNinetalesRed, mMimikyuRed, mGyaradosRed, mCharizardRed, mAmpharosRed, mSceptileRed);
                break;
            }
            case R.id.gengarRed: {
                setRedPokemon(R.array.gengar, mGengarRed,
                        mMewtwoRed, mZoroarkRed, mSylveonRed, mNinetalesRed, mMimikyuRed, mGyaradosRed, mCharizardRed, mAmpharosRed, mSceptileRed);
                break;
            }
            case R.id.ninetalesRed: {
                setRedPokemon(R.array.ninetalesAlola,  mNinetalesRed,
                        mMewtwoRed, mZoroarkRed, mSylveonRed, mGengarRed, mMimikyuRed, mGyaradosRed, mCharizardRed, mAmpharosRed, mSceptileRed);
                break;
            }
            case R.id.mimikyuRed: {
                setRedPokemon(R.array.mimikyu,  mMimikyuRed,
                        mMewtwoRed, mZoroarkRed, mSylveonRed, mGengarRed, mNinetalesRed, mGyaradosRed, mCharizardRed, mAmpharosRed, mSceptileRed);
                break;
            }
            case R.id.gyaradosRed: {
                setRedPokemon(R.array.gyarados,  mGyaradosRed,
                        mMewtwoRed, mZoroarkRed, mSylveonRed, mGengarRed, mNinetalesRed, mMimikyuRed, mCharizardRed, mAmpharosRed, mSceptileRed);
                break;
            }
            case R.id.charizardRed: {
                setRedPokemon(R.array.charizard,  mCharizardRed,
                        mMewtwoRed, mZoroarkRed, mSylveonRed, mGengarRed, mNinetalesRed, mMimikyuRed, mGyaradosRed, mAmpharosRed, mSceptileRed);
                break;
            }
            case R.id.ampharosRed: {
                setRedPokemon(R.array.ampharos, mAmpharosRed,
                        mMewtwoRed, mZoroarkRed, mSylveonRed, mGengarRed, mNinetalesRed, mMimikyuRed, mGyaradosRed, mCharizardRed, mSceptileRed);
                break;
            }
            case R.id.sceptileRed: {
                setRedPokemon(R.array.sceptile, mSceptileRed,
                        mMewtwoRed, mZoroarkRed, mSylveonRed, mGengarRed, mNinetalesRed, mMimikyuRed, mGyaradosRed, mCharizardRed, mAmpharosRed);
                break;
            }
            case R.id.mewtwoBlue: {
                setBluePokemon(R.array.mewtwo, mMewtwoBlue,
                        mZoroarkBlue, mSylveonBlue, mGengarBlue, mNinetalesBlue, mMimikyuBlue, mGyaradosBlue, mCharizardBlue, mAmpharosBlue, mSceptileBlue);
                break;
            }
            case R.id.zoroarkBlue: {
                setBluePokemon(R.array.zoroark, mZoroarkBlue,
                        mMewtwoBlue, mSylveonBlue, mGengarBlue, mNinetalesBlue, mMimikyuBlue, mGyaradosBlue, mCharizardBlue, mAmpharosBlue, mSceptileBlue);
                break;
            }
            case R.id.sylveonBlue: {
                setBluePokemon(R.array.sylveon, mSylveonBlue,
                        mMewtwoBlue, mZoroarkBlue, mGengarBlue, mNinetalesBlue, mMimikyuBlue, mGyaradosBlue, mCharizardBlue, mAmpharosBlue, mSceptileBlue);
                break;
            }
            case R.id.gengarBlue: {
                setBluePokemon(R.array.gengar, mGengarBlue,
                        mMewtwoBlue, mZoroarkBlue, mSylveonBlue, mNinetalesBlue, mMimikyuBlue, mGyaradosBlue, mCharizardBlue, mAmpharosBlue, mSceptileBlue);
                break;
            }
            case R.id.ninetalesBlue: {
                setBluePokemon(R.array.ninetalesAlola, mNinetalesBlue,
                        mMewtwoBlue, mZoroarkBlue, mSylveonBlue, mGengarBlue, mMimikyuBlue, mGyaradosBlue, mCharizardBlue, mAmpharosBlue, mSceptileBlue);
                break;
            }
            case R.id.mimikyuBlue: {
                setBluePokemon(R.array.mimikyu, mMimikyuBlue,
                        mMewtwoBlue, mZoroarkBlue, mSylveonBlue, mGengarBlue, mNinetalesBlue, mGyaradosBlue, mCharizardBlue, mAmpharosBlue, mSceptileBlue);
                break;
            }
            case R.id.gyaradosBlue: {
                setBluePokemon(R.array.gyarados, mGyaradosBlue,
                        mMewtwoBlue, mZoroarkBlue, mSylveonBlue, mGengarBlue, mNinetalesBlue, mMimikyuBlue, mCharizardBlue, mAmpharosBlue, mSceptileBlue);
                break;
            }
            case R.id.charizardBlue: {
                setBluePokemon(R.array.charizard, mCharizardBlue,
                        mMewtwoBlue, mZoroarkBlue, mSylveonBlue, mGengarBlue, mNinetalesBlue, mMimikyuBlue, mGyaradosBlue, mAmpharosBlue, mSceptileBlue);
                break;
            }
            case R.id.ampharosBlue: {
                setBluePokemon(R.array.ampharos, mAmpharosBlue,
                        mMewtwoBlue, mZoroarkBlue, mSylveonBlue, mGengarBlue, mNinetalesBlue, mMimikyuBlue, mGyaradosBlue, mCharizardBlue, mSceptileBlue);
                break;
            }
            case R.id.sceptileBlue: {
                setBluePokemon(R.array.sceptile, mSceptileBlue,
                        mMewtwoBlue, mZoroarkBlue, mSylveonBlue, mGengarBlue, mNinetalesBlue, mMimikyuBlue, mGyaradosBlue, mCharizardBlue, mAmpharosBlue);
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
                              LinearLayout notSelectedTwo, LinearLayout notSelectedThree,
                              LinearLayout notSelectedFour,  LinearLayout notSelectedFive,
                              LinearLayout notSelectedSix,  LinearLayout notSelectedSeven,
                              LinearLayout notSelectedEight,  LinearLayout notSelectedNine) {
        redPokemon = getResources().getStringArray(pokemonName);
        teamRedSelected = true;

        selected.setBackground(getResources().getDrawable(R.drawable.red_team_selected));
        notSelectedOne.setBackground(getResources().getDrawable(R.drawable.red_team_button));
        notSelectedTwo.setBackground(getResources().getDrawable(R.drawable.red_team_button));
        notSelectedThree.setBackground(getResources().getDrawable(R.drawable.red_team_button));
        notSelectedFour.setBackground(getResources().getDrawable(R.drawable.red_team_button));
        notSelectedFive.setBackground(getResources().getDrawable(R.drawable.red_team_button));
        notSelectedSix.setBackground(getResources().getDrawable(R.drawable.red_team_button));
        notSelectedSeven.setBackground(getResources().getDrawable(R.drawable.red_team_button));
        notSelectedEight.setBackground(getResources().getDrawable(R.drawable.red_team_button));
        notSelectedNine.setBackground(getResources().getDrawable(R.drawable.red_team_button));
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
                               LinearLayout notSelectedTwo, LinearLayout notSelectedThree,
                               LinearLayout notSelectedFour,  LinearLayout notSelectedFive,
                               LinearLayout notSelectedSix,  LinearLayout notSelectedSeven,
                               LinearLayout notSelectedEight,  LinearLayout notSelectedNine){
        bluePokemon =  getResources().getStringArray(pokemonName);
        teamBlueSelected = true;

        selected.setBackground(getResources().getDrawable(R.drawable.blue_team_selected));
        notSelectedOne.setBackground(getResources().getDrawable(R.drawable.blue_team_button));
        notSelectedTwo.setBackground(getResources().getDrawable(R.drawable.blue_team_button));
        notSelectedThree.setBackground(getResources().getDrawable(R.drawable.blue_team_button));
        notSelectedFour.setBackground(getResources().getDrawable(R.drawable.blue_team_button));
        notSelectedFive.setBackground(getResources().getDrawable(R.drawable.blue_team_button));
        notSelectedSix.setBackground(getResources().getDrawable(R.drawable.blue_team_button));
        notSelectedSeven.setBackground(getResources().getDrawable(R.drawable.blue_team_button));
        notSelectedEight.setBackground(getResources().getDrawable(R.drawable.blue_team_button));
        notSelectedNine.setBackground(getResources().getDrawable(R.drawable.blue_team_button));
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

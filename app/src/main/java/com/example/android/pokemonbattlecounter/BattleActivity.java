package com.example.android.pokemonbattlecounter;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class BattleActivity extends AppCompatActivity implements View.OnClickListener{

    //Creates the top views.
    private RelativeLayout mRedVisual, mBlueVisual;
    private ImageView mRedPokemonImage, mBluePokemonImage;
    private TextView mRedPokemonName, mBluePokemonName, mHpRed, mHpBlue;

    //Creates the views corresponding to the Pokemons' attacks.
    private LinearLayout mRedAttackOne, mRedAttackTwo, mRedAttackThree, mRedAttackFour;
    private LinearLayout mBlueAttackOne, mBlueAttackTwo, mBlueAttackThree, mBlueAttackFour;
    private ImageView mRedAtkOneImg, mRedAtkTwoImg, mRedAtkThreeImg, mRedAtkFourImg;
    private ImageView mBlueAtkOneImg, mBlueAtkTwoImg, mBlueAtkThreeImg, mBlueAtkFourImg;
    private TextView mRedAtkOneTxt, mRedAtkTwoTxt, mRedAtkThreeTxt, mRedAtkFourTxt;
    private TextView mBlueAtkOneTxt, mBlueAtkTwoTxt, mBlueAtkThreeTxt, mBlueAtkFourTxt;

    //Creates the arrays that get the Pokemons' stats from the Start Activity.
    private String[] redPokemon, bluePokemon;
    //Creates the variables in which are stored the hit points of the Pokemons.
    //It decreases every time the Pokemon receives an attack from its opponent.
    private int hpRedPokemon, hpBluePokemon;

    private boolean redTurn, blueTurn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Gets the values of the Pokemons selected on StartActivity.
        redPokemon = StartActivity.returnRedPokemon();
        bluePokemon = StartActivity.returnBluePokemon();

        setContentView(R.layout.activity_battle);

        //Finds the id of the graphic elements.
        mRedVisual = findViewById(R.id.visualRed);
        mBlueVisual = findViewById(R.id.visualBlue);
        mRedPokemonImage = findViewById(R.id.redPokemonImage);
        mBluePokemonImage = findViewById(R.id.bluePokemonImage);
        mRedPokemonName = findViewById(R.id.redPokemonName);
        mBluePokemonName = findViewById(R.id.bluePokemonName);
        mHpRed = findViewById(R.id.redHp);
        mHpBlue = findViewById(R.id.blueHp);

        //Finds the id of the attack buttons.
        mRedAttackOne = findViewById(R.id.redAttackOne);
        mRedAttackTwo = findViewById(R.id.redAttackTwo);
        mRedAttackThree = findViewById(R.id.redAttackThree);
        mRedAttackFour = findViewById(R.id.redAttackFour);
        mBlueAttackOne = findViewById(R.id.blueAttackOne);
        mBlueAttackTwo = findViewById(R.id.blueAttackTwo);
        mBlueAttackThree = findViewById(R.id.blueAttackThree);
        mBlueAttackFour = findViewById(R.id.blueAttackFour);

        //Finds the id of the images of the attacks' types.
        mRedAtkOneImg = findViewById(R.id.redAtkOneImg);
        mRedAtkTwoImg = findViewById(R.id.redAtkTwoImg);
        mRedAtkThreeImg = findViewById(R.id.redAtkThreeImg);
        mRedAtkFourImg = findViewById(R.id.redAtkFourImg);
        mBlueAtkOneImg = findViewById(R.id.blueAtkOneImg);
        mBlueAtkTwoImg = findViewById(R.id.blueAtkTwoImg);
        mBlueAtkThreeImg = findViewById(R.id.blueAtkThreeImg);
        mBlueAtkFourImg = findViewById(R.id.blueAtkFourImg);

        //Find the id of the attacks' names.
        mRedAtkOneTxt = findViewById(R.id.redAtkOneTxt);
        mRedAtkTwoTxt = findViewById(R.id.redAtkTwoTxt);
        mRedAtkThreeTxt = findViewById(R.id.redAtkThreeTxt);
        mRedAtkFourTxt = findViewById(R.id.redAtkFourTxt);
        mBlueAtkOneTxt = findViewById(R.id.blueAtkOneTxt);
        mBlueAtkTwoTxt = findViewById(R.id.blueAtkTwoTxt);
        mBlueAtkThreeTxt = findViewById(R.id.blueAtkThreeTxt);
        mBlueAtkFourTxt = findViewById(R.id.blueAtkFourTxt);

        mRedAttackOne.setOnClickListener(this);
        mRedAttackTwo.setOnClickListener(this);
        mRedAttackThree.setOnClickListener(this);
        mRedAttackFour.setOnClickListener(this);
        mBlueAttackOne.setOnClickListener(this);
        mBlueAttackTwo.setOnClickListener(this);
        mBlueAttackThree.setOnClickListener(this);
        mBlueAttackFour.setOnClickListener(this);

        String redPokemonImage = "@drawable/" + redPokemon[0].toLowerCase();
        String bluePokemonImage = "@drawable/" + bluePokemon[0].toLowerCase();

        String redAtkOneImg = "@drawable/" + redPokemon[6].toLowerCase();
        String redAtkTwoImg = "@drawable/" + redPokemon[9].toLowerCase();
        String redAtkThreeImg = "@drawable/" + redPokemon[12].toLowerCase();
        String redAtkFourImg = "@drawable/" + redPokemon[15].toLowerCase();
        String blueAtkOneImg = "@drawable/" + bluePokemon[6].toLowerCase();
        String blueAtkTwoImg = "@drawable/" + bluePokemon[9].toLowerCase();
        String blueAtkThreeImg = "@drawable/" + bluePokemon[12].toLowerCase();
        String blueAtkFourImg = "@drawable/" + bluePokemon[15].toLowerCase();

        mRedPokemonImage.setImageResource(this.getResources().getIdentifier(redPokemonImage, "drawable", this.getPackageName()));
        mBluePokemonImage.setImageResource(this.getResources().getIdentifier(bluePokemonImage, "drawable", this.getPackageName()));

        mRedAtkOneImg.setImageResource(this.getResources().getIdentifier(redAtkOneImg, "drawable", this.getPackageName()));
        mRedAtkTwoImg.setImageResource(this.getResources().getIdentifier(redAtkTwoImg, "drawable", this.getPackageName()));
        mRedAtkThreeImg.setImageResource(this.getResources().getIdentifier(redAtkThreeImg, "drawable", this.getPackageName()));
        mRedAtkFourImg.setImageResource(this.getResources().getIdentifier(redAtkFourImg, "drawable", this.getPackageName()));
        mBlueAtkOneImg.setImageResource(this.getResources().getIdentifier(blueAtkOneImg, "drawable", this.getPackageName()));
        mBlueAtkTwoImg.setImageResource(this.getResources().getIdentifier(blueAtkTwoImg, "drawable", this.getPackageName()));
        mBlueAtkThreeImg.setImageResource(this.getResources().getIdentifier(blueAtkThreeImg, "drawable", this.getPackageName()));
        mBlueAtkFourImg.setImageResource(this.getResources().getIdentifier(blueAtkFourImg, "drawable", this.getPackageName()));

        //On the first turn, every player can start the battle.
        redTurn = true;
        blueTurn = true;

        //Initial amount of HP for each Pokemon.
        hpRedPokemon = Integer.parseInt(redPokemon[2]);
        hpBluePokemon = Integer.parseInt(bluePokemon[2]);

        //Displays the name and the initial amount of HP for each Pokemon.
        mRedPokemonName.setText(redPokemon[0]);
        mBluePokemonName.setText(bluePokemon[0]);
        mHpRed.setText(redPokemon[2]);
        mHpBlue.setText(bluePokemon[2]);

        //Displays the name of the attacks.
        mRedAtkOneTxt.setText(redPokemon[5]);
        mRedAtkTwoTxt.setText(redPokemon[8]);
        mRedAtkThreeTxt.setText(redPokemon[11]);
        mRedAtkFourTxt.setText(redPokemon[14]);
        mBlueAtkOneTxt.setText(bluePokemon[5]);
        mBlueAtkTwoTxt.setText(bluePokemon[8]);
        mBlueAtkThreeTxt.setText(bluePokemon[11]);
        mBlueAtkFourTxt.setText(bluePokemon[14]);

    }

    /**
     * This method calls the attack method with the parameters corresponding
     * to the clicked button.
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.redAttackOne: {
                if(redTurn) {
                    attack(redPokemon, bluePokemon, 1);
                }
                break;
            }
            case R.id.redAttackTwo: {
                if(redTurn) {
                    attack(redPokemon, bluePokemon, 2);
                }
                break;
            }
            case R.id.redAttackThree: {
                if(redTurn) {
                    attack(redPokemon, bluePokemon, 3);
                }
                break;
            }
            case R.id.redAttackFour: {
                if(redTurn) {
                    attack(redPokemon, bluePokemon, 4);
                }
                break;
            }
            case R.id.blueAttackOne: {
                if(blueTurn) {
                    attack(bluePokemon, redPokemon, 1);
                }
                break;
            }
            case R.id.blueAttackTwo: {
                if(blueTurn) {
                    attack(bluePokemon, redPokemon, 2);
                }
                break;
            }
            case R.id.blueAttackThree: {
                if(blueTurn) {
                    attack(bluePokemon, redPokemon, 3);
                }
                break;
            }
            case R.id.blueAttackFour: {
                if(blueTurn) {
                    attack(bluePokemon, redPokemon, 4);
                }
                break;
            }
        }
    }

    /**
     * This method is used when an attack button is clicked.
     * It uses the methods : checkStab, checkWeakness and checkCriticalHit.
     * @param attacker //The Pokemon who attacks.
     * @param defender //The Pokemon who receives the damages.
     * @param atkNumber //The number of the clicked attack.
     */
    public void attack(String[] attacker, String[] defender, int atkNumber){

        //Characteristics of the attacking Pokemon.
        String attackerName = attacker[0];
        String attackerType = attacker[1];
        int attackValue = Integer.parseInt(attacker[3]);

        //Characteristics of the defending Pokemon.
        String defenderName = defender[0];
        String defenderType = defender[1];
        int defenseValue = Integer.parseInt(defender[4]);

        //Initialization of the attack used.
        String attackType = getString(R.string.normal);
        int attackPower = 0;

        //The type and power of the attack depends on the clicked button.
        if(atkNumber == 1) {
            attackType =attacker[6];
            attackPower =Integer.parseInt(attacker[7]);
        }else if(atkNumber == 2) {
            attackType =attacker[9];
            attackPower =Integer.parseInt(attacker[10]);
        }else if(atkNumber == 3) {
            attackType =attacker[12];
            attackPower =Integer.parseInt(attacker[13]);
        }else if(atkNumber == 4) {
            attackType =attacker[15];
            attackPower =Integer.parseInt(attacker[16]);
        }

        //Sets the different multipliers used in the calculation of the damages.
        double stab = checkStab(attackerType, attackType);
        double weakness = checkWeakness(defenderType, attackType);
        double critical = criticalHit();
        double randomValue = setRandomValue();

        //Calcul of the amount of damages.
        int hpLost = (int) Math.round(((((50 * 2 / 5 + 2) * attackValue * attackPower) / (defenseValue * 50)) + 2)
                * stab * weakness * critical * randomValue);

        //Actions if the Red Pokemon attacks.
        if(attacker == redPokemon) {
            hpBluePokemon -= hpLost;
            if(hpBluePokemon < 0) {
                hpBluePokemon = 0;
            }
            mHpBlue.setText(String.valueOf(hpBluePokemon));
            redTurn = false;
            blueTurn = true;
            mRedVisual.setBackgroundColor(getResources().getColor(R.color.transparent));
            mBlueVisual.setBackgroundColor(getResources().getColor(R.color.blueTransparent));

        //Actions if the Blue Pokemon attacks.
        } else if(attacker == bluePokemon){
            hpRedPokemon -= hpLost;
            if(hpRedPokemon < 0) {
                hpRedPokemon = 0;
            }
            mHpRed.setText(String.valueOf(hpRedPokemon));
            blueTurn = false;
            redTurn = true;
            mBlueVisual.setBackgroundColor(getResources().getColor(R.color.transparent));
            mRedVisual.setBackgroundColor(getResources().getColor(R.color.redTransparent));
        }

        //Final message of the turn.
        String message = "";
        if(critical == 1.5) {
            message += getString(R.string.critical);
        }
        if(weakness == 0) {
            message += getString(R.string.immunity);
        }else if(weakness == 0.5) {
            message += getString(R.string.resistance);
        }else if(weakness == 2) {
            message += getString(R.string.weakness);
        }
        message += attackerName + getString(R.string.inflicted) + String.valueOf(hpLost) + getString(R.string.damages) + defenderName;
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();

        //Alert dialog when a Pokemon is k.o.
        AlertDialog.Builder dialog = new AlertDialog.Builder(this)
                .setCancelable(false)
                .setPositiveButton(getString(R.string.back), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        startActivity(new Intent(BattleActivity.this, StartActivity.class));
                    }
                });

        //Alert dialog if Blue wins.
        if(hpRedPokemon == 0) {
            dialog.setMessage(getString(R.string.congratulations) + redPokemon[0] + getString(R.string.blueWon));
            AlertDialog alert = dialog.create();
            alert.show();

        //Alert dialog if Red wins.
        }else if(hpBluePokemon == 0) {
            dialog.setMessage(getString(R.string.congratulations) + bluePokemon[0] + getString(R.string.redWon));
            AlertDialog alert = dialog.create();
            alert.show();
        }
    }

    /**
     * Stab : If the attacker's type is the same as it's attack, their is a 1.5 multiplier.
     * @param attackerType
     * @param attackType
     * @return
     */
    public double checkStab(String attackerType, String attackType){
        double stab = 1;
        if(attackerType.equals(attackType)) {
            stab = 1.5;
        }
        return stab;
    }

    /**
     * Weakness : Depending on the Types affinity, the efficiency of the attack can vary
     * from 0 (Immunity) to 0.5 (Resistance) to 1 (Normal) to 2 (Weakness).
     * @param defenderType
     * @param attackType
     * @return
     */
    public double checkWeakness(String defenderType, String attackType){
        double weakness = 1;

        //Psychic weakness.
        if(defenderType.equals(getString(R.string.psychic))) {
            if(attackType.equals(getString(R.string.ghost)) || attackType.equals(getString(R.string.dark))) {
                weakness = 2;
            } else if(attackType.equals(getString(R.string.fight)) || attackType.equals(getString(R.string.psychic))) {
                weakness = 0.5;
            }
        }

        //Dark weakness.
        if(defenderType.equals(getString(R.string.dark))) {
            if(attackType.equals(getString(R.string.fight))) {
                weakness = 2;
            } else if(attackType.equals(getString(R.string.ghost)) || attackType.equals(getString(R.string.dark))) {
                weakness = 0.5;
            } else if(attackType.equals(getString(R.string.psychic))) {
                weakness = 0;
            }
        }
        //Fairy weakness.
        if(defenderType.equals(getString(R.string.fairy))) {
            if(attackType.equals(getString(R.string.poison)) || attackType.equals(getString(R.string.steel))) {
                weakness = 2;
            } else if(attackType.equals(getString(R.string.fight)) || attackType.equals(getString(R.string.dark))) {
                weakness = 0.5;
            }
        }
        //Poison weakness.
        if(defenderType.equals(getString(R.string.poison))) {
            if(attackType.equals(getString(R.string.psychic))) {
                weakness = 2;
            } else if(attackType.equals(getString(R.string.poison)) || attackType.equals(getString(R.string.fight))
                    || attackType.equals(getString(R.string.fairy))) {
                weakness = 0.5;
            }
        }

        return weakness;
    }

    /**
     * The Pokemon has 1 chance in 16 to do a critical hit, which multiplies the damages by 1.5.
     * (Damages x2 have been changed to damages x1.5 since the 6th generation).
     * @return
     */
    public double criticalHit(){
        double critical = 1;
        Random random = new Random();
        int criticalchance = random.nextInt(17 - 1) + 1;
        if(criticalchance == 1) {
            critical = 1.5;
        }

        return critical;
    }

    /**
     * Every attack has a part of randomness.
     * This method returns a multiplier from 0.8 to 1.
     * @return
     */
    public double  setRandomValue(){
        Random random = new Random();
        double randomValue = (double) (random.nextInt(101 - 80) + 80) / 100;
        return randomValue;
    }
}

package com.fessard.guillaume.topquiz.controller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.fessard.guillaume.topquiz.R;
import com.fessard.guillaume.topquiz.model.PowerbyActivity;
import com.fessard.guillaume.topquiz.model.User;

import java.io.PrintStream;

import static java.lang.System.out;

public class MainActivity extends AppCompatActivity {

    private TextView mGreetingText;
    private EditText mNameInput;
    private Button mPlayButton;
    private Button mCreditButton;
    private User mUser;
    public static final int GAME_ACTIVITY_REQUEST_CODE = 42;
    private SharedPreferences mPreferences;

    public static final String PREF_KEY_SCORE = "PREF_KEY_SCORE";
    public static final String PREF_KEY_FIRSTNAME = "PREF_KEY_FIRSTNAME";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mUser = new User();
        mPreferences = getPreferences(MODE_PRIVATE);
        mGreetingText = (TextView) findViewById(R.id.editText);
        mNameInput = (EditText) findViewById(R.id.editText2);
        mPlayButton = (Button) findViewById(R.id.activity_main_play_btn);
        mCreditButton = (Button) findViewById(R.id.activity_credit_btn);


        mPlayButton.setEnabled(false);

        mNameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPlayButton.setEnabled(s.toString().length() != 0);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //utiliser pour save les nom d'utilisateur
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname = mNameInput.getText().toString(); //récuprer le prénom
                mUser.setFirstname(firstname);
                //user appui sur le boutton


                mPreferences.edit().putString("PREF_KEY_FIRSTNAME", mUser.getFirstname()).apply();

                Intent gameActivityIntent = new Intent(MainActivity.this, Gameactivity.class);
                startActivityForResult(gameActivityIntent, GAME_ACTIVITY_REQUEST_CODE);
            }


        });

        mCreditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent powerbyactivity = new Intent(MainActivity.this, PowerbyActivity.class);
                startActivity(powerbyactivity);
            }
        });

    }







    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (GAME_ACTIVITY_REQUEST_CODE == requestCode && RESULT_OK == resultCode) {
            // Fetch the score from the Intent
            int score = data.getIntExtra(Gameactivity.BUNDLE_EXTRA_SCORE, 0);

            mPreferences.edit().putInt(PREF_KEY_SCORE, score).apply();

            greetUser();
        }
    }

    private void greetUser() {
        String firstname = mPreferences.getString("PREF_KEY_FIRSTNAME", null);

        if (null != firstname) {
            int score = mPreferences.getInt(PREF_KEY_SCORE, 0);

            String fulltext = "Bonjour " + firstname
                    + "\nTon score précédent était " + score;

            mGreetingText.setText(fulltext);
            mNameInput.setText(firstname);
            mNameInput.setSelection(firstname.length());
            mPlayButton.setEnabled(true);
        }
    }

}

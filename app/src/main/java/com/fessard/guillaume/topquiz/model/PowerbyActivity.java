package com.fessard.guillaume.topquiz.model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.fessard.guillaume.topquiz.R;

public class PowerbyActivity extends AppCompatActivity {

    private TextView mTextcreat;
    private TextView mTextquestion;
    private TextView mTextfin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_powerby2);

        mTextcreat = (TextView) findViewById(R.id.activity_game_text_createur);
        mTextfin = (TextView) findViewById(R.id.activity_text_fin);
        mTextquestion = (TextView) findViewById(R.id.activity_text_createur_question);
    }
}

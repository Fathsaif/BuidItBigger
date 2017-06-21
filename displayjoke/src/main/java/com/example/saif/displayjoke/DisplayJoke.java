package com.example.saif.displayjoke;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Saif on 21/06/2017.
 */

public class DisplayJoke extends AppCompatActivity {
    TextView jokeTv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);
        Intent intent = getIntent();
        String joke = intent.getStringExtra("Joke");

        jokeTv = (TextView)findViewById(R.id.joke_text);
        jokeTv.setText(joke);
    }
}

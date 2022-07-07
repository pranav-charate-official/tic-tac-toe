package com.example.tic_tac_toe;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Player Representation
    // 0 ~ X
    // 1 ~ O
    // 2 ~ Blank

    int activePlayer = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][] winPos = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}
    };

    TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvStatus = findViewById(R.id.tvStatus);

    }


    public void onTap(View view) {
        ImageView iVTapped = (ImageView) view;
        int tappedImg = Integer.parseInt(iVTapped.getTag().toString());

        if (gameState[tappedImg] == 2) {
            gameState[tappedImg] = activePlayer;

            iVTapped.setTranslationX(-1000f);

            if (activePlayer == 0) {
                iVTapped.setImageResource(R.drawable.tic_x);
                activePlayer = 1;
                tvStatus.setText("O's turn : Tap to play");
            } else {
                iVTapped.setImageResource(R.drawable.tic_o);
                activePlayer = 0;
                tvStatus.setText("X's turn : Tap to play");
            }

            iVTapped.animate().translationXBy(1000f).setDuration(300);
        }

        for (int[] winpos : winPos) {
            if(     gameState[winpos[0]] == gameState[winpos[1]] &&
                    gameState[winpos[1]] == gameState[winpos[2]] &&
                    gameState[winpos[0]] != 2   ) {

                //somebody won
            }
        }
    }
}
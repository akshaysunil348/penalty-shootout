package com.example.penaltyshootout;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
public class MainActivity extends AppCompatActivity {
    private Button leftButton, topButton, rightButton, resetButton;
    private TextView scoredTextView, savedTextView;
    private ImageView footballImageView, goalpostImageView, imageView;
    private Random random = new Random();
    private int score = 0;
    private int saved = 0;
    private MediaPlayer mediaPlayer, mediaPlayer1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        leftButton = findViewById(R.id.button);
        topButton = findViewById(R.id.button2);
        rightButton = findViewById(R.id.button3);
        resetButton = findViewById(R.id.button4);
        scoredTextView = findViewById(R.id.editTextText);
        savedTextView = findViewById(R.id.editTextText2);
        footballImageView = findViewById(R.id.imageView3);
        goalpostImageView = findViewById(R.id.imageView2);
        imageView = findViewById(R.id.imageView);
        mediaPlayer = MediaPlayer.create(this, R.raw.goal_sound);
        mediaPlayer1 = MediaPlayer.create(this, R.raw.jump_sound);


        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomShot = random.nextInt(3) + 1;
                if (randomShot == 1) {
                    // Shot saved
                    saved++;
                    animateKeeperLeft();
                    animateGoalleft();
                    mediaPlayer1.start();
                    savedTextView.setText("Saved: " + saved);
                } else {
                    // Goal

                    animateGoalleft();
                    if (randomShot==2){
                        animateKeeperTop();
                    } else if (randomShot==3) {
                        animateKeeperRight();
                    }

                    score++;
                    scoredTextView.setText("Scored: " + score);
                    mediaPlayer.start();
                    Toast.makeText(getApplicationContext(), "suuiii", Toast.LENGTH_SHORT).show();

                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
                                }
                            },
                            2000
                    );
                }
            }
        });

        topButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomShot = random.nextInt(3) + 1;
                if (randomShot == 2) {
                    saved++;
                    animateGoaltop();
                    animateKeeperTop();
                    mediaPlayer1.start();
                    savedTextView.setText("Saved: " + saved);
                } else {
                    animateGoaltop();
                    if (randomShot==1){
                        animateKeeperLeft();
                    } else if (randomShot==3) {
                        animateKeeperRight();
                    }
                    score++;
                    scoredTextView.setText("Scored: " + score);
                    mediaPlayer.start();
                    Toast.makeText(getApplicationContext(), "suuiii!!", Toast.LENGTH_SHORT).show();

                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
                                }
                            },
                            2000
                    );
                }
            }
        });

        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomShot = random.nextInt(3) + 1;
                if (randomShot == 3) {
                    saved++;
                    animateKeeperRight();
                    animateGoal();
                    mediaPlayer1.start();
                    savedTextView.setText("Saved: " + saved);
                } else {
                    animateGoal();
                    if (randomShot==2){
                        animateKeeperTop();
                    } else if (randomShot==1) {
                        animateKeeperLeft();
                    }
                    score++;
                    scoredTextView.setText("Scored: " + score);
                    mediaPlayer.start();
                    Toast.makeText(getApplicationContext(), "suuiii", Toast.LENGTH_SHORT).show();

                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
                                }
                            },
                            2000
                    );
                }
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score = 0;
                saved = 0;
                scoredTextView.setText("Scored: " + score);
                savedTextView.setText("Saved: " + saved);
                resetGoalAnimation();
            }
        });

    }

    private void animateGoal() {

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.goal_animation);
        footballImageView.startAnimation(animation);
    }
    private void animateGoalleft() {

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.goal_left);
        footballImageView.startAnimation(animation);
    }
    private void animateGoaltop() {

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.goal_top);
        footballImageView.startAnimation(animation);
    }
    private void animateKeeperLeft() {

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.keeper_animate_left);
        imageView.startAnimation(animation);
    }
    private void animateKeeperRight() {

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.keeper_animate_right);
        imageView.startAnimation(animation);
    }
    private void animateKeeperTop() {

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.keeper_animate_top);
        imageView.startAnimation(animation);
    }
    private void resetGoalAnimation() {
            }
}

package com.example.mysampleapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class WinScreenSingle extends AppCompatActivity {

    Typeface font, font1;
    TextView congrats, score, quizCompleted, explainResult;
    int questionCountInt, scoreDisplay, EXTRA_SCORE;
    double scoreDoubleType, questionCounterDouble, scorePercentage;
    Intent intent, intent2;
    boolean winScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_screen_single);

        //Create object for custom font name 'font'
        font = Typeface.createFromAsset(getAssets(), "Spantaran (demo).ttf");
        font1 = Typeface.createFromAsset(getAssets(), "Nevis Bold.ttf");

        congrats = (TextView)findViewById(R.id.congrats);
        score = (TextView)findViewById(R.id.score);
        quizCompleted = (TextView)findViewById(R.id.quizCompleted);
        explainResult = (TextView)findViewById(R.id.explainResult);

        congrats.setTypeface(font1);
        score.setTypeface(font1);
        quizCompleted.setTypeface(font1);
        explainResult.setTypeface(font1);

        scoreDisplay = activity_play_screen.score;
        scoreDoubleType = activity_play_screen.scoreDoubleType;
        questionCounterDouble = activity_play_screen.questionCounterDouble;
        questionCountInt = (int) questionCounterDouble;
        scorePercentage = (scoreDoubleType / questionCounterDouble) * 100;
        EXTRA_SCORE = (int) scorePercentage;

        winScreen = true; //boolean para pag nasa winscreen at nagback button, di na babalik sa play screen kundi sa category screen na.


        Button continuePlayingBtn = (Button)findViewById(R.id.continue_playingbtn);
        continuePlayingBtn.setTypeface(font);

        continuePlayingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(WinScreenSingle.this, category_screen.class);
                startActivity(intent);
            }
        });

        if (EXTRA_SCORE < 50){
            score.setTextColor(Color.parseColor("#cb2d3e"));
        }
        score.setText(EXTRA_SCORE + "% Score");
        explainResult.setText("You attempt " + questionCountInt + " questions and from that " + scoreDisplay + " answer is correct.");
    }
    @Override
    public void onBackPressed() { //pag nagback sa category pupunta
            intent = new Intent(WinScreenSingle.this, category_screen.class);
            startActivity(intent);
            super.onBackPressed();
    }
    @Override
    protected void onPause() {
        Context context = getApplicationContext();
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> taskInfo = am.getRunningTasks(1);
        if (!taskInfo.isEmpty()) {
            ComponentName topActivity = taskInfo.get(0).topActivity;
            if (!topActivity.getPackageName().equals(context.getPackageName())) {
                welcome_screen_version2.mediaPlayer.stop();
                //Toast.makeText(category_screen.this, "YOU LEFT YOUR APP", Toast.LENGTH_SHORT).show();
            }
        }
        super.onPause();
    }
}
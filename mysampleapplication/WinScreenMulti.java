package com.example.mysampleapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class WinScreenMulti extends AppCompatActivity {

    Intent intent;
    Bundle extras;
    public static int player1Score, player2Score, player3Score, player4Score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_screen_multi);

        //Create object for custom font name 'font'
        Typeface font = Typeface.createFromAsset(getAssets(), "Spantaran (demo).ttf");
        Typeface font1 = Typeface.createFromAsset(getAssets(), "Nevis Bold.ttf");

        TextView quizCompleted2 = (TextView)findViewById(R.id.quizCompleted2);
        TextView congrats2 = (TextView)findViewById(R.id.congrats2);
        TextView leaderBoard = (TextView)findViewById(R.id.leaderboard);
        TextView player1 = (TextView)findViewById(R.id.player1);
        TextView player2 = (TextView)findViewById(R.id.player2);
        TextView player3 = (TextView)findViewById(R.id.player3);
        TextView player4 = (TextView)findViewById(R.id.player4);

        TextView p1Score = (TextView)findViewById(R.id.p1Score);
        TextView p2Score = (TextView)findViewById(R.id.p2Score);
        TextView p3Score = (TextView)findViewById(R.id.p3Score);
        TextView p4Score = (TextView)findViewById(R.id.p4Score);

        congrats2.setTypeface(font1);
        quizCompleted2.setTypeface(font1);
        leaderBoard.setTypeface(font);
        player1.setTypeface(font1);
        player2.setTypeface(font1);
        player3.setTypeface(font1);
        player4.setTypeface(font1);

        p1Score.setTypeface(font1);
        p2Score.setTypeface(font1);
        p3Score.setTypeface(font1);
        p4Score.setTypeface(font1);

        intent = getIntent(); //ito yung getter para makuha natin yung value mula don sa intent sa category fragment
        extras = intent.getExtras();
        player1Score = extras.getInt("player1Score");
        player2Score = extras.getInt("player2Score");
        player3Score = extras.getInt("player3Score");
        player4Score = extras.getInt("player4Score");

        if (player_number.numberOfPlayersChosen == 2){
            p1Score.setText(Integer.toString(player1Score)); //game mode indicator text
            p2Score.setText(Integer.toString(player2Score));
        }
        else if (player_number.numberOfPlayersChosen == 3){
            p1Score.setText(Integer.toString(player1Score)); //game mode indicator text
            p2Score.setText(Integer.toString(player2Score));
            p3Score.setText(Integer.toString(player3Score));
        }
        else {
            p1Score.setText(Integer.toString(player1Score)); //game mode indicator text
            p2Score.setText(Integer.toString(player2Score));
            p3Score.setText(Integer.toString(player3Score));
            p4Score.setText(Integer.toString(player4Score));
        }

        Button continuePlayingBtn2 = (Button)findViewById(R.id.continue_playingbtn2);
        continuePlayingBtn2.setTypeface(font);

        continuePlayingBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(WinScreenMulti.this, category_screen.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() { //pag nagback sa category pupunta
        intent = new Intent(WinScreenMulti.this, category_screen.class);
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
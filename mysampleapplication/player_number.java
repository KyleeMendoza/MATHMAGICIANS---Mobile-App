package com.example.mysampleapplication;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.mysampleapplication.databinding.FragmentCategoryBinding;

import java.util.List;

public class player_number extends AppCompatActivity /*implements View.OnClickListener*/{

    View previousView; //dito mapupunta ung pagka naclick na
    int choice2Player, choice3Player, choice4Player, COUNTDOWN_IN_MILLIS, EXTRA_COUNT, score;
    String gameMode, category;
    public static int numberOfPlayersChosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_number);

        //Create object for custom font name 'font'
        Typeface font = Typeface.createFromAsset(getAssets(), "Spantaran (demo).ttf");
        Typeface font1 = Typeface.createFromAsset(getAssets(), "Nevis Bold.ttf");

        //Create object for buttons
        TextView twoPlayer = (TextView) findViewById(R.id.player2btn);
        TextView threePlayer = (TextView) findViewById(R.id.player3btn);
        TextView fourPlayer = (TextView) findViewById(R.id.player4btn);
        Button confirm = (Button)findViewById(R.id.confirm);

        //Set the custom font to the buttons
        twoPlayer.setTypeface(font1);
        threePlayer.setTypeface(font1);
        fourPlayer.setTypeface(font1);
        confirm.setTypeface(font);

        Intent intent = getIntent(); //ito yung getter para makuha natin yung value mula don sa intent sa category fragment
        Bundle extras = intent.getExtras();
        if (extras != null)
        {
            gameMode = extras.getString("gameMode"); //GAME MODE
            category = extras.getString("category");
            COUNTDOWN_IN_MILLIS = extras.getInt("COUNTDOWN_IN_MILLIS");
            EXTRA_COUNT = extras.getInt("EXTRA_COUNT");
            score = extras.getInt("score");
            numberOfPlayersChosen = extras.getInt("numberOfPlayersChosen"); //inital value lagi nito ay 0 mula sa pinasang value ng category fragment na intent
        }

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (choice2Player != 0){
                    //PUNTA KAY PLAYER 1 NG MULTIPLAYER
                    Intent intent2 = new Intent(player_number.this, activity_play_screen_multi.class); //itong intent gagamitin para maspawn yung play screen
                    Bundle extras = new Bundle();
                    extras.putString("category", category);
                    extras.putString("gameMode", gameMode); //need para sa game mode textview sa play screen
                    extras.putInt("COUNTDOWN_IN_MILLIS", COUNTDOWN_IN_MILLIS); //dito dineclare yung values para everytime na magspawn yung playscreens ay nakareset yung values
                    extras.putInt("EXTRA_COUNT", EXTRA_COUNT); //reset number of question answered or tackled
                    extras.putInt("score", score); //reset scoring
                    extras.putInt("player1Score", 0); //reset score ng player 1 to 0
                    intent2.putExtras(extras); //sa line na to ang way para mapasa natin yung game mode at categry na napili sa play screen; key yung unang parameter tas value yung pangalawa
                    startActivity(intent2);
                } else if (choice3Player != 0){
                    Intent intent3 = new Intent(player_number.this, activity_play_screen_multi.class);
                    Bundle extras = new Bundle();
                    extras.putString("category", category);
                    extras.putString("gameMode", gameMode);
                    extras.putInt("COUNTDOWN_IN_MILLIS", COUNTDOWN_IN_MILLIS);
                    extras.putInt("EXTRA_COUNT", EXTRA_COUNT);
                    extras.putInt("score", score);
                    extras.putInt("player1Score", 0); //reset score ng player 1 to 0
                    intent3.putExtras(extras);
                    startActivity(intent3);
                }
                else if (choice4Player != 0){
                    Intent intent4 = new Intent(player_number.this, activity_play_screen_multi.class);
                    Bundle extras = new Bundle();
                    extras.putString("category", "Addition");
                    extras.putString("gameMode", "Multiplayer");
                    extras.putInt("COUNTDOWN_IN_MILLIS", 20000);
                    extras.putInt("EXTRA_COUNT", 0);
                    extras.putInt("score", 0);
                    extras.putInt("player1Score", 0); //reset score ng player 1 to 0
                    intent4.putExtras(extras);
                    startActivity(intent4);
                }
                else{
                    Toast.makeText(player_number.this,"Please choose a category and game mode",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(player_number.this, player_number.class);
                    overridePendingTransition(0, 0);
                    startActivity(i);
                    overridePendingTransition(0, 0);
                }
            }
        });
        twoPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (previousView != null){ //pag may naunang kinlick
                    previousView.setSelected(true); //pag setSelected(true) meaning i-uunclick mo yung button, tapos pag false naman pepress down yung button
                    previousView.setBackground(getResources().getDrawable(R.drawable.asm_button_normal)); // so dito uunclick nati ung nauanng button
                    previousView.setPadding(20, 20, 0, 0);
                    numberOfPlayersChosen = 0;
                }
                v.setSelected(false); //pag ito yung first time, false kaya clicked
                choice2Player++;
                numberOfPlayersChosen = 2;
                //buttonSelected = 2;
                v.setBackground(getResources().getDrawable(R.drawable.asm_button_pressed));
                v.setPadding(30, 40, 0, 0);
                previousView = v; // pass siya sa previous since clicked na sya
            }
        });
        threePlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (previousView != null){
                    previousView.setSelected(true);
                    previousView.setBackground(getResources().getDrawable(R.drawable.asm_button_normal));
                    previousView.setPadding(20, 20, 0, 0);
                    numberOfPlayersChosen = 0;
                }
                v.setSelected(false);
                choice3Player++;
                numberOfPlayersChosen = 3;
                //buttonSelected = 2;
                v.setBackground(getResources().getDrawable(R.drawable.asm_button_pressed));
                v.setPadding(30, 40, 0, 0);
                previousView = v;
            }
        });
        fourPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (previousView != null){
                    previousView.setSelected(true);
                    previousView.setBackground(getResources().getDrawable(R.drawable.asm_button_normal));
                    previousView.setPadding(20, 20, 0, 0);
                    numberOfPlayersChosen = 0;
                }
                v.setSelected(false);
                choice3Player++;
                numberOfPlayersChosen = 4;
                //buttonSelected = 2;
                v.setBackground(getResources().getDrawable(R.drawable.asm_button_pressed));
                v.setPadding(30, 40, 0, 0);
                previousView = v;
            }
        });
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
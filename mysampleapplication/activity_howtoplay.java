package com.example.mysampleapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class activity_howtoplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_howtoplay);

//        Typeface font = Typeface.createFromAsset(getAssets(), "Spantaran (demo).ttf");
//        Typeface font1 = Typeface.createFromAsset(getAssets(), "Nevis Bold.ttf");
//
//        TextView howtoplay_txt = findViewById(R.id.howtoplay_txt);
//        TextView howtoplay_title = findViewById(R.id.howtoplay_title);
//
//        howtoplay_title.setTypeface(font);
//        howtoplay_txt.setTypeface(font1);
//        howtoplay_txt.setText("1) Click Start Playing button. \n \n2) Choose your desire operation from " +
//                "Addition/Subtraction/Multiplication. \n \n3) Choose between Single \nPlayer or Multiplayer. " +
//                "\n \n4) Click Start Game button. \n \n5) This Game has 1 minute time duration. " +
//                "\n \n6) Read and solve the questions and choose your answer. \n \n7) After 1 minute, your score" +
//                " will be revealed if single player mode.\n" +
//                "If multiplayer mode then pass \nyour device to your playmates");
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
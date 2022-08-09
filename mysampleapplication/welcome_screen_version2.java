package com.example.mysampleapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.LayoutTransition;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.List;


public class welcome_screen_version2 extends AppCompatActivity {

    RelativeLayout rellay2;
//    private long backPressedTime;
//    private Toast backToast;

    public static MediaPlayer mediaPlayer;

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rellay2.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen_version2);

        ((ViewGroup) findViewById(R.id.root)).getLayoutTransition()
                .enableTransitionType(LayoutTransition.CHANGING);
        rellay2 = (RelativeLayout) findViewById(R.id.rellay2);
        handler.postDelayed(runnable, 2000);

        //para pag bumabalik sa welcome screen di nagooverlay ung music
        if (mediaPlayer==null)
            mediaPlayer = MediaPlayer.create(this, R.raw.audio);

        if(!mediaPlayer.isPlaying()){
            mediaPlayer.setLooping(true);
            mediaPlayer.setVolume(100, 100);
            mediaPlayer.start();
        }

        //Create object for custom font name 'font'
        Typeface font = Typeface.createFromAsset(getAssets(), "Spantaran (demo).ttf");
        Typeface font1 = Typeface.createFromAsset(getAssets(), "Nevis Bold.ttf");

        //Create object for buttons
        Button startPlayingBtn = (Button)findViewById(R.id.start_playingbtn); //start button
        Button howToPlayBtn = (Button)findViewById(R.id.howtoplay_btn); //how to play button

        //Set the custom font to the buttons
        startPlayingBtn.setTypeface(font);
        howToPlayBtn.setTypeface(font);

        //onClick ng start button
        startPlayingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(welcome_screen_version2.this, category_screen.class));
            }
        });
        howToPlayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(welcome_screen_version2.this, activity_howtoplay.class));
            }
        });
    }
    public static void mute(){
        mediaPlayer.setVolume(0,0);
    }
    public static void maxVolume(){
        mediaPlayer.setVolume(1,1);
    }

    @Override
    protected void onPause() {
        if (this.isFinishing()){ //basically BACK was pressed from this activity
            mediaPlayer.stop();
//            Toast.makeText(MainActivity.this, "YOU PRESSED BACK FROM YOUR 'HOME/MAIN' ACTIVITY", Toast.LENGTH_SHORT).show();
        }
        Context context = getApplicationContext();
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> taskInfo = am.getRunningTasks(1);
        if (!taskInfo.isEmpty()) {
            ComponentName topActivity = taskInfo.get(0).topActivity;
            if (!topActivity.getPackageName().equals(context.getPackageName())) {
                mediaPlayer.stop();
//                Toast.makeText(MainActivity.this, "YOU LEFT YOUR APP", Toast.LENGTH_SHORT).show();
            }
//            else {
//                Toast.makeText(welcome_screen_version2.this, "YOU SWITCHED ACTIVITIES WITHIN YOUR APP", Toast.LENGTH_SHORT).show();
//            }
        }
        super.onPause();
    }

//    //TWICE MAG BACK BUTTON EEXIT YUNG APP
//    @Override
//    public void onBackPressed() {
//
//        if (backPressedTime + 2000 > System.currentTimeMillis()){
//            backToast.cancel();
//            super.onBackPressed();
//            return;
//        } else{
//            backToast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
//            backToast.show();
//        }
//        backPressedTime = System.currentTimeMillis();
//    }

}

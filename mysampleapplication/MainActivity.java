package com.example.mysampleapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_screen);

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
                startActivity(new Intent(MainActivity.this, category_screen.class));
            }
        });
        howToPlayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, activity_howtoplay.class));
            }
        });
    }
    //TWICE MAG BACK BUTTON EEXIT YUNG APP
    @Override
    public void onBackPressed() {

        if (backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        } else{
            backToast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}
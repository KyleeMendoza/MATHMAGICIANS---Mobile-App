package com.example.mysampleapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mysampleapplication.databinding.ActivityCategoryScreenBinding;

import java.util.List;

import me.ibrahimsn.lib.OnItemSelectedListener;


public class category_screen extends AppCompatActivity{

    //private static final String TAG = category_screen.class.getSimpleName();

    ActivityCategoryScreenBinding binding;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_screen);

        //Initiating Binding
        binding = ActivityCategoryScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Code para nasa category section agad sa bottomnav
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, new Category_Fragment());
        transaction.commit();

        //bottom navigation bar
        binding.bottomNav.setOnItemSelectedListener(new OnItemSelectedListener() {
            public boolean onItemSelect(int i) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                switch (i){
                    case 0://category tab
                        transaction.replace(R.id.fragment_container, new Category_Fragment());//tawagin nito yung category fragment kung nasan don nalipat yung codes na mula dito para smooth transition
                        transaction.commit();
                        break;
                    case 1://ranking tab
                        transaction.replace(R.id.fragment_container, new Ranking_Fragment());
                        transaction.commit();
                        break;
                    case 2://settings tab
                        transaction.replace(R.id.fragment_container, new Settings_Fragment());
                        transaction.commit();
                        break;
                    case 3://about us tab
                        transaction.replace(R.id.fragment_container, new AboutUs_Fragment());
                        transaction.commit();
                        break;
                }
                return false;
            }
        });
    }
    @Override
    public void onBackPressed() { //pag nagback sa category pupunta
        intent = new Intent(category_screen.this, welcome_screen_version2.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); //erase all previous activities
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
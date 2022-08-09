package com.example.mysampleapplication;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.example.mysampleapplication.databinding.FragmentRankingBinding;
import com.example.mysampleapplication.databinding.FragmentSettingsBinding;

public class Settings_Fragment extends Fragment {
//    public static int musichandler = 0;
//
//    private AudioManager audioManager = null;

    public Settings_Fragment() {
        // Required empty public constructor
    }
    FragmentSettingsBinding settingsBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Initialize binding variable
        settingsBinding = FragmentSettingsBinding.inflate(inflater,container,false);

        settingsBinding.textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                welcome_screen_version2.maxVolume();
            }
        });
        settingsBinding.textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                welcome_screen_version2.mute();
            }
        });

//        getActivity().setVolumeControlStream(AudioManager.STREAM_MUSIC);
//        getActivity().setContentView(R.layout.fragment_settings_);
//
//        audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);
//        settingsBinding.seekBar.setMax(audioManager
//                .getStreamMaxVolume(AudioManager.STREAM_MUSIC));
//        settingsBinding.seekBar.setProgress(audioManager
//                .getStreamVolume(AudioManager.STREAM_MUSIC));
//
//        settingsBinding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
//        {
//            @Override
//            public void onStopTrackingTouch(SeekBar arg0)
//            {
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar arg0)
//            {
//            }
//
//            @Override
//            public void onProgressChanged(SeekBar arg0, int progress, boolean arg2)
//            {
//                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,
//                        progress, 0);
//            }
//        });

        return settingsBinding.getRoot();
    }

}
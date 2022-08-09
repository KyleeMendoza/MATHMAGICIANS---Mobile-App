package com.example.mysampleapplication;

import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mysampleapplication.databinding.FragmentCategoryBinding;
import com.example.mysampleapplication.databinding.FragmentRankingBinding;

public class Ranking_Fragment extends Fragment {

    public Ranking_Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //wag din pansinin default
    }

    FragmentRankingBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Initialize binding variable
        binding = FragmentRankingBinding.inflate(inflater,container,false);

        //Initialize font variables
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "Spantaran (demo).ttf");
        Typeface font1 = Typeface.createFromAsset(getActivity().getAssets(), "Nevis Bold.ttf");

        if (player_number.numberOfPlayersChosen == 2){
            binding.p3Score2.setText(Integer.toString(WinScreenMulti.player1Score) + " pts.");
            binding.p1Score2.setText(Integer.toString(WinScreenMulti.player2Score) + " pts.");
        }
        else if (player_number.numberOfPlayersChosen == 3){
            binding.p3Score2.setText(Integer.toString(WinScreenMulti.player1Score) + " pts.");
            binding.p1Score2.setText(Integer.toString(WinScreenMulti.player2Score) + " pts.");
            binding.p4Score2.setText(Integer.toString(WinScreenMulti.player3Score) + " pts.");
        }
        else {
            binding.p3Score2.setText(Integer.toString(WinScreenMulti.player1Score) + " pts.");
            binding.p1Score2.setText(Integer.toString(WinScreenMulti.player2Score) + " pts.");
            binding.p4Score2.setText(Integer.toString(WinScreenMulti.player3Score) + " pts.");
            binding.p2Score2.setText(Integer.toString(WinScreenMulti.player4Score) + " pts.");
        }

        binding.p3Score2.setTypeface(font1); //score ng player 1 iba lang yung name ng id nila hehe hirap na baguhin e
        binding.p1Score2.setTypeface(font1); //score ng player 2
        binding.p4Score2.setTypeface(font1); //score ng player 3
        binding.p2Score2.setTypeface(font1); //score ng player 4

        return binding.getRoot();
    }
}
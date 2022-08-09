package com.example.mysampleapplication;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.mysampleapplication.databinding.FragmentCategoryBinding;

//tawag dito fragment.
public class Category_Fragment extends Fragment {
    public Category_Fragment() {
        // Required empty public constructor
        // wag pansinin default
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //wag din pansinin default
    }

    //LINK yung fragment_category.xml dito sa .java
    FragmentCategoryBinding binding;

    //Ito yung COTNAIER ng napiling category at gamemode na pwedeng ipasa sa mga susunod na activity
    View previousView; //dito mapupunta ung pagka naclick na
    View previousGameModeView;

    //DEFAULT din ito, pero dito lahat NAKALAGAY code
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Initialize binding variable
        binding = FragmentCategoryBinding.inflate(inflater,container,false);
        //Initialize font variables
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "Spantaran (demo).ttf");
        Typeface font1 = Typeface.createFromAsset(getActivity().getAssets(), "Nevis Bold.ttf");
        //di na kecreate ng object for each button or textview kagaya nung dati, rekta na sa mismong id name nila sa xml
        binding.additionbtn.setTypeface(font1);
        binding.subtractionbtn.setTypeface(font1);
        binding.multiplicationbtn.setTypeface(font1);
        binding.singlebtn.setTypeface(font1);
        binding.multiplayerbtn.setTypeface(font1);
        binding.categorytxt.setTypeface(font);
        binding.gamemode.setTypeface(font);
        binding.startGamebtn.setTypeface(font);

        //instead of switch statement katulad nung dati, dito sa fragment code di pwede yun instead gnto yung method isa isa tas rekta id na tatawagin di a need mag gawa ng object yung R.id.object.
        binding.additionbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (previousView != null){ //pag may naunang kinlick
                    previousView.setSelected(true); //pag setSelected(true) meaning i-uunclick mo yung button, tapos pag false naman pepress down yung button
                    previousView.setBackground(getResources().getDrawable(R.drawable.asm_button_normal)); // so dito uunclick nati ung nauanng button
                    previousView.setPadding(0, 0, 0, 0);
                }
                v.setSelected(false); //pag ito yung first time, false kaya clicked
                v.setBackground(getResources().getDrawable(R.drawable.asm_button_pressed));
                v.setPadding(0, 24, 0, 0);
                previousView = v; // pass siya sa previous since clicked na sya
            }
        });
        binding.subtractionbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (previousView != null){ //pag may naunang kinlick
                    previousView.setSelected(true); //pag setSelected(true) meaning i-uunclick mo yung button, tapos pag false naman pepress down yung button
                    previousView.setBackground(getResources().getDrawable(R.drawable.asm_button_normal)); // so dito uunclick nati ung nauanng button
                    previousView.setPadding(0, 0, 0, 0);
                }
                v.setSelected(false); //pag ito yung first time, false kaya clicked
                v.setBackground(getResources().getDrawable(R.drawable.asm_button_pressed));
                v.setPadding(0, 24, 0, 0);
                previousView = v; // pass siya sa previous since clicked na sya
            }
        });
        binding.multiplicationbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (previousView != null){ //pag may naunang kinlick
                    previousView.setSelected(true); //pag setSelected(true) meaning i-uunclick mo yung button, tapos pag false naman pepress down yung button
                    previousView.setBackground(getResources().getDrawable(R.drawable.asm_button_normal)); // so dito uunclick nati ung nauanng button
                    previousView.setPadding(0, 0, 0, 0);
                }
                v.setSelected(false); //pag ito yung first time, false kaya clicked
                v.setBackground(getResources().getDrawable(R.drawable.asm_button_pressed));
                v.setPadding(0, 24, 0, 0);
                previousView = v; // pass siya sa previous since clicked na sya

            }
        });
        binding.singlebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (previousGameModeView != null){
                    previousGameModeView.setSelected(true);
                    previousGameModeView.setBackground(getResources().getDrawable(R.drawable.asm_button_normal));
                    previousGameModeView.setPadding(15, 0, 30, 5);
                }
                v.setSelected(false);
                v.setBackground(getResources().getDrawable(R.drawable.asm_button_pressed));
                v.setPadding(50, 24, 90, 5);
                previousGameModeView = v;
            }
        });
        binding.multiplayerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (previousGameModeView != null){
                    previousGameModeView.setSelected(true);
                    previousGameModeView.setBackground(getResources().getDrawable(R.drawable.asm_button_normal));
                    previousGameModeView.setPadding(50, 0, 90, 5);
                }
                v.setSelected(false);
                v.setBackground(getResources().getDrawable(R.drawable.asm_button_pressed));
                v.setPadding(30, 24, 30, 5);
                previousGameModeView = v;
            }
        });

        //pag kinclick na yung START GAME
        binding.startGamebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if addition tas single
                if (previousView == binding.additionbtn && previousGameModeView == binding.singlebtn){
                    Intent intent = new Intent(getActivity(), activity_play_screen.class); //itong intent gagamitin para maspawn yung play screen
                    Bundle extras = new Bundle();
                    extras.putString("category", "Addition");
                    extras.putString("gameMode", binding.singlebtn.getText().toString());
                    extras.putInt("COUNTDOWN_IN_MILLIS", 60000); //dito dineclare yung values para everytime na magspawn yung playscreens ay nakareset yung values
                    extras.putInt("EXTRA_COUNT", 0);
                    extras.putInt("score", 0);
                    intent.putExtras(extras); //sa line na to ang way para mapasa natin yung game mode at categry na napili sa play screen; key yung unang parameter tas value yung pangalawa
                    startActivity(intent);
                }
                //if addition tas multiplayer
                else if (previousView == binding.additionbtn && previousGameModeView == binding.multiplayerbtn){
                    Intent intent = new Intent(getActivity(), player_number.class);
                    Bundle extras = new Bundle();
                    extras.putString("category", "Addition");
                    extras.putString("gameMode", binding.multiplayerbtn.getText().toString());
                    extras.putInt("COUNTDOWN_IN_MILLIS", 60000);
                    extras.putInt("EXTRA_COUNT", 0);
                    extras.putInt("score", 0);
                    extras.putInt("numberOfPlayersChosen", 0);//reset the chosen number of players
                    intent.putExtras(extras);
                    startActivity(intent);
                }
                else if (previousView == binding.subtractionbtn && previousGameModeView == binding.singlebtn){
                    Intent intent = new Intent(getActivity(), activity_play_screen.class);
                    Bundle extras = new Bundle();
                    extras.putString("category", "Subtraction");
                    extras.putString("gameMode", binding.singlebtn.getText().toString());
                    extras.putInt("COUNTDOWN_IN_MILLIS", 60000);
                    extras.putInt("EXTRA_COUNT", 0);
                    extras.putInt("score", 0);
                    intent.putExtras(extras);
                    startActivity(intent);
                }
                else if (previousView == binding.subtractionbtn && previousGameModeView == binding.multiplayerbtn){
                    Intent intent = new Intent(getActivity(), player_number.class);
                    Bundle extras = new Bundle();
                    extras.putString("category", "Subtraction");
                    extras.putString("gameMode", binding.multiplayerbtn.getText().toString());
                    extras.putInt("COUNTDOWN_IN_MILLIS", 60000);
                    extras.putInt("EXTRA_COUNT", 0);
                    extras.putInt("score", 0);
                    extras.putInt("numberOfPlayersChosen", 0);
                    intent.putExtras(extras);
                    startActivity(intent);
                }
                else if (previousView == binding.multiplicationbtn && previousGameModeView == binding.singlebtn){
                    Intent intent = new Intent(getActivity(), activity_play_screen.class);
                    Bundle extras = new Bundle();
                    extras.putString("category", "Multiplication");
                    extras.putString("gameMode", binding.singlebtn.getText().toString());
                    extras.putInt("COUNTDOWN_IN_MILLIS", 60000);
                    extras.putInt("EXTRA_COUNT", 0);
                    extras.putInt("score", 0);
                    intent.putExtras(extras);
                    startActivity(intent);
                }
                else if (previousView == binding.multiplicationbtn && previousGameModeView == binding.multiplayerbtn){
                    Intent intent = new Intent(getActivity(), player_number.class);
                    Bundle extras = new Bundle();
                    extras.putString("category", "Multiplication");
                    extras.putString("gameMode", binding.multiplayerbtn.getText().toString());
                    extras.putInt("COUNTDOWN_IN_MILLIS", 60000);
                    extras.putInt("EXTRA_COUNT", 0);
                    extras.putInt("score", 0);
                    extras.putInt("numberOfPlayersChosen", 0); //reset the chosen number of players
                    intent.putExtras(extras);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getActivity(),"Please choose a category and game mode",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getActivity(), category_screen.class);
                    getActivity().overridePendingTransition(0, 0);
                    startActivity(i);
                    getActivity().overridePendingTransition(0, 0);
                }
            }
        });
        //ito yung huling statement na required, yung una ung binding initialization.
        return binding.getRoot();
    }
}
package com.example.mysampleapplication;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

import com.example.mysampleapplication.databinding.FragmentAboutUsBinding;
import com.example.mysampleapplication.databinding.FragmentCategoryBinding;


public class AboutUs_Fragment extends Fragment {

    public AboutUs_Fragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //wag din pansinin default
    }
    //LINK yung fragment_category.xml dito sa .java
    FragmentAboutUsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Initialize binding variable
        binding = FragmentAboutUsBinding.inflate(inflater,container,false);
        //Initialize font variables
//        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "Spantaran (demo).ttf");
//        Typeface font1 = Typeface.createFromAsset(getActivity().getAssets(), "Nevis Bold.ttf");
//        //di na kecreate ng object for each button or textview kagaya nung dati, rekta na sa mismong id name nila sa xml
//        binding.companyEmail2.setTypeface(font1);
//        binding.companyEmail1.setTypeface(font1);
//        binding.companyMaker1.setTypeface(font1);
//        binding.companyMaker2.setTypeface(font1);
//        binding.companyContact.setTypeface(font);
//        binding.aboutus.setTypeface(font);
//        binding.companySchool.setTypeface(font);

        //ito yung huling statement na required, yung una ung binding initialization.
        return binding.getRoot();
    }

}
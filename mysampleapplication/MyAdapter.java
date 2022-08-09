package com.example.mysampleapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends PagerAdapter {

    private Context context;
    private ArrayList<Question> questionList;

    //Constructor
    public MyAdapter(Context context, ArrayList<Question> questionList) {
        this.context = context;
        this.questionList = questionList;
    }

    @Override
    public int getCount() {
        return questionList.size(); //returns size of arrayList
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        //inflate layout card_item.xml
        View view = LayoutInflater.from(context).inflate(R.layout.card_item, container, false);

        //initialize Textview on card item xml
        TextView textView = view.findViewById(R.id.flashCard);

        //get data
        Question question = questionList.get(position);
        String flashCard = question.getQuestion();

        //set data
        textView.setText(flashCard);

        //meron pa tong onClick pero d naman need since gagamit tayo ng buttons

        //add view to container
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}

package com.example.mysampleapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;


public class play_screen_multiplayer3 extends AppCompatActivity implements View.OnClickListener{

    //GAMITIN NATIN TO PAG COUNTDOWN TIMER NA
    private static long COUNTDOWN_IN_MILLIS; //dineclare ko na to via intent doon sa category fragment para pag 'continue playing' sya don sa winscreen ay mareset din itong coundown at yung qustion count.
    private long continueTimeLeft;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;

    View previousView; //dito mapupunta ung pagka naclick na
    Typeface font;
    Typeface font1;
    Button submit;
    ImageButton backButton; //BACK BUTTON
    TextView gameModeTextView; //GAME MODE indicator
    TextView textViewCountDown; //textView ng countdown timer
    TextView textViewQuestionCount; //questions count
    TextView scoreTextView;
    public static int EXTRA_COUNT;
    private int questionCountTotal;
    private Question currentQuestion;
    private TextView choicea;
    private int choiceaSelected;
    private TextView choiceb;
    private int choicebSelected;
    private TextView choicec;
    private int choicecSelected;
    private TextView choiced;
    private int choicedSelected;
    private int buttonSelected = 0;

    Intent intent; //get intent
    Bundle extras; //get extras
    Bundle keme;
    Intent intent1;
    //Intent intent2;
    String gameMode;
    String category;

    public static int score;
    public static int player1Score,player2Score,player3Score,player4Score; //double para sa computation ng scorePercentageInteger
    private boolean answered;
    private boolean solutionShowened;

    //ViewPager, ito yung cart style quiz swipe natin
    private ViewPager viewPager;
    private MyAdapter myAdapter; //sa class na myAdapter don natin sinet yung getters and setters
    private ArrayList<Question> questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_screen_multiplayer3);

        font = Typeface.createFromAsset(getAssets(), "Spantaran (demo).ttf");
        font1 = Typeface.createFromAsset(getAssets(), "Nevis Bold.ttf");

        submit =(Button)findViewById(R.id.submitbtn);
        backButton = (ImageButton)findViewById(R.id.backButton); //BACK BUTTON
        gameModeTextView = (TextView)findViewById(R.id.textView); //GAME MODE indicator
        textViewCountDown = (TextView)findViewById(R.id.countdown); //textView ng countdown timer
        textViewQuestionCount = (TextView)findViewById(R.id.numberQuestions); //questions count
        scoreTextView = (TextView)findViewById(R.id.scoreTextView);

        choicea = (TextView)findViewById(R.id.choiceabtn); //create object
        choicea.setOnClickListener(this); //call yung method na OnClick
        choiceb = (TextView)findViewById(R.id.choicebbtn);
        choiceb.setOnClickListener(this);
        choicec = (TextView)findViewById(R.id.choicecbtn);
        choicec.setOnClickListener(this);
        choiced = (TextView)findViewById(R.id.choicedbtn);
        choiced.setOnClickListener(this);

        //SET CUSTOM FONT
        submit.setTypeface(font);
        choicea.setTypeface(font1);
        choiceb.setTypeface(font1);
        choicec.setTypeface(font1);
        choiced.setTypeface(font1);
        textViewQuestionCount.setTypeface(font1);

        //need to para mapasa natin kung single o multipleyer ba ung pinili
        intent = getIntent(); //ito yung getter para makuha natin yung value mula don sa intent sa category fragment
        extras = intent.getExtras();
        gameMode = extras.getString("gameMode"); //GAME MODE
        category = extras.getString("category");
        COUNTDOWN_IN_MILLIS = extras.getInt("COUNTDOWN_IN_MILLIS");
        EXTRA_COUNT = extras.getInt("EXTRA_COUNT");
        score = extras.getInt("score");
        player1Score = extras.getInt("player1Score");
        player2Score = extras.getInt("player2Score");
        player3Score = extras.getInt("player3Score");
        player4Score = extras.getInt("player4Score");
        gameModeTextView.setText(gameMode); //game mode indicator text
        gameModeTextView.setTypeface(font1);

        //instantiate viewPager
        viewPager = findViewById(R.id.viewPager);
        loadCards(category); //dito nankalagay yung data sa questionnaire

        //FIRST QUESTION INITIALIZATION
        questionCountTotal = questionList.size();
        Collections.shuffle(questionList);

        nextQuestion();

        //submit button functionality
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timeLeftInMillis == 0){
                    if (player_number.numberOfPlayersChosen == 4){
                        intent1 = new Intent(play_screen_multiplayer3.this, WinScreenMulti.class); //PUNTA KAY PLAYER 2 PAG UBOS NA ORAS NI PLAYER 1
                        keme = new Bundle();
                        keme.putInt("player1Score", player1Score);
                        keme.putInt("player2Score", player2Score);
                        keme.putInt("player3Score", player3Score);
                        keme.putInt("player4Score", player4Score); //si winscreen ang magmamana nito
                        intent1.putExtras(keme);
                        startActivity(intent1);
                    }
                }
                else {
                    if (!answered){
                        if (choiceaSelected > 0){
                            checkAnswer();
                        }
                        else if (choicebSelected > 0) {
                            checkAnswer();
                        }
                        else if (choicecSelected > 0) {
                            checkAnswer();
                        }
                        else if (choicedSelected > 0) {
                            checkAnswer();
                        }
                        else {
                            Toast.makeText(play_screen_multiplayer3.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        nextQuestion();
                    }
                }
            }
        });

        //BACK BUTTON w/ simple animation onclick tas functionality
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim)); //animation declaration
                onBackPressed(); //back function
            }
        });

        //set viewpager change listener ito yung parang onClick
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //none
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void loadCards(String category) {
        QuizDbHelper dbHelper = new QuizDbHelper(this);
        if (category.equals("Multiplication")) {
            questionList = dbHelper.getQuestions("Multiplication");
        }
        else if (category.equals("Addition")){
            questionList = dbHelper.getQuestions("Addition");
        }
        else {
            questionList = dbHelper.getQuestions("Subtraction");
        }
        //setup adapter
        myAdapter = new MyAdapter(this, questionList); //gawa object
        //setup adapter to viewPager
        viewPager.setAdapter(myAdapter); //link natin ung myAdapter sa viewPager
        //set default padding from left/right
        viewPager.setPadding(70,0,70,0); //ito yung setting para makita ng konti yung kaliwa at kanang part ng susunod o yung previous card.
    }

    public void nextQuestion() {
        //reset clickable ability
        choicea.setClickable(true);
        choiceb.setClickable(true);
        choicec.setClickable(true);
        choiced.setClickable(true);
        //reset button selection per next question
        choicea.setBackground(getResources().getDrawable(R.drawable.choices_button_normal));
        choicea.setPadding(20, 20, 0, 0);

        choiceb.setBackground(getResources().getDrawable(R.drawable.choices_button_normal));
        choiceb.setPadding(20, 20, 0, 0);

        choicec.setBackground(getResources().getDrawable(R.drawable.choices_button_normal));
        choicec.setPadding(20, 20, 0, 0);

        choiced.setBackground(getResources().getDrawable(R.drawable.choices_button_normal));
        choiced.setPadding(20, 20, 0, 0);

        if (EXTRA_COUNT < questionCountTotal) {
            currentQuestion = questionList.get(EXTRA_COUNT);
            if (EXTRA_COUNT >= 1) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
            }
            else{
                viewPager.setCurrentItem(viewPager.getCurrentItem(), true);
            }
            choicea.setText("A.  " + currentQuestion.getOption1());
            choicea.setPadding(20, 20, 0, 0);
            choiceb.setText("B.  " + currentQuestion.getOption2());
            choiceb.setPadding(20, 20, 0, 0);
            choicec.setText("C.  " + currentQuestion.getOption3());
            choicec.setPadding(20, 20, 0, 0);
            choiced.setText("D.  " + currentQuestion.getOption4());
            choiced.setPadding(20, 20, 0, 0);

            EXTRA_COUNT++;

            textViewQuestionCount.setText(EXTRA_COUNT + "/" + questionCountTotal);
            answered = false;
            submit.setText("Confirm");

            if(EXTRA_COUNT == 1){
                timeLeftInMillis = COUNTDOWN_IN_MILLIS;
            }
            else {
                timeLeftInMillis = continueTimeLeft;
            }
            startCountdown();
        }
        else{
            finishQuiz();
        }
    }

    private void startCountdown() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountdownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateCountdownText();
                checkAnswer();
            }
        }.start();
    }

    private void updateCountdownText(){
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        textViewCountDown.setText(timeFormatted);

        if(timeLeftInMillis < 10000){
            textViewCountDown.setTextColor(Color.parseColor("#cb2d3e"));
        }
        continueTimeLeft = timeLeftInMillis;
    }

    private void checkAnswer(){
        answered = true;
        //countDownTimer.cancel(); //ito yung nagpapastop ng timer everytime nagcheck ans
        if (buttonSelected == currentQuestion.getAnswerNr()){
            score++;
            player4Score = score;
            scoreTextView.setText("Score: " + score);
            //Toast.makeText(activity_play_screen.this, "CORRECT", Toast.LENGTH_SHORT).show();
        }
//        else{
//            Toast.makeText(activity_play_screen.this, "WRONG", Toast.LENGTH_SHORT).show();
//        }
        buttonSelected = 0;
        showSolution();
    }

    private void showSolution() {
        solutionShowened = true;
        choicea.setBackground(getResources().getDrawable(R.drawable.button_wrongans));
        choiceb.setBackground(getResources().getDrawable(R.drawable.button_wrongans));
        choicec.setBackground(getResources().getDrawable(R.drawable.button_wrongans));
        choiced.setBackground(getResources().getDrawable(R.drawable.button_wrongans));

        switch (currentQuestion.getAnswerNr()){
            case 1:
                choicea.setSelected(false);
                choicea.setBackground(getResources().getDrawable(R.drawable.button_correctans));
                choicea.setPadding(30, 40, 0, 0);
                break;
            case 2:
                choiceb.setSelected(false);
                choiceb.setBackground(getResources().getDrawable(R.drawable.button_correctans));
                choiceb.setPadding(30, 40, 0, 0);
                break;
            case 3:
                choicec.setSelected(false);
                choicec.setBackground(getResources().getDrawable(R.drawable.button_correctans));
                choicec.setPadding(30, 40, 0, 0);
                break;
            case 4:
                choiced.setSelected(false);
                choiced.setBackground(getResources().getDrawable(R.drawable.button_correctans));
                choiced.setPadding(30, 40, 0, 0);
                break;
        }
        if ((EXTRA_COUNT < questionCountTotal) && (timeLeftInMillis != 0)){
            submit.setText("Next");
        } else{
            submit.setText("Result");
        }
        choiceaSelected = 0;
        choicebSelected = 0;
        choicecSelected = 0;
        choicedSelected = 0;
        //turn off clickable ability
        choicea.setClickable(false);
        choiceb.setClickable(false);
        choicec.setClickable(false);
        choiced.setClickable(false);
    }

    private void finishQuiz() {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null){
            countDownTimer.cancel();
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.choiceabtn) {
            if (previousView != null){ //pag may naunang kinlick
                previousView.setSelected(true); //pag setSelected(true) meaning i-uunclick mo yung button, tapos pag false naman pepress down yung button
                previousView.setBackground(getResources().getDrawable(R.drawable.choices_button_normal)); // so dito uunclick nati ung nauanng button
                previousView.setPadding(20, 20, 0, 0);
            }
            v.setSelected(false); //pag ito yung first time, false kaya clicked
            choiceaSelected++;
            buttonSelected = 1;
            v.setBackground(getResources().getDrawable(R.drawable.choices_button_pressed));
            v.setPadding(30, 40, 0, 0);
            previousView = v; // pass siya sa previous since clicked na sya
        } else if (v.getId() == R.id.choicebbtn) {
            if (previousView != null){
                previousView.setSelected(true);
                previousView.setBackground(getResources().getDrawable(R.drawable.choices_button_normal));
                previousView.setPadding(20, 20, 0, 0);
            }
            v.setSelected(false);
            choicebSelected++;
            buttonSelected = 2;
            v.setBackground(getResources().getDrawable(R.drawable.choices_button_pressed));
            v.setPadding(30, 40, 0, 0);
            previousView = v;
        } else if (v.getId() == R.id.choicecbtn) {
            if (previousView != null){
                previousView.setSelected(true);
                previousView.setBackground(getResources().getDrawable(R.drawable.choices_button_normal));
                previousView.setPadding(20, 20, 0, 0);
            }
            v.setSelected(false);
            choicecSelected++;
            buttonSelected = 3;
            v.setBackground(getResources().getDrawable(R.drawable.choices_button_pressed));
            v.setPadding(30, 40, 0, 0);
            previousView = v;
        } else if (v.getId() == R.id.choicedbtn) {
            if (previousView != null){
                previousView.setSelected(true);
                previousView.setBackground(getResources().getDrawable(R.drawable.choices_button_normal));
                previousView.setPadding(20, 20, 0, 0);
            }
            v.setSelected(false);
            choicedSelected++;
            buttonSelected = 4;
            v.setBackground(getResources().getDrawable(R.drawable.choices_button_pressed));
            v.setPadding(30, 40, 0, 0);
            previousView = v;
        }
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
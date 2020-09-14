package klaudia.gogola.quizapp_zgadnijzwierzaka;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Collections;
import java.util.List;

import klaudia.gogola.quizapp_zgadnijzwierzaka.Model.Question;
import klaudia.gogola.quizapp_zgadnijzwierzaka.DbHelper.SymbolDbHelper;

public class SymbolActivity extends AppCompatActivity {

    private ImageView textViewQuestion;
    private TextView textViewScore, textViewQuestionCount, titleQuestion;
    private ProgressBar progressBar;

    private Button button1, button2, button3, button4;
    private ImageButton buttonBack;


    private int questionCounter =0, index = 0, questionCountTotal, score;

    private List<Question> questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symbol);

        textViewQuestion = findViewById(R.id.imageQuestion);
        textViewScore = findViewById(R.id.textScored);
        textViewQuestionCount = findViewById(R.id.textCountQuestion);
        titleQuestion = findViewById(R.id.titleQuestion);
        progressBar = findViewById(R.id.progressBarCountQuestion);

        button1 = findViewById(R.id.buttonA);
        button2 = findViewById(R.id.buttonB);
        button3 = findViewById(R.id.buttonC);
        button4 = findViewById(R.id.buttonD);
        buttonBack = findViewById(R.id.buttonBack);

        Typeface fontFSymbol = Typeface.createFromAsset(getAssets(), "fonts/PatrickHandRegular.ttf");
        Typeface fontSSymbol = Typeface.createFromAsset(getAssets(), "fonts/NunitoBold.ttf");
        Typeface fontFtSymbol = Typeface.createFromAsset(getAssets(), "fonts/DosisSemiBold.ttf");

        titleQuestion.setTypeface(fontFSymbol);
        textViewQuestionCount.setTypeface(fontFtSymbol);

        button1.setTypeface(fontSSymbol);
        button2.setTypeface(fontSSymbol);
        button3.setTypeface(fontSSymbol);
        button4.setTypeface(fontSSymbol);


        SymbolDbHelper dbHelper = new SymbolDbHelper(this);
        questionList = dbHelper.getAllSymbolQuestions();
        questionCountTotal = questionList.size();
        Collections.shuffle(questionList);
        showNextQuestion(index);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToMenu = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(goToMenu);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                functionButtonA();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                functionButtonB();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                functionButtonC();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                functionButtonD();

            }
        });

    }


    private void functionButtonA(){

        if (button1.getText().equals(questionList.get(index).getAnswerNr())) {
            button1.setBackgroundResource(R.drawable.good);
            button1.setText("");
            score++;
            textViewScore.setText("Twój wynik to: " + score +"/" +questionCountTotal);
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
            nextQuestionDelayed();

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    button1.setBackgroundResource(R.drawable.buttona);
                    button1.setEnabled(true);
                    button2.setEnabled(true);
                    button3.setEnabled(true);
                    button4.setEnabled(true);
                }
            }, 1000);


        } else {
            button1.setBackgroundResource(R.drawable.bad);
            button1.setText("");
            nextQuestionDelayed();
            textViewScore.setText("Twój wynik to: " + score +"/" +questionCountTotal);
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    button1.setBackgroundResource(R.drawable.buttona);
                    button1.setEnabled(true);
                    button2.setEnabled(true);
                    button3.setEnabled(true);
                    button4.setEnabled(true);
                }
            }, 1000);

        }
    }

    private void functionButtonB(){


        if (button2.getText().equals(questionList.get(index).getAnswerNr())) {
            button2.setBackgroundResource(R.drawable.good);
            button2.setText("");
            score++;
            textViewScore.setText("Twój wynik to: " + score +"/" +questionCountTotal);
            nextQuestionDelayed();
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    button2.setBackgroundResource(R.drawable.buttonb);
                    button1.setEnabled(true);
                    button2.setEnabled(true);
                    button3.setEnabled(true);
                    button4.setEnabled(true);
                }
            }, 1000);


        } else {
            button2.setBackgroundResource(R.drawable.bad);
            button2.setText("");
            nextQuestionDelayed();
            textViewScore.setText("Twój wynik to: " + score +"/" +questionCountTotal);
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    button2.setBackgroundResource(R.drawable.buttonb);
                    button1.setEnabled(true);
                    button2.setEnabled(true);
                    button3.setEnabled(true);
                    button4.setEnabled(true);

                }
            }, 1000);

        }
    }

    private void functionButtonC(){

        if (button3.getText().equals(questionList.get(index).getAnswerNr())) {
            button3.setBackgroundResource(R.drawable.good);
            button3.setText("");
            score++;
            textViewScore.setText("Twój wynik to: " + score +"/" +questionCountTotal);
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
            nextQuestionDelayed();

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    button3.setBackgroundResource(R.drawable.buttonc);
                    button1.setEnabled(true);
                    button2.setEnabled(true);
                    button3.setEnabled(true);
                    button4.setEnabled(true);
                }
            }, 1000);


        } else {
            button3.setBackgroundResource(R.drawable.bad);
            button3.setText("");
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
            textViewScore.setText("Twój wynik to: " + score +"/" +questionCountTotal);
            nextQuestionDelayed();

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    button3.setBackgroundResource(R.drawable.buttonc);
                    button1.setEnabled(true);
                    button2.setEnabled(true);
                    button3.setEnabled(true);
                    button4.setEnabled(true);
                }
            }, 1000);

        }
    }

    private void functionButtonD(){

        if (button4.getText().equals(questionList.get(index).getAnswerNr())) {
            button4.setBackgroundResource(R.drawable.good);
            button4.setText("");
            score++;
            textViewScore.setText("Twój wynik to: " + score +"/" +questionCountTotal);
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
            nextQuestionDelayed();

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    button4.setBackgroundResource(R.drawable.buttond);
                    button1.setEnabled(true);
                    button2.setEnabled(true);
                    button3.setEnabled(true);
                    button4.setEnabled(true);
                }
            }, 1000);


        } else {
            button4.setBackgroundResource(R.drawable.bad);
            button4.setText("");
            nextQuestionDelayed();
            textViewScore.setText("Twój wynik to: " + score +"/" +questionCountTotal);
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    button4.setBackgroundResource(R.drawable.buttond);
                    button1.setEnabled(true);
                    button2.setEnabled(true);
                    button3.setEnabled(true);
                    button4.setEnabled(true);
                }
            }, 1000);

        }
    }

    private void nextQuestionDelayed(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                showNextQuestion(++index);
            }
        }, 1000);
    }


    private void showNextQuestion(int index) {
        if (index < questionCountTotal) {
            questionCounter++;

            int ImageId=this.getResources().getIdentifier(questionList.get(index).getQuestion().toLowerCase(),"drawable",getPackageName());
            textViewQuestion.setBackgroundResource(ImageId);

            button1.setText(questionList.get(index).getOption1());
            button2.setText(questionList.get(index).getOption2());
            button3.setText(questionList.get(index).getOption3());
            button4.setText(questionList.get(index).getOption4());


            progressBar.setProgress(0);
            progressBar.setMax(questionCountTotal);
            progressBar.setProgress(questionCounter);

            textViewQuestionCount.setText(questionCounter + "/" + questionCountTotal);
        } else {
            goDone();
        }
    }




    private void goDone() {

        String result = textViewScore.getText().toString();
        Intent intent = new Intent(this, SymbolDone.class);
        intent.putExtra("wynik", result);
        startActivity(intent);
        finish();
    }


}
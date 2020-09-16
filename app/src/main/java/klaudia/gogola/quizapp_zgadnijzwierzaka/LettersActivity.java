package klaudia.gogola.quizapp_zgadnijzwierzaka;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import klaudia.gogola.quizapp_zgadnijzwierzaka.AdapterGridView.AnswerAdapter;
import klaudia.gogola.quizapp_zgadnijzwierzaka.AdapterGridView.SuggestAdapter;
import klaudia.gogola.quizapp_zgadnijzwierzaka.DbHelper.LettersDbHelper;
import klaudia.gogola.quizapp_zgadnijzwierzaka.Model.Question;

public class LettersActivity extends AppCompatActivity {

    private List<Question> questionList;

    ImageButton buttonBack;
    private int questionCounter = 0;
    private int index = 0, score;
    private int questionCountTotal;
    private ProgressBar progressBar;
    private TextView textViewQuestionCount, titleQuestion, textViewScore;

    public List<String> suggestSource = new ArrayList<>();
    public AnswerAdapter answerAdapter;
    public SuggestAdapter suggestAdapter;

    public Button btnSubmit;
    public GridView gridViewAnswer, gridViewSuggest;

    public ImageView imgViewQuestion;

    public char[] answer;
    String correct_answer;

    public static char[] user_submit_answer;
    public static String[] alphabet_character={
            "a", "ą", "b", "c", "ć", "d", "e", "ę", "f", "g", "h", "i", "j", "k", "l", "ł",
            "m", "n", "ń", "o", "ó", "p", "q", "r", "s", "ś", "t", "u", "v", "w", "x", "y", "z", "ź", "ż"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letters);

        LettersDbHelper dbHelper = new LettersDbHelper(this);
        questionList = dbHelper.getAllLettersQuestions();
        questionCountTotal = 20;
        Collections.shuffle(questionList);


        buttonBack = findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToMenu = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(goToMenu); }

        });

                gridViewAnswer = (GridView) findViewById(R.id.gridViewAnswer);
                gridViewSuggest = (GridView) findViewById(R.id.gridViewSuggest);

                imgViewQuestion = (ImageView) findViewById(R.id.imageQuestion);
                textViewQuestionCount = findViewById(R.id.textCountQuestion);
                progressBar = findViewById(R.id.progressBarCountQuestion);
        titleQuestion = findViewById(R.id.titleQuestion);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        textViewScore = findViewById(R.id.textScored);


        Typeface fontFAnimal = Typeface.createFromAsset(getAssets(), "fonts/PatrickHandRegular.ttf");
        Typeface fontSAnimal = Typeface.createFromAsset(getAssets(), "fonts/NunitoBold.ttf");
        Typeface fontFtAnimal = Typeface.createFromAsset(getAssets(), "fonts/DosisSemiBold.ttf");

        titleQuestion.setTypeface(fontFAnimal);
        textViewQuestionCount.setTypeface(fontFtAnimal);
        btnSubmit.setTypeface(fontSAnimal);


        setupList(index);


                btnSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String result="";
                        for(int i=0; i< user_submit_answer.length;i++)
                            result+=String.valueOf(user_submit_answer[i]); // ładowanie liter wpisanych przez użytkownika
                        if(result.equals(correct_answer)) // sprawdzanie czy to co wpisane jest poprawne
                        {
                            score++;
                            textViewScore.setText("Twój wynik to: " + score +"/" +questionCountTotal);
                            btnSubmit.setBackgroundResource(R.drawable.goodletter);
                            btnSubmit.setText("");
                            btnSubmit.setEnabled(false);
                            final Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    setupList(index++);
                                    btnSubmit.setText("Sprawdź odpowiedź");
                                    btnSubmit.setEnabled(true);
                                    btnSubmit.setBackgroundResource(R.drawable.orangeback);
                                }
                            }, 1000);
                        }
                        else{
                            btnSubmit.setBackgroundResource(R.drawable.badletter);
                            btnSubmit.setText("");
                            textViewScore.setText("Twój wynik to: " + score +"/" +questionCountTotal);
                            final Handler handler = new Handler();
                            btnSubmit.setEnabled(false);
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    setupList(index++);
                                    btnSubmit.setText("Sprawdź odpowiedź");
                                    btnSubmit.setEnabled(true);
                                    btnSubmit.setBackgroundResource(R.drawable.orangeback);
                                }
                            }, 1000);
                        }
                    }


                }); }


            private void setupList(int next) {

                Random random = new Random();

                if (index < 20) {
                    //currentQuestion = questionList.get(questionCounter);
                    questionCounter++;
                    progressBar.setProgress(0);
                    progressBar.setMax(questionCountTotal);
                    progressBar.setProgress(questionCounter);

                    textViewQuestionCount.setText(questionCounter + "/" + questionCountTotal);

                    int ImageId=this.getResources().getIdentifier(questionList.get(index).getQuestion().toLowerCase(),"drawable",getPackageName());
                    imgViewQuestion.setBackgroundResource(ImageId);
                    //randomowanie listy zdjęć
                    //ładowanie zdjęć

                    String text = questionList.get(index).getAnswerNr();
                    correct_answer = text;

                            //dobra odpowiedz to nazwa zdjecia
                    correct_answer = correct_answer.substring(correct_answer.lastIndexOf("/") + 1); //ilość kratek na dobra odpowiedz

                    answer = correct_answer.toCharArray(); //tablica zapisuje poprawną odpowiedz
                    user_submit_answer = new char[answer.length]; //ustalanie długi odpowiedzi tablic wpisywanej przez użtkownika

                    suggestSource.clear();
                    for (char item : answer) {
                        suggestSource.add(String.valueOf(item)); //ładowanie liter poprawnych do listy
                    }

                    for (int i = answer.length; i < answer.length + 8; i++)
                        suggestSource.add(alphabet_character[random.nextInt(alphabet_character.length)]); //dodawanie innych liter do tablicy

                    Collections.shuffle(suggestSource); //tasowanie

                    answerAdapter = new AnswerAdapter(setupNullList(), this); //ładowanie literek odpowiedzi do gridu odpowiedzi
                    suggestAdapter = new SuggestAdapter(suggestSource, this, this);

                    answerAdapter.notifyDataSetChanged();
                    suggestAdapter.notifyDataSetChanged();

                    gridViewSuggest.setAdapter(suggestAdapter);
                    gridViewAnswer.setAdapter(answerAdapter);
                } else {
                    String result = textViewScore.getText().toString();
                    Intent intent = new Intent(this, LettersDone.class);
                    intent.putExtra("wynik", result);
                    startActivity(intent);
                    finish();
                }
            }

    private char[] setupNullList() {
        char result[] = new char[answer.length];
        for(int i=0; i<answer.length;i++)
            result[i] =' ';
        return result;
    }
    }
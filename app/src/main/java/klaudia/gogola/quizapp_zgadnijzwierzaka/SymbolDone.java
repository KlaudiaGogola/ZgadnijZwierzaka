package klaudia.gogola.quizapp_zgadnijzwierzaka;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SymbolDone extends AppCompatActivity {

    TextView textResultScore, textEnd;
    Button buttonPlayAgain, buttonChangeGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);

        textResultScore = (TextView)findViewById(R.id.textResultScore);
        buttonPlayAgain = (Button) findViewById(R.id.buttonPlayAgain);
        buttonChangeGame = (Button) findViewById(R.id.buttonChangeGame);
        textEnd = (TextView) findViewById(R.id.textEnd);

        Intent intent = getIntent();
        String result = intent.getStringExtra("wynik");
        textResultScore.setText(result);

        Typeface fontFSymbolDone = Typeface.createFromAsset(getAssets(), "fonts/PatrickHandRegular.ttf");
        Typeface fontSSymbolDone = Typeface.createFromAsset(getAssets(), "fonts/DosisBold.ttf");

        textResultScore.setTypeface(fontFSymbolDone);
        textEnd.setTypeface(fontFSymbolDone);
        buttonChangeGame.setTypeface(fontSSymbolDone);
        buttonPlayAgain.setTypeface(fontSSymbolDone);


        buttonPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToSymbolActivity = new Intent(getApplicationContext(), SymbolActivity.class);
                startActivity(goToSymbolActivity);
            }
        });

        buttonChangeGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToMenu = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(goToMenu);
            }
        });

    }
}
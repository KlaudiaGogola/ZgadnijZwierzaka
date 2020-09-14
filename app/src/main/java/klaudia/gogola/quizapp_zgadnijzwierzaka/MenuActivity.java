package klaudia.gogola.quizapp_zgadnijzwierzaka;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    private static final String TAG = "MenuActivity";

    private TextView nameReceivedText, helloText;
    private Button buttonAnimal, buttonSymbol, buttonInformation, buttonSound, buttonLetters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        nameReceivedText = (TextView)findViewById(R.id.nameReceivedText);
        helloText = (TextView) findViewById(R.id.helloText);
        buttonSymbol = (Button) findViewById(R.id.buttonMenuSecond);
        buttonAnimal = (Button) findViewById(R.id.buttonMenuFourth);
        buttonSound = (Button) findViewById(R.id.buttonMenuThird);
        buttonLetters = (Button) findViewById(R.id.buttonMenuFirst);

        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = mPreferences.edit();

        String name = mPreferences.getString(getString(R.string.name), "");
        nameReceivedText.setText(name + "!");

        Typeface fontFirst = Typeface.createFromAsset(getAssets(), "fonts/PatrickHandRegular.ttf");
        Typeface fontSecond = Typeface.createFromAsset(getAssets(), "fonts/NunitoBold.ttf");

        helloText.setTypeface(fontFirst);
        nameReceivedText.setTypeface(fontSecond);

        buttonSymbol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToSymbolActivity = new Intent(getApplicationContext(), SymbolActivity.class);
                startActivity(goToSymbolActivity);
            }
        });
        buttonAnimal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                Intent goToAnimalActivity = new Intent(getApplicationContext(), AnimalActivity.class);
                startActivity(goToAnimalActivity);
                    }
                });

        buttonSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToSoundActivity = new Intent(getApplicationContext(), SoundActivity.class);
                startActivity(goToSoundActivity);
            }
        });

        buttonLetters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToLettersActivity = new Intent(getApplicationContext(), LettersActivity.class);
                startActivity(goToLettersActivity);
            }
        });




    }
}
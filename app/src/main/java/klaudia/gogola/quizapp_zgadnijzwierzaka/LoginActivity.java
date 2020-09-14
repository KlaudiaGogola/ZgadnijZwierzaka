package klaudia.gogola.quizapp_zgadnijzwierzaka;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    private TextView nameText;
    private Button nextButton;
    private EditText nameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Typeface fontFirst = Typeface.createFromAsset(getAssets(), "fonts/PatrickHandRegular.ttf");
        Typeface fontSecond = Typeface.createFromAsset(getAssets(), "fonts/NunitoBold.ttf");
        nameText = (TextView) findViewById(R.id.nameText);
        nextButton = (Button) findViewById(R.id.nextButton);
        nameEditText = (EditText) findViewById(R.id.nameEditText);

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();

        nameText.setTypeface(fontFirst);
        nextButton.setTypeface(fontSecond);
        nameEditText.setTypeface(fontSecond);


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEditText.getText().toString();

                if(name.equals("")){
                    name="Nieznajomy";
                    mEditor.putString(getString(R.string.name), name);
                    mEditor.commit();
                } else {
                    mEditor.putString(getString(R.string.name), name);
                    mEditor.commit();
                }
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
            }
        });


    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }

}
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

    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginEditor;

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

        nameText.setTypeface(fontFirst);
        nextButton.setTypeface(fontSecond);
        nameEditText.setTypeface(fontSecond);


        loginPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        loginEditor = loginPreferences.edit();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEditText.getText().toString();

                if(name.equals("")){
                    name="Nieznajomy";
                    loginEditor.putString(getString(R.string.name), name);

                    loginEditor.commit();
                } else {
                    loginEditor.putString(getString(R.string.name), name);
                    loginEditor.commit();
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
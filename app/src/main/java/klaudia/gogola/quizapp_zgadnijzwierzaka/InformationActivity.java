package klaudia.gogola.quizapp_zgadnijzwierzaka;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import klaudia.gogola.quizapp_zgadnijzwierzaka.AdapterGridView.ViewAdapter;
import klaudia.gogola.quizapp_zgadnijzwierzaka.DbHelper.InfoDbHelper;

public class InformationActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageButton buttonBack;
    TextView textList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        buttonBack = (ImageButton) findViewById(R.id.buttonBack);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        textList = (TextView) findViewById(R.id.textList);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        ViewAdapter adapter = new ViewAdapter(InformationActivity.this, InfoDbHelper.getInstance(this).getAllAnimal());
        recyclerView.setAdapter(adapter);

        Typeface fontNunito = Typeface.createFromAsset(getAssets(), "fonts/NunitoBold.ttf");
        textList.setTypeface(fontNunito);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToMenu = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(goToMenu);
            }
        });




    }
}
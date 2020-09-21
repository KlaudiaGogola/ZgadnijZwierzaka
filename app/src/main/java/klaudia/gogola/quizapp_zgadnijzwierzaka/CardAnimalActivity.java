package klaudia.gogola.quizapp_zgadnijzwierzaka;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import klaudia.gogola.quizapp_zgadnijzwierzaka.DbHelper.InfoDbHelper;
import klaudia.gogola.quizapp_zgadnijzwierzaka.Model.Common;
import klaudia.gogola.quizapp_zgadnijzwierzaka.Model.Information;

public class CardAnimalActivity extends AppCompatActivity {
    private TextView textName, text, text2, text3, text4, text5, text6, text7, text8, text9, textImage;
    private Information animal;
    private ImageButton buttonBack;
    private List<Information> informations;
    private int index =0;
    private ImageView imageAnimals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_animal);

        buttonBack = (ImageButton) findViewById(R.id.buttonBack);
        textName = (TextView) findViewById(R.id.textName);
        text = (TextView) findViewById(R.id.text);
        text2 = (TextView) findViewById(R.id.text2);
        text3 = (TextView) findViewById(R.id.text3);
        text4 = (TextView) findViewById(R.id.text4);
        text5 = (TextView) findViewById(R.id.text5);
        text6 = (TextView) findViewById(R.id.text6);
        text7 = (TextView) findViewById(R.id.text7);
        text8 = (TextView) findViewById(R.id.text8);
        text9 = (TextView) findViewById(R.id.text9);
        textImage = (TextView) findViewById(R.id.textImage);
        imageAnimals = (ImageView) findViewById(R.id.imageNew);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goBacktoInformationActivity = new Intent(CardAnimalActivity.this, InformationActivity.class);
                startActivity(goBacktoInformationActivity);
            }
        });

        Typeface fontNunito = Typeface.createFromAsset(getAssets(), "fonts/NunitoBold.ttf");
        textName.setTypeface(fontNunito);
        text.setTypeface(fontNunito);
        text2.setTypeface(fontNunito);
        text3.setTypeface(fontNunito);
        text4.setTypeface(fontNunito);
        text5.setTypeface(fontNunito);
        text6.setTypeface(fontNunito);
        text7.setTypeface(fontNunito);
        text8.setTypeface(fontNunito);
        text9.setTypeface(fontNunito);
        textImage.setTypeface(fontNunito);

        Common.questionList = InfoDbHelper.getInstance(this).getInformationbyAnimal(Common.selectedAnimal.getId());
        textName.setText(Common.selectedAnimal.getName());

        imageAnimals.setClipToOutline(true);
        animal = Common.questionList.get(index);

        text.setText("Gatunek: " + animal.getGatunek());
        text2.setText("Rodzina: " + animal.getRodzina());
        text3.setText("Gromada: " + animal.getGromada());
        text4.setText("Środowisko: " + animal.getSrodowisko());
        text5.setText("Występowanie: " + animal.getWystepowanie());
        text6.setText("Tryb życia: " + animal.getTrybzycia());
        text7.setText("Odżywianie: " + animal.getOdzywianie());
        text8.setText("Ubarwienie: " + animal.getUbarwienie());
        text9.setText("Kategoria zagrożenia: " + animal.getKategoriazagrozenia());



        Picasso.get().load(animal.getImage()).into(imageAnimals, new Callback() {
            @Override
            public void onSuccess() {
            }

            @Override
            public void onError(Exception e) {
                textImage.setText("Zdjęcie: " + animal.getGatunek());
            }
        });


    }

}
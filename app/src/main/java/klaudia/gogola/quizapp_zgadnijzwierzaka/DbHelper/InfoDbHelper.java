package klaudia.gogola.quizapp_zgadnijzwierzaka.DbHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

import klaudia.gogola.quizapp_zgadnijzwierzaka.Model.Animal;
import klaudia.gogola.quizapp_zgadnijzwierzaka.Model.Information;

public class InfoDbHelper extends SQLiteAssetHelper {

    private static final String DB_NAME = "CardAnimalBase.db";
    private static final int DB_VER = 1;

    private static InfoDbHelper instance;
    public static synchronized InfoDbHelper getInstance(Context context){
        if(instance == null)
            instance = new InfoDbHelper(context);
        return instance;
    }

    public InfoDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    public List<Animal> getAllAnimal(){
        SQLiteDatabase db = instance.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM Animal;", null);
        List<Animal> animals = new ArrayList<>();
        if(cursor.moveToFirst())
        {
            while(!cursor.isAfterLast())
            {
                Animal category = new Animal(cursor.getInt(cursor.getColumnIndex("ID")),
                        cursor.getString(cursor.getColumnIndex("Name")));

                animals.add(category);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();

        return animals;
    }
    public List<Information> getInformationbyAnimal (int category){

        SQLiteDatabase db = instance.getWritableDatabase();

        Cursor cursor = db.rawQuery(String.format("SELECT * FROM Information WHERE CategoryID = %d ORDER BY RANDOM() LIMIT 30", category), null);
        List<Information> informations = new ArrayList<>();
        if(cursor.moveToFirst())
        {
            while(!cursor.isAfterLast())
            {
                Information information = new Information(cursor.getInt(cursor.getColumnIndex("ID")),
                        cursor.getString(cursor.getColumnIndex("Image")),
                        cursor.getString(cursor.getColumnIndex("Gatunek")),
                        cursor.getString(cursor.getColumnIndex("Rodzina")),
                        cursor.getString(cursor.getColumnIndex("Gromada")),
                        cursor.getString(cursor.getColumnIndex("Środowisko")),
                        cursor.getString(cursor.getColumnIndex("Występowanie")),
                        cursor.getString(cursor.getColumnIndex("Trybżycia")),
                        cursor.getString(cursor.getColumnIndex("Odżywianie")),
                        cursor.getString(cursor.getColumnIndex("Ubarwienie")),
                        cursor.getString(cursor.getColumnIndex("Kategoriazagrożenia")),
                        cursor.getInt(cursor.getColumnIndex("CategoryID")));

                informations.add(information);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();

        return informations;

    }

}



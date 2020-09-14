package klaudia.gogola.quizapp_zgadnijzwierzaka.DbHelper;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import klaudia.gogola.quizapp_zgadnijzwierzaka.Model.Contract.*;
import klaudia.gogola.quizapp_zgadnijzwierzaka.Model.Question;

public class AnimalDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "AnimalDataBase.db";
    private static final int DATABASE_VERSION = 2;
    private SQLiteDatabase db;


        public AnimalDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " TEXT" +
                ")";
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }


    private void fillQuestionsTable() {
        Question question1 = new Question("delfin", "Rekin", "Mysz", "Delfin", "Pies", "Delfin");
        addQuestion(question1);
        Question question2 = new Question("lew", "Panda", "Lew", "Małpa", "Delfin", "Lew");
        addQuestion(question2);
        Question question3 = new Question("szop", "Rekin", "Panda", "Szop", "Żółw", "Szop");
        addQuestion(question3);
        Question question4 = new Question("tygrys", "Wieloryb", "Koń", "Tygrys", "Ptak", "Tygrys");
        addQuestion(question4);
        Question question5 = new Question("lis", "Lis", "Szop", "Kot", "Pies", "Lis");
        addQuestion(question5);
        Question question6 = new Question("flaming", "Jeleń", "Flaming", "Koala", "Panda", "Flaming");
        addQuestion(question6);
        Question question7 = new Question("hipcio", "Rybka", "Hipopotam", "Małpa", "Żółw", "Hipopotam");
        addQuestion(question7);
        Question question8 = new Question("malpa", "Małpa", "Mysz", "Tygrys", "Pająk", "Małpa");
        addQuestion(question8);
        Question question9 = new Question("zyrafa", "Żyrafa", "Panda", "Pingwin", "Wieloryb", "Żyrafa");
        addQuestion(question9);
        Question question10 = new Question("mis", "Królik", "Flaming", "Żółw", "Niedźwiedź", "Niedźwiedź");
        addQuestion(question10);
        Question question11 = new Question("kangurki", "Pingwin", "Wieloryb", "Owca", "Kangur", "Kangur");
        addQuestion(question11);
        Question question12 = new Question("koala", "Rekin", "Jeleń", "Koala", "Panda", "Koala");
        addQuestion(question12);
        Question question13 = new Question("panda", "Koń", "Jeleń", "Małpa", "Panda", "Panda");
        addQuestion(question13);
        Question question14 = new Question("pies", "Alpaka", "Sarna", "Pies", "Rybka", "Pies");
        addQuestion(question14);
        Question question15 = new Question("kot", "Alpaka", "Słoń", "Kot", "Pies", "Kot");
        addQuestion(question15);
        Question question16 = new Question("kroko", "Krokodyl", "Kangur", "Niedźwiedź", "Hipopotam", "Krokodyl");
        addQuestion(question16);
        Question question17 = new Question("pingwin", "Pingwin", "Lis", "Flaming", "Kot", "Pingwin");
        addQuestion(question17);
        Question question18 = new Question("krolik", "Żółw", "Królik", "Alpaka", "Szop", "Królik");
        addQuestion(question18);
        Question question19 = new Question("sarenka", "Szop", "Pingwin", "Sarna", "Słoń", "Sarna");
        addQuestion(question19);
        Question question20 = new Question("slon", "Lew", "Tygrys", "Flaming", "Słoń", "Słoń");
        addQuestion(question20);
        Question question21 = new Question("lama", "Alpaka", "Delfin", "Lew", "Krokodyl", "Alpaka");
        addQuestion(question21);

    }


    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_OPTION4, question.getOption4());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);


    }


    public List<Question> getAllAnimalQuestions() {
        List<Question> questionAnimalList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                questionAnimalList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionAnimalList;
    }






}

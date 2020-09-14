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

public class SymbolDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "SymbolDataBase.db";
    private static final int DATABASE_VERSION = 4;
    private SQLiteDatabase db;


    public SymbolDbHelper(Context context) {
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
        Question question1 = new Question("fin", "Rekin", "Mysz", "Małpa", "Pies", "Rekin");
        addQuestion(question1);
        Question question2 = new Question("jungle", "Panda", "Ptak", "Małpa", "Pies", "Małpa");
        addQuestion(question2);
        Question question3 = new Question("bamboo", "Rekin", "Panda", "Owca", "Żółw", "Panda");
        addQuestion(question3);
        Question question4 = new Question("birdhouse", "Wieloryb", "Koń", "Małpa", "Ptak", "Ptak");
        addQuestion(question4);
        Question question5 = new Question("mouse", "Rekin", "Mysz", "Kot", "Pies", "Kot");
        addQuestion(question5);
        Question question6 = new Question("sheep", "Jeleń", "Owca", "Kura", "Koń", "Owca");
        addQuestion(question6);
        Question question7 = new Question("bone", "Rybka", "Pies", "Małpa", "Żółw", "Pies");
        addQuestion(question7);
        Question question8 = new Question("cheese", "Rekin", "Mysz", "Kura", "Pająk", "Mysz");
        addQuestion(question8);
        Question question9 = new Question("spiderweb", "Owca", "Panda", "Pająk", "Wieloryb", "Pająk");
        addQuestion(question9);
        Question question10 = new Question("turtle", "Kura", "Jeleń", "Żółw", "Pies", "Żółw");
        addQuestion(question10);
        Question question11 = new Question("whale", "Rekin", "Wieloryb", "Owca", "Pies", "Wieloryb");
        addQuestion(question11);
        Question question12 = new Question("chicken", "Rekin", "Jeleń", "Kura", "Wieloryb", "Kura");
        addQuestion(question12);
        Question question13 = new Question("deer", "Koń", "Jeleń", "Małpa", "Rybka", "Jeleń");
        addQuestion(question13);
        Question question14 = new Question("fishbowl", "Rekin", "Pająk", "Małpa", "Rybka", "Rybka");
        addQuestion(question14);
        Question question15 = new Question("horseshoe", "Panda", "Mysz", "Koń", "Pies", "Koń");
        addQuestion(question15);

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


    public List<Question> getAllSymbolQuestions() {
        List<Question> questionSymbolList = new ArrayList<>();
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
                questionSymbolList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionSymbolList;
    }

}

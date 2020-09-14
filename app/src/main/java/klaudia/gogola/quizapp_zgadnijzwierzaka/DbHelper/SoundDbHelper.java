package klaudia.gogola.quizapp_zgadnijzwierzaka.DbHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import klaudia.gogola.quizapp_zgadnijzwierzaka.Model.Contract.QuestionsTable;
import klaudia.gogola.quizapp_zgadnijzwierzaka.Model.SoundQuestion;

public class SoundDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "SoundDataBase.db";
    private static final int DATABASE_VERSION = 2;
    private SQLiteDatabase db;

    public SoundDbHelper(Context context) {
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
                QuestionsTable.COLUMN_SOUND + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " TEXT," +
                QuestionsTable.COLUMN_IMAGE + " TEXT " +
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
        SoundQuestion question1 = new SoundQuestion("delfin", "Rekin", "Żyrafa", "Delfin","Pies", "delfin", "Delfin","delfinblack");
        addQuestion(question1);
        SoundQuestion question2 = new SoundQuestion("lew", "Kot", "Lew", "Szop", "Rekin", "lew", "Lew", "lewblack");
        addQuestion(question2);
        SoundQuestion question3 = new SoundQuestion("szop", "Żółw", "Panda", "Szop", "Krokodyl", "szop", "Szop", "szopblack");
        addQuestion(question3);
        SoundQuestion question4 = new SoundQuestion("tygrys", "Wieloryb", "Małpa", "Tygrys", "Lis", "tygrys", "Tygrys", "tygrysblack");
        addQuestion(question4);
        SoundQuestion question5 = new SoundQuestion("lis", "Lis", "Alpaka", "Kot", "Flaming", "lis", "Lis", "lisblack");
        addQuestion(question5);
        SoundQuestion question6 = new SoundQuestion("slon", "Lew", "Delfin", "Krokodyl", "Słoń", "slon", "Słoń", "slonblack");
        addQuestion(question6);
        SoundQuestion question7 = new SoundQuestion("hipcio", "Rybka", "Hipopotam", "Koala", "Żółw", "hipcio", "Hipopotam", "hipcioblack");
        addQuestion(question7);
        SoundQuestion question8 = new SoundQuestion("malpa", "Małpa", "Kangur", "Żyrafa", "Królik", "malpa","Małpa", "malpablack");
        addQuestion(question8);
        SoundQuestion question9 = new SoundQuestion("pingwin", "Pingwin", "Lis", "Słoń", "Tygrys","pingwin", "Pingwin", "pingwinblack");
        addQuestion(question9);
        SoundQuestion question10 = new SoundQuestion("mis", "Królik", "Koala", "Szop", "Niedźwiedź", "mis", "Niedźwiedź", "misblack");
        addQuestion(question10);
        SoundQuestion question11 = new SoundQuestion("pies", "Alpaka", "Sarna", "Pies", "Wieloryb", "pies", "Pies", "piesblack");
        addQuestion(question11);
        SoundQuestion question12 = new SoundQuestion("kot", "Krokodyl", "Słoń", "Kot", "Rekin", "kot", "Kot", "kotblack");
        addQuestion(question12);
        SoundQuestion question13 = new SoundQuestion("kroko", "Krokodyl", "Kangur", "Niedźwiedź", "Hipopotam","kroko", "Krokodyl", "krokoblack");
        addQuestion(question13);


    }

    private void addQuestion(SoundQuestion question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_OPTION4, question.getOption4());
        cv.put(QuestionsTable.COLUMN_SOUND, question.getSound());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        cv.put(QuestionsTable.COLUMN_IMAGE, question.getImage());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }


    public List<SoundQuestion> getAllSoundQuestions() {
        List<SoundQuestion> questionSoundList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);
        if (c.moveToFirst()) {
            do {
                SoundQuestion question = new SoundQuestion();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setSound(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_SOUND)));
                question.setAnswerNr(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setImage(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_IMAGE)));
                questionSoundList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionSoundList;
    }



}

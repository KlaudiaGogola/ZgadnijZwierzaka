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

public class LettersDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "LettersDataBase.db";
    private static final int DATABASE_VERSION = 3;
    private SQLiteDatabase db;

    public LettersDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " TEXT " +
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
            Question question1 = new Question("delfin", "DELFIN");
        addQuestion(question1);
        Question question2 = new Question("lew", "LEW");
        addQuestion(question2);
        Question question3 = new Question("szop", "SZOP");
        addQuestion(question3);
        Question question4 = new Question("tygrys", "TYGRYS");
        addQuestion(question4);
        Question question5 = new Question("lis", "LIS");
        addQuestion(question5);
        Question question6 = new Question("flaming", "FLAMING");
        addQuestion(question6);
        Question question7 = new Question("hipcio", "HIPOPOTAM");
        addQuestion(question7);
        Question question8 = new Question("malpa", "MAŁPA");
        addQuestion(question8);
        Question question9 = new Question("zyrafa", "ŻYRAFA");
        addQuestion(question9);
        Question question10 = new Question("mis", "NIEDŹWIEDŹ");
        addQuestion(question10);
        Question question11 = new Question("kangurki","KANGUR");
        addQuestion(question11);
        Question question12 = new Question("koala", "KOALA");
        addQuestion(question12);
        Question question13 = new Question("panda", "PANDA");
        addQuestion(question13);
        Question question14 = new Question("pies",  "PIES");
        addQuestion(question14);
        Question question15 = new Question("kot", "KOT");
        addQuestion(question15);
        Question question16 = new Question("kroko", "KROKODYL");
        addQuestion(question16);
        Question question17 = new Question("pingwin", "PINGWIN");
        addQuestion(question17);
        Question question18 = new Question("krolik",  "KRÓLIK");
        addQuestion(question18);
        Question question19 = new Question("sarenka", "SARNA");
        addQuestion(question19);
        Question question20 = new Question("slon", "SŁOŃ");
        addQuestion(question20);
        Question question21 = new Question("lama", "ALPAKA");
        addQuestion(question21);
        Question question22 = new Question("kaczka", "KACZKA");
        addQuestion(question22);
        Question question23 = new Question("snake",  "WĄŻ");
        addQuestion(question23);

    }

    private void addQuestion (Question question){
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }


    public List<Question> getAllLettersQuestions() {
        java.util.List<Question> questionLettersList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);
        if (c.moveToFirst()) {
            do {
                Question question = new Question("zyrafa", "żyrafa");
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setAnswerNr(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                questionLettersList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionLettersList;
    }


}

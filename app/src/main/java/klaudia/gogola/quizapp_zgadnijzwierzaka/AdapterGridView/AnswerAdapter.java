package klaudia.gogola.quizapp_zgadnijzwierzaka.AdapterGridView;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import klaudia.gogola.quizapp_zgadnijzwierzaka.R;

public class AnswerAdapter extends BaseAdapter {

    private char[] answerCharacter;
    private Context context;

    public AnswerAdapter (char[] answerCharacter, Context context){
        this.answerCharacter = answerCharacter;
        this. context = context;
    }

    @Override
    public int getCount() {
        return answerCharacter.length;
    }

    @Override
    public Object getItem(int position) {
        return answerCharacter[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        TextView textAnswer;
        if(convertView == null){

            textAnswer = new TextView(context);
            textAnswer.setGravity(Gravity.CENTER);
            textAnswer.setLayoutParams(new GridView.LayoutParams(100,100));
            textAnswer.setPadding(8,8,8,8);
            textAnswer.setText(String.valueOf(answerCharacter[position]));
            textAnswer.getResources().getColor(R.color.colorLetters);
            textAnswer.setBackgroundResource(R.drawable.letterbase);


            textAnswer.setFocusable(true);

        }
        else{
            textAnswer=(TextView) convertView;
        }
        return textAnswer;
    }
}

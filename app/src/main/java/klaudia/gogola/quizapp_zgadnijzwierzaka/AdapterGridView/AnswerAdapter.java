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


        TextView button;
        if(convertView == null){

            button = new TextView(context);
            button.setGravity(Gravity.CENTER);
            button.setLayoutParams(new GridView.LayoutParams(100,100));
            button.setPadding(8,8,8,8);
            button.setText(String.valueOf(answerCharacter[position]));
            button.getResources().getColor(R.color.colorLetters);
            button.setBackgroundResource(R.drawable.letterbase);


            button.setFocusable(true);

        }
        else{
            button=(TextView) convertView;
        }
        return button;
    }
}

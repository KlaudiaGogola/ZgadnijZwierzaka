package klaudia.gogola.quizapp_zgadnijzwierzaka.AdapterGridView;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.util.List;

import klaudia.gogola.quizapp_zgadnijzwierzaka.LettersActivity;
import klaudia.gogola.quizapp_zgadnijzwierzaka.R;

public class SuggestAdapter extends BaseAdapter {

    private List<String> suggestSource;
    private Context context;
    private LettersActivity lettersActivity;

    public SuggestAdapter(List<String> suggestSource, Context context, LettersActivity lettersActivity) {
        this.suggestSource = suggestSource;
        this.context = context;
        this.lettersActivity = lettersActivity;
    }

    @Override
    public int getCount() {
        return suggestSource.size();
    }

    @Override
    public Object getItem(int position) {
        return suggestSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        TextView button;
        if (convertView == null) {

            if (suggestSource.get(position).equals("null")) {
                button = new TextView(context);
                button.setLayoutParams(new GridView.LayoutParams(85, 85));
                button.setPadding(8, 8, 8, 8);
                button.setBackgroundColor(Color.WHITE);



            } else {
                button = new TextView(context);
                button.setLayoutParams(new GridView.LayoutParams(85, 85));
                button.setPadding(20, 20, 20, 20);
                button.setAllCaps(true);
                button.getResources().getColor(R.color.colorLetters);
                button.setGravity(Gravity.CENTER);
                button.setBackgroundResource(R.drawable.letterback);
                button.setFocusable(true);
                button.setText(suggestSource.get(position));
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(String.valueOf(lettersActivity.answer).contains(suggestSource.get(position)))
                        {
                            char compare = suggestSource.get(position).charAt(0);

                            char[] user_submit_answer;
                            for(int i = 0; i<lettersActivity.answer.length; i++)
                            {
                                if(compare==lettersActivity.answer[i])
                                    LettersActivity.user_submit_answer[i] = compare;
                            }

                            AnswerAdapter answerAdapter = new AnswerAdapter(LettersActivity.user_submit_answer,context);
                            lettersActivity.gridViewAnswer.setAdapter(answerAdapter);
                            answerAdapter.notifyDataSetChanged();

                            lettersActivity.suggestSource.set(position,"null");
                            lettersActivity.suggestAdapter = new SuggestAdapter(lettersActivity.suggestSource,context,lettersActivity);
                            lettersActivity.gridViewSuggest.setAdapter(lettersActivity.suggestAdapter);
                            lettersActivity.suggestAdapter.notifyDataSetChanged();
                        }
                        else {
                            lettersActivity.suggestSource.set(position,"null");
                            lettersActivity.suggestAdapter = new SuggestAdapter(lettersActivity.suggestSource,context,lettersActivity);
                            lettersActivity.gridViewSuggest.setAdapter(lettersActivity.suggestAdapter);
                            lettersActivity.suggestAdapter.notifyDataSetChanged();
                        }
                    }
                });

            }
        }

        else
            button = (TextView) convertView;
        return button;
    }



}




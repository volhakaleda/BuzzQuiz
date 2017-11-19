package nyc.c4q.buzzfeed.view;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.buzzfeed.R;
import nyc.c4q.buzzfeed.model.City;
import nyc.c4q.buzzfeed.model.Omellette;

/**
 * Created by olgakoleda on 11/18/17.
 */

public class CityViewHolder extends RecyclerView.ViewHolder {

    private TextView question;
    private CardView answer1;
    private CardView answer2;

    public CityViewHolder(View itemView) {
        super(itemView);

        question = (TextView) itemView.findViewById(R.id.question_textview);
        answer1 = (CardView) itemView.findViewById(R.id.answer1_imagebutton);
        answer2 = (CardView) itemView.findViewById(R.id.answer2_imagebutton);

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                answer2.setImageAlpha(100);
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                answer1.setImageAlpha(100);
            }
        });
    }

    public void onBind(City city) {

        question.setText(city.getQuestion());
        answer1.setBackgroundResource(city.getOption1());
        answer2.setBackgroundResource(city.getOption2());
//        answer1.setImageAlpha(255);
//        answer2.setImageAlpha(255);
    }
}

package nyc.c4q.buzzfeed.view;

import android.support.annotation.DrawableRes;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import nyc.c4q.buzzfeed.R;
import nyc.c4q.buzzfeed.model.Omellette;


public class ChefViewHolder extends RecyclerView.ViewHolder {

    private TextView question;
    private CardView answer1;
    private CardView answer2;

    public ChefViewHolder(View itemView) {
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

    public void onBind(Omellette omellette) {

        question.setText(omellette.getQuestion());
        answer1.setBackgroundResource(omellette.getOption1());
        answer2.setBackgroundResource(omellette.getOption2());
//        answer1.setImageAlpha(255);
//        answer2.setImageAlpha(255);
    }

}


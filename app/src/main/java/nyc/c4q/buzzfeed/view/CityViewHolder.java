package nyc.c4q.buzzfeed.view;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import nyc.c4q.buzzfeed.R;
import nyc.c4q.buzzfeed.model.City;
import nyc.c4q.buzzfeed.model.Omellette;

/**
 * Created by olgakoleda on 11/18/17.
 */

public class CityViewHolder extends RecyclerView.ViewHolder {

    private TextView question;
    private ImageView answer1;
    private ImageView answer2;
    private CardView cardView1;
    private CardView cardView2;

    public CityViewHolder(View itemView) {
        super(itemView);

        question = itemView.findViewById(R.id.question_textview);
        answer1 = itemView.findViewById(R.id.answer1_imagebutton);
        answer2 = itemView.findViewById(R.id.answer2_imagebutton);
        cardView1 = (CardView) itemView.findViewById(R.id.card_view1);
        cardView2 = (CardView) itemView.findViewById(R.id.card_view2);

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scaleView(cardView1, 0f, 1);

            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scaleView(cardView2, 0f, 1);

            }
        });
    }

    public void onBind(City city) {

        question.setText(city.getQuestion());
        answer1.setBackgroundResource(city.getOption1());
        answer2.setBackgroundResource(city.getOption2());
    }

    public void scaleView(View v, float startScale, float endScale) {
        Animation anim = new ScaleAnimation(
                1f, 1f, // Start and end values for the X axis scaling
                startScale, endScale, // Start and end values for the Y axis scaling
                Animation.RELATIVE_TO_SELF, 0f, // Pivot point of X scaling
                Animation.RELATIVE_TO_SELF, 1f); // Pivot point of Y scaling
        anim.setFillAfter(true); // Needed to keep the result of the animation
        anim.setDuration(1000);
        v.startAnimation(anim);
    }
}

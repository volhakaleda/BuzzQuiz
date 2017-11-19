package nyc.c4q.buzzfeed.view;

import android.animation.AnimatorInflater;
import android.animation.StateListAnimator;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.buzzfeed.R;
import nyc.c4q.buzzfeed.model.Omellette;


public class ChefViewHolder extends RecyclerView.ViewHolder {

    private TextView question;
    private ImageView answer1;
    private ImageView answer2;
    private Omellette omellette;
    private CardView cardView1;
    private CardView cardView2;

    public ChefViewHolder(final View itemView) {
        super(itemView);

        question = (TextView) itemView.findViewById(R.id.question_textview);
        answer1 = (ImageView) itemView.findViewById(R.id.answer1_imagebutton);
        answer2 = (ImageView) itemView.findViewById(R.id.answer2_imagebutton);
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

    public void onBind(Omellette omellette) {
        this.omellette = omellette;

        question.setText(omellette.getQuestion());
        answer1.setBackgroundResource(omellette.getOption1());
        answer2.setBackgroundResource(omellette.getOption2());

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


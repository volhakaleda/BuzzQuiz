package nyc.c4q.buzzfeed.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import nyc.c4q.buzzfeed.ImageListener;
import nyc.c4q.buzzfeed.R;
import nyc.c4q.buzzfeed.model.Omellette;

/**
 * Created by olgakoleda on 11/18/17.
 */

public class ResultsButtonViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageResults;
    private ImageListener listener;

    public ResultsButtonViewHolder(View itemView, final ImageListener listener) {
        super(itemView);
        this.listener = listener;

        Button results = itemView.findViewById(R.id.results);
        imageResults = itemView.findViewById(R.id.image_result);

        results.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageResults.setVisibility(View.VISIBLE);
                listener.showVisibility();
            }

        });
    }

    public void bindData(boolean isVisible) {
        if(isVisible) {
            imageResults.setVisibility(View.VISIBLE);
        }
    }
}



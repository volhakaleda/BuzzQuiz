package nyc.c4q.buzzfeed;

import android.media.ImageReader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.buzzfeed.controller.ChefAdapter;
import nyc.c4q.buzzfeed.model.Omellette;


public class ChefActivity extends AppCompatActivity implements ImageListener{

    static final String STATE_USER = "user";
    private boolean isVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef);

        RecyclerView chefRecyclerView = (RecyclerView) findViewById(R.id.chef_recyclerview);
        if(savedInstanceState != null) {
            isVisible = savedInstanceState.getBoolean(STATE_USER);
        }

        List<Omellette> omellette = new ArrayList<>();
        omellette.add(new Omellette("What do you put in your omelette?", R.drawable.eggg, R.drawable.egggg));
        omellette.add(new Omellette("Where do you cook your omelette?", R.drawable.draine, R.drawable.pan));
        omellette.add(new Omellette("What do you use to beat your eggs?", R.drawable.beater, R.drawable.spoon));
        omellette.add(new Omellette("What do you add to your omelette?", R.drawable.salt, R.drawable.honey));
        omellette.add(new Omellette("How long do you cook your omelette?", R.drawable.five, R.drawable.thirty));
        omellette.add(new Omellette("When do you cook your omelette?", R.drawable.morning, R.drawable.mid));
        omellette.add(new Omellette("How do you like to serve your omelette?", R.drawable.omelette, R.drawable.burnt));

        ChefAdapter chefAdapter = new ChefAdapter(omellette, isVisible, this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        chefRecyclerView.setAdapter(chefAdapter);
        chefRecyclerView.setLayoutManager(linearLayoutManager);

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putBoolean(STATE_USER, isVisible);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void showVisibility() {
        isVisible = true;
    }
}

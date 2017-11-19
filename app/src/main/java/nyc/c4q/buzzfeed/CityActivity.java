package nyc.c4q.buzzfeed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.buzzfeed.controller.ChefAdapter;
import nyc.c4q.buzzfeed.controller.CityAdapter;
import nyc.c4q.buzzfeed.model.City;
import nyc.c4q.buzzfeed.model.Omellette;

public class CityActivity extends AppCompatActivity implements ImageListener{

    static final String STATE_USER = "user";
    private boolean isVisible;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        RecyclerView cityRecyclerView = (RecyclerView) findViewById(R.id.city_recyclerview);

        if(savedInstanceState != null) {
            isVisible = savedInstanceState.getBoolean(STATE_USER);
        }

        List<City> cities = new ArrayList<>();
        cities.add(new City("Where do you want to live?", R.drawable.hong, R.drawable.porto));
        cities.add(new City("Which landscape do you prefer?", R.drawable.mountains, R.drawable.even));
        cities.add(new City("What weather do you like?", R.drawable.summer, R.drawable.winterrrr));
        cities.add(new City("Do prefer living in a house or apartment?", R.drawable.apartm, R.drawable.house));
        cities.add(new City("How big is your family?", R.drawable.smallfamily, R.drawable.biggg));
        cities.add(new City("Are you wealthy?", R.drawable.rich, R.drawable.poor));

        CityAdapter cityAdapter = new CityAdapter(cities, isVisible, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        cityRecyclerView.setAdapter(cityAdapter);
        cityRecyclerView.setLayoutManager(linearLayoutManager);
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

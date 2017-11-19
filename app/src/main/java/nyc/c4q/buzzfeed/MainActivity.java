package nyc.c4q.buzzfeed;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button chefButton;
    private Button cityButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        chefButton = (Button) findViewById(R.id.chef_button);
        cityButton = (Button) findViewById(R.id.city_button);

        chefButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ChefActivity.class);
                startActivity(intent);

            }
        });

        cityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, CityActivity.class);
                startActivity(intent);
            }
        });
    }


}

package nyc.c4q.buzzfeed;

import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.buzzfeed.controller.CityAdapter;
import nyc.c4q.buzzfeed.model.City;

import static org.junit.Assert.assertEquals;


public class CityAdapterTest {

    @Mock
    ImageListener imageListener;

    @Test
    public void shouldReturnListSize() {

        List<City> testList = new ArrayList<>();
        testList.add(new City("Where do you want to live?", R.drawable.hong, R.drawable.porto));
        testList.add(new City("Which landscape do you prefer?", R.drawable.mountains, R.drawable.even));
        testList.add(new City("What weather do you like?", R.drawable.summer, R.drawable.winterrrr));

        CityAdapter adapter = new CityAdapter(testList, false, imageListener);
        int count = adapter.getItemCount();
        assertEquals(4, count);
    }

}

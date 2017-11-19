package nyc.c4q.buzzfeed.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.buzzfeed.ImageListener;
import nyc.c4q.buzzfeed.R;
import nyc.c4q.buzzfeed.model.City;
import nyc.c4q.buzzfeed.view.CityViewHolder;
import nyc.c4q.buzzfeed.view.ResultsButtonViewHolder;

/**
 * Created by olgakoleda on 11/18/17.
 */

public class CityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<City> cityList;
    private boolean isVisisble;
    private ImageListener listener;

    private static final int VIEW_TYPE_CITY = 0;
    private static final int VIEW_TYPE_RESULT = 1;

    public CityAdapter(List<City> cityList, boolean isVisible, ImageListener listener) {
        this.cityList = cityList;
        this.listener = listener;
        this.isVisisble = isVisible;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_CITY:
                View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_itemview, parent, false);
                return new CityViewHolder(childView);

            case VIEW_TYPE_RESULT:
                View childView1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_resultbutton, parent, false);
                return new ResultsButtonViewHolder(childView1, listener);
        }
        throw new IllegalArgumentException("Invalid ViewType: " + viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        switch (getItemViewType(position)) {

            case VIEW_TYPE_CITY:

                City city = cityList.get(position);
                CityViewHolder cityViewHolder = (CityViewHolder) holder;
                cityViewHolder.onBind(city);
                break;

            case VIEW_TYPE_RESULT:
                ResultsButtonViewHolder cityViewHolder1 = (ResultsButtonViewHolder) holder;
                cityViewHolder1.bindData(isVisisble);
                break;

        }

    }

    @Override
    public int getItemCount() {
        return cityList.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == cityList.size()) {
            return VIEW_TYPE_RESULT;
        }
        else {
            return VIEW_TYPE_CITY;
        }
    }
}

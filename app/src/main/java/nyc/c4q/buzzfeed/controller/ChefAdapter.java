package nyc.c4q.buzzfeed.controller;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.buzzfeed.ImageListener;
import nyc.c4q.buzzfeed.R;
import nyc.c4q.buzzfeed.model.Omellette;
import nyc.c4q.buzzfeed.view.ChefViewHolder;
import nyc.c4q.buzzfeed.view.ResultsButtonViewHolder;

public class ChefAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<Omellette> chefList;
    private boolean isVisible;
    private ImageListener listener;

    private static final int VIEW_TYPE_CHEF = 0;
    private static final int VIEW_TYPE_RESULTS = 1;

    public ChefAdapter(List<Omellette> chefList, boolean isVisible, ImageListener listener) {
        this.chefList = chefList;
        this.isVisible = isVisible;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_CHEF:
                View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.chef_itemview, parent, false);
                return new ChefViewHolder(childView);

            case VIEW_TYPE_RESULTS:
                View childView1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.chef_resultbutton, parent, false);
                return new ResultsButtonViewHolder(childView1, listener);
        }
        throw new IllegalArgumentException("Invalid ViewType: " + viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        switch (getItemViewType(position)) {

            case VIEW_TYPE_CHEF:

                Omellette omellette = chefList.get(position);
                ChefViewHolder chefViewHolder = (ChefViewHolder) holder;
                chefViewHolder.onBind(omellette);
                break;

            case VIEW_TYPE_RESULTS:
                ResultsButtonViewHolder resultsButtonViewHolder = (ResultsButtonViewHolder) holder;
                resultsButtonViewHolder.bindData(isVisible);
                break;
        }

    }

    @Override
    public int getItemCount() {
        return chefList.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == chefList.size()) {
            return VIEW_TYPE_RESULTS;
        }
        else {
            return VIEW_TYPE_CHEF;
        }
    }
}

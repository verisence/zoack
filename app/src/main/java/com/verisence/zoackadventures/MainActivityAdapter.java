package com.verisence.zoackadventures;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.MainViewHolder> {
    public ArrayList<Destinations> mDestinations = new ArrayList<>();
    private Context mContext;

    public MainActivityAdapter(Context context, ArrayList<Destinations> mDestinations) {
        mContext = context;
        this.mDestinations = mDestinations;
    }

    @Override
    public MainActivityAdapter.MainViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        View view = LayoutInflater.from (parent.getContext()).inflate(R.layout.destination_list_item, parent, false);
        MainViewHolder viewHolder = new MainViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder (MainActivityAdapter.MainViewHolder holder, int position) {
        holder.bindDestinations(mDestinations.get(position));
    }

    @Override
    public int getItemCount() {
        return mDestinations.size();
    }

    public class MainViewHolder extends RecyclerView. ViewHolder implements View

            .OnClickListener {
        @BindView(R.id.name)
        TextView
    }
}

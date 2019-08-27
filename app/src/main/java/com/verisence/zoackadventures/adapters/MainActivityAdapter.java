package com.verisence.zoackadventures.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.verisence.zoackadventures.models.Destinations;
import com.verisence.zoackadventures.R;
import com.verisence.zoackadventures.ui.DestinationsDetailActivity;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

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

    public class MainViewHolder extends RecyclerView. ViewHolder implements View.OnClickListener {
        @BindView(R.id.ImageView)
        ImageView mPhotoImageView;
        @BindView(R.id.nameTextView)
        TextView mNameTextView;
        @BindView(R.id.destinationButton)
        Button mDestinationButton;

        private Context mContext;

        public MainViewHolder(View itemView) {

            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);

        }
        @Override
        public void onClick (View view){
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent (mContext, DestinationsDetailActivity.class);
            intent.putExtra ("position", itemPosition);
            intent.putExtra ("destinations", Parcels.wrap(mDestinations));
            mContext.startActivity(intent);

        }

        public void bindDestinations(Destinations destinations) {
            Picasso.get().load(destinations.getPhoto()).into(mPhotoImageView);
            mNameTextView.setText(destinations.getName());
        }
    }
}

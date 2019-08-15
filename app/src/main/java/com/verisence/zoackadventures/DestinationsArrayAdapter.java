package com.verisence.zoackadventures;

import android.content.Context;
import android.widget.ArrayAdapter;

public class DestinationsArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mDestinations;

    public DestinationsArrayAdapter(Context mContext, int resource, String[] mDestinations){
        super(mContext, resource);
        this.mContext = mContext;
        this.mDestinations = mDestinations;
    }

    @Override
    public Object getItem(int position) {
        String destination = mDestinations[position];
        return String.format("%s", destination);
    }

    @Override
    public int getCount() {
        return mDestinations.length;
    }
}

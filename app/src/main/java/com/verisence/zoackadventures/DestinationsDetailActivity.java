package com.verisence.zoackadventures;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.parceler.Parcels;

import butterknife.ButterKnife;

public class DestinationsDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destinations_detail);
        ButterKnife.bind(this);

        mDestinations = Parcels.unwrap(getIntent().getParcelableExtra("destinations"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new DestinationsPagerAdapter(getSupportFragmentManager(), mDestinations);
        mViewPager.setAdapter (adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}

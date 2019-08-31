package com.verisence.zoackadventures.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.verisence.zoackadventures.models.Destinations;
import com.verisence.zoackadventures.adapters.DestinationsPagerAdapter;
import com.verisence.zoackadventures.R;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DestinationsDetailActivity extends AppCompatActivity {

    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    private DestinationsPagerAdapter adapterViewPager;
    ArrayList<Destinations> mDestinations = new ArrayList<>();

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

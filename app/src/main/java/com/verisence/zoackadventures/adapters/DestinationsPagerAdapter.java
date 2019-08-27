package com.verisence.zoackadventures.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.verisence.zoackadventures.models.Destinations;
import com.verisence.zoackadventures.ui.DestinationsDetailFragment;

import java.util.ArrayList;

public class DestinationsPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Destinations> mDestinations;

        public DestinationsPagerAdapter(FragmentManager fm, ArrayList<Destinations> destinations) {
            super(fm);
            mDestinations = destinations;
        }

        @Override
        public Fragment getItem(int position) {
            return DestinationsDetailFragment.newInstance(mDestinations.get(position));
        }

        @Override
        public int getCount() {
            return mDestinations.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mDestinations.get(position).getName();
        }
    }




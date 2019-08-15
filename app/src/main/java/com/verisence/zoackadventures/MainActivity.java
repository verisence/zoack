package com.verisence.zoackadventures;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView (R.id.destinationslistView) ListView mListView;
    private String[] destinations = new String[] {"Serengeti National Park", "Watamu Beach", "Diani Beach", "Kereita Forest", "Lake Bogoria Flamingos", "Longonot National Park", "Maasai Mara", "Meru National Park", "Mountain Climbing Safaris", "Mt.Kenya Hike","Nairobi National Park", "Ngorongoro Crater", "Sweet Waters Nanyuki", "Watamu"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, destinations);
        mListView.setAdapter(adapter);
    }
}

package com.verisence.zoackadventures;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    ListView mListView;
    public ArrayList<Destinations> mDestinations = new ArrayList<>();
    private MainActivityAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        DestinationsArrayAdapter adapter = new DestinationsArrayAdapter(this, android.R.layout.simple_list_item_1, destinations);
        mListView.setAdapter(adapter);
    }

    private void getDestinations() {
        final Service service = new Service();
        Service.findDestinations(new Callback() {

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                mDestinations = Service.processResults(response);
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter = new MainActivityAdapter(getApplicationContext(), mDestinations);
                        mRecyclerView.setAdapter(mAdapter);

                        mRecyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 1));
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
            }
        });
    }
}
}

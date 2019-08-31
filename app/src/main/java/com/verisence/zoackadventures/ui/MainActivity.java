package com.verisence.zoackadventures.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

import com.verisence.zoackadventures.models.Destinations;
import com.verisence.zoackadventures.adapters.MainActivityAdapter;
import com.verisence.zoackadventures.R;
import com.verisence.zoackadventures.Services.Service;

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
        getDestinations();
    }

    private void getDestinations() {
        final Service service = new Service();
        service.findDestinations(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                mDestinations =  service.processResults(response);
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


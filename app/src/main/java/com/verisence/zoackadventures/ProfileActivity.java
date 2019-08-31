package com.verisence.zoackadventures;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {


    @BindView(R.id.profileImage)
    ImageView profileImage;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.editName)
    EditText editName;
    @BindView(R.id.email)
    TextView email;
    @BindView(R.id.editEmail)
    EditText editEmail;
    @BindView(R.id.phone)
    TextView phone;
    @BindView(R.id.editPhone)
    EditText editPhone;
    @BindView(R.id.places)
    TextView places;
    @BindView(R.id.placesSpinner)
    Spinner placesSpinner;
    @BindView(R.id.saveButton)
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);

        saveButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == saveButton){
            Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }


}

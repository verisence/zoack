package com.verisence.zoackadventures.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.verisence.zoackadventures.R;
import com.verisence.zoackadventures.ui.MainActivity;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_profile, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }


}

package com.verisence.zoackadventures.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;
import com.verisence.zoackadventures.models.Destinations;
import com.verisence.zoackadventures.R;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class DestinationsDetailFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.ImageView) ImageView mPhotoImageView;
    @BindView(R.id.nameTextView) TextView mNameLabel;
    @BindView(R.id.descriptionTextView)TextView mDescriptionLabel;
    @BindView(R.id.locationTextView) TextView mLocationLabel;
    @BindView(R.id.itenaryTextView) TextView mItenaryLabel;


    private Destinations mDestination;

    public static DestinationsDetailFragment newInstance(Destinations mDestination) {
        DestinationsDetailFragment mDestinationsDetailFragment = new DestinationsDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("destination", Parcels.wrap(mDestination));
        mDestinationsDetailFragment.setArguments(args);
        return mDestinationsDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDestination = Parcels.unwrap(getArguments().getParcelable("destination"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_destinations_detail, container, false);
        ButterKnife.bind(this, view);

        if (mDestination.getPhoto()!= null) {
            Picasso.get().load(mDestination.getPhoto()).into(mPhotoImageView);
        }
        mNameLabel.setText(mDestination.getName());
        mDescriptionLabel.setText(mDestination.getDescription());
        mLocationLabel.setText(mDestination.getLocation());
        mItenaryLabel.setText(mDestination.getItenary());


//        mSavedDestinationsButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

    }


//    @Override
//    public  void onClick (View view) {
//
//        if (view == mSavedDestinationsButton) {
//            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//            String uid = user.getUid();
//            DatabaseReference comicRef = FirebaseDatabase
//                    .getInstance()
//                    .getReference(Constants.FIREBASE_CHILD_COMICS)
//                    .child(uid);
//
//            DatabaseReference pushRef = comicRef.push();
//            String pushId = pushRef.getKey();
//            mComics.setPushId(pushId);
//            pushRef.setValue(mComics);
//            comicRef.push().setValue(mComics);
//            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
//        }


}

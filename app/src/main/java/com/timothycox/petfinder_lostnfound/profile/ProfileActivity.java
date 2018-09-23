package com.timothycox.petfinder_lostnfound.profile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.timothycox.petfinder_lostnfound.R;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfileActivity extends AppCompatActivity implements ProfileView {

    // region ButterKnife Bindings
    @BindView(R.id.profile_imageview)
    ImageView profilePicture;
    @BindView(R.id.profile_edit_button)
    ImageButton editButton;
    @BindView(R.id.profile_name)
    TextView profileName;
    @BindView(R.id.profile_type)
    TextView profileType;
    @BindView(R.id.profile_color)
    TextView profileColor;
    @BindView(R.id.profile_location)
    TextView profileLocation;
    @BindView(R.id.profile_phone)
    TextView profilePhone;
    @BindView(R.id.profile_date)
    TextView profileDate;
    @BindView(R.id.profile_email)
    TextView profileEmail;
    @BindView(R.id.profile_status)
    TextView profileStatus;
    @BindView(R.id.profile_description)
    TextView profileDescription;
    @BindView(R.id.profile_name_db)
    TextView profileNameFromDB;
    @BindView(R.id.profile_type_db)
    TextView profileTypeFromDB;
    @BindView(R.id.profile_color_db)
    TextView profileColorFromDB;
    @BindView(R.id.profile_location_db)
    TextView profileLocationFromDB;
    @BindView(R.id.profile_phone_db)
    TextView profilePhoneFromDB;
    @BindView(R.id.profile_date_db)
    TextView profileDateFromDB;
    @BindView(R.id.profile_email_db)
    TextView profileEmailFromDB;
    @BindView(R.id.profile_status_db)
    TextView profileStatusFromDB;
    @BindView(R.id.profile_description_db)
    TextView profileDescriptionFromDB;
    private ProfilePresenter presenter;
    // endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        presenter = new ProfilePresenter(this, getIntent().getStringExtra("animalID"));
        presenter.createProfile();
    }

    @Override
    public void populateDataFields(HashMap<String, Object> animal) {
        profileNameFromDB.setText(animal.get("name").toString());
        profileColorFromDB.setText(animal.get("color").toString());
        profileDateFromDB.setText(animal.get("date").toString());
        profileEmailFromDB.setText(animal.get("email").toString());
        profileDescriptionFromDB.setText(animal.get("description").toString());
        profileLocationFromDB.setText(animal.get("location").toString());
        profilePhoneFromDB.setText(animal.get("phone").toString());
        profileTypeFromDB.setText(animal.get("type").toString());
        profileStatusFromDB.setText(animal.get("found").toString());
    }

    @Override
    @OnClick(R.id.profile_edit_button)
    public void onClickEdit() {
        presenter.onEdit(getApplicationContext());
    }

    //    @OnClick(R.id.profile_)
    @Override
    public void onClickStatusChange() {
        presenter.onStatusChange();
    }
}

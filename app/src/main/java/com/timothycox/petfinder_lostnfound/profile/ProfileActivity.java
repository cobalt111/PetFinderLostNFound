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
    ImageView pictureView;
    @BindView(R.id.profile_edit_button)
    ImageButton editButton;
    @BindView(R.id.profile_name)
    TextView nameText;
    @BindView(R.id.profile_type)
    TextView typeText;
    @BindView(R.id.profile_color)
    TextView colorText;
    @BindView(R.id.profile_location)
    TextView locationText;
    @BindView(R.id.profile_phone)
    TextView phoneText;
    @BindView(R.id.profile_date)
    TextView profileDate;
    @BindView(R.id.profile_email)
    TextView emailText;
    @BindView(R.id.profile_status)
    TextView statusText;
    @BindView(R.id.profile_description)
    TextView descriptionText;
    @BindView(R.id.profile_name_db)
    TextView nameTextFromDB;
    @BindView(R.id.profile_type_db)
    TextView typeTextFromDB;
    @BindView(R.id.profile_color_db)
    TextView colorTextFromDB;
    @BindView(R.id.profile_location_db)
    TextView locationTextFromDB;
    @BindView(R.id.profile_phone_db)
    TextView phoneTextFromDB;
    @BindView(R.id.profile_date_db)
    TextView dateTextFromDB;
    @BindView(R.id.profile_email_db)
    TextView emailTextFromDB;
    @BindView(R.id.profile_status_db)
    TextView statusTextFromDB;
    @BindView(R.id.profile_description_db)
    TextView descriptionTextFromDB;
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
        nameTextFromDB.setText(animal.get("name").toString());
        colorTextFromDB.setText(animal.get("color").toString());
        dateTextFromDB.setText(animal.get("date").toString());
        emailTextFromDB.setText(animal.get("email").toString());
        descriptionTextFromDB.setText(animal.get("description").toString());
        locationTextFromDB.setText(animal.get("location").toString());
        phoneTextFromDB.setText(animal.get("phone").toString());
        typeTextFromDB.setText(animal.get("type").toString());
        statusTextFromDB.setText(animal.get("found").toString());
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

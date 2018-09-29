package com.timothycox.petfinder_lostnfound.profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.timothycox.petfinder_lostnfound.R;
import com.timothycox.petfinder_lostnfound.model.Animal;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfileActivity extends AppCompatActivity implements ProfileContract.View {

    private ProfilePresenterImpl presenter;

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
    private ProfileNavigator navigator;

    @Override
    @OnClick(R.id.profile_edit_button)
    public void onClickButton(View view) {
        switch (view.getId()) {
            case (R.id.profile_edit_button): {
                finish();
                presenter.onEditButton();
            }
            // todo implement status button
            case (R.id.profile_status_change_button): {
                presenter.onStatusChangeButton();
            }
        }
    }

    @Override
    public void onEditClickEvent(@NonNull final Animal animal) {
        navigator.itemClicked(ProfileNavigator.POST_ACTIVITY, animal);
    }
    // endregion

    @Override
    public void onStatusChangeClickEvent(@NonNull final Animal animal) {
//        todo display toast
        statusTextFromDB.setText(animal.getStatus());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        presenter = new ProfilePresenterImpl(this, (Animal) getIntent().getParcelableExtra(("animal")));
        navigator = new ProfileNavigator(this);
        presenter.createProfile();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter = null;
        navigator = null;
    }

    public interface ProfileScreenEvents {
        void itemClicked(final int itemId, @Nullable final Animal animal);
    }

    @Override
    public void populateDataFields(Animal animal) {
        nameTextFromDB.setText(animal.getName());
        colorTextFromDB.setText(animal.getColor());
        dateTextFromDB.setText(animal.getDate());
        emailTextFromDB.setText(animal.getEmail());
        descriptionTextFromDB.setText(animal.getDescription());
        locationTextFromDB.setText(animal.getLocation());
        phoneTextFromDB.setText(animal.getPhone());
        typeTextFromDB.setText(animal.getType());
        statusTextFromDB.setText(animal.getStatus());
    }
}

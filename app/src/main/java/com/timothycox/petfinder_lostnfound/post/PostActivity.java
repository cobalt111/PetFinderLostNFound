package com.timothycox.petfinder_lostnfound.post;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.timothycox.petfinder_lostnfound.R;
import com.timothycox.petfinder_lostnfound.model.Animal;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;

public class PostActivity extends AppCompatActivity implements PostContract.View {

    private PostPresenterImpl presenter;

    // region ButterKnife Bindings
    @BindArray(R.array.type_dropdown)
    String[] types;
    @BindArray(R.array.status_dropdown)
    String[] statuses;
    @BindView(R.id.post_submit_button)
    ImageButton submitButton;
    @BindView(R.id.post_image_button)
    ImageButton addPictureButton;
    @BindView(R.id.post_spinner_type)
    Spinner typeDropdown;
    @BindView(R.id.post_spinner_status)
    Spinner statusDropdown;
    @BindView(R.id.post_type)
    TextView typeText;
    @BindView(R.id.post_status)
    TextView statusText;
    @BindView(R.id.post_name)
    EditText nameField;
    @BindView(R.id.post_color)
    EditText colorField;
    @BindView(R.id.post_location)
    EditText locationField;
    @BindView(R.id.post_email)
    EditText emailField;
    @BindView(R.id.post_date)
    EditText dateField;
    @BindView(R.id.post_phone)
    EditText phoneField;
    @BindView(R.id.post_description)
    EditText descriptionField;
    private PostNavigator navigator;

    @Override
    @OnClick({R.id.post_submit_button, R.id.post_image_button})
    public void onClickButton(View view) {
        final Animal animal = buildAnimalFromEnteredData();
        switch (view.getId()) {
            case (R.id.post_submit_button): {
                presenter.onClickSubmit(animal);
            }
            case (R.id.post_image_button): {
                presenter.onClickAddPicture();
                // todo add navigator?
            }
        }
    }
    private String typeSelection;
    private String statusSelection;

    @Override
    public void onSubmitButtonClickEvent(final Animal animal) {
        finish();
        navigator.itemClicked(PostNavigator.PROFILE_ACTIVITY, animal);
    }

    @OnItemSelected(R.id.post_spinner_type)
    void onTypeSelection(int position) {
        typeSelection = types[position];
    }

    @OnItemSelected(value = R.id.post_spinner_type,
            callback = OnItemSelected.Callback.NOTHING_SELECTED)
    void onNoTypeSelected() {
        typeSelection = null;
    }

    @OnItemSelected(R.id.post_spinner_status)
    void onStatusSelection(int position) {
        statusSelection = statuses[position];
    }

    @OnItemSelected(value = R.id.post_spinner_status,
            callback = OnItemSelected.Callback.NOTHING_SELECTED)
    void onNoStatusSelected() {
        statusSelection = statuses[0];
    }
    // endregion

    @Override
    public void onAddPictureClickEvent() {
        // todo figure out how pics are managed on screen
    }

    // region Activity Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        setTitle(R.string.title_post);
        ButterKnife.bind(this);
        presenter = new PostPresenterImpl(this);
        navigator = new PostNavigator(this);

        ArrayAdapter<String> typeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, types);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeDropdown.setAdapter(typeAdapter);

        ArrayAdapter<String> statusAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, statuses);
        statusAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        statusDropdown.setAdapter(statusAdapter);

        if (savedInstanceState != null) {
            populateDataFields((Animal) savedInstanceState.getParcelable("currentAnimalState"));
        }

        Intent intent = getIntent();
        if (intent.getBooleanExtra("isEditInstance", false))
            presenter.createEditInstance((Animal) intent.getParcelableExtra("animal"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        onSaveInstanceState(new Bundle());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelable("currentAnimalState", buildAnimalFromEnteredData());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter = null;
        navigator = null;
    }

    // todo figure out if we need animalbuilder
    @Override
    public Animal buildAnimalFromEnteredData() {
        return new Animal.Builder()
                .name(nameField.getText().toString())
                .color(colorField.getText().toString())
                .date(dateField.getText().toString())
                .phone(phoneField.getText().toString())
                .email(emailField.getText().toString())
                .description(descriptionField.getText().toString())
                .location(locationField.getText().toString())
                .type(typeSelection)
                .status(statusSelection)
                .build();
    }
    // endregion

    @Override
    public void populateDataFields(Animal animal) {
        nameField.setText(animal.getName());
        colorField.setText(animal.getColor());
        dateField.setText(animal.getDate());
        emailField.setText(animal.getEmail());
        phoneField.setText(animal.getPhone());
        descriptionField.setText(animal.getDescription());
        locationField.setText(animal.getLocation());
        typeSelection = animal.getType();
        setDropdownSelection(typeDropdown, typeSelection, types);
        statusSelection = animal.getStatus();
        setDropdownSelection(statusDropdown, statusSelection, statuses);
        // todo retrieve and set images
    }

    private void setDropdownSelection(Spinner spinner, String selection, String[] choices) {
        for (int i = 0; i < choices.length; i++) {
            if (selection.equals(choices[i])) {
                spinner.setSelection(i);
                break;
            }
        }
    }

    public interface PostScreenEvents {
        void itemClicked(final int itemId, final Animal animal);
    }
}

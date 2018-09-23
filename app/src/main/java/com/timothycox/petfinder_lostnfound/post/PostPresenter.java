package com.timothycox.petfinder_lostnfound.post;

import android.content.Context;

import com.timothycox.petfinder_lostnfound.BasePresenter;
import com.timothycox.petfinder_lostnfound.util.DatabaseRequest;

import java.util.HashMap;

class PostPresenter extends BasePresenter {

    private PostView postView;

    PostPresenter(PostView postView) {
        this.postView = postView;
    }

//    private String onSubmit() {
//
//        // Declare HashMap to enter animal data into, and declare reference to database to add the HashMap to
//        HashMap<String, Object> animal = new HashMap<>();
//
//        // Collect entered data and add it to the HashMap
//        animal.put("name", nameView.getText().toString());
//        animal.put("color", colorView.getText().toString());
//        animal.put("date", dateView.getText().toString());
//        animal.put("email", emailView.getText().toString());
//        animal.put("description", descView.getText().toString());
//        animal.put("phone", phoneView.getText().toString());
//        animal.put("location", locationView.getText().toString());
//        animal.put("latitude", Double.toString(location.getLatitude()));
//        animal.put("longitude", Double.toString(location.getLongitude()));
//        animal.put("type", typeSelection);
//        animal.put("found", statusSelection);
//
//        // Add user's device FirebaseUtil token
//        animal.put("token", FirebaseInstanceId.getInstance().getToken());
//
//
//        // Create new key for animal
//        final DatabaseReference newAnimalRef = database.getDatabaseReference().push();
//        String key = newAnimalRef.getKey();
//
//        // Add animal's own key to its database entry
//        animal.put("key", key);
//
//        // Add animal to database
//        newAnimalRef.setValue(animal);
//
//        //TODO add picture functionality
//        if (imagePicked) {
//
//            if (imageBmp != null && useBitmap) {
//                StorageReference animalStorageRef = storageReference.child("server")
//                        .child("animals")
//                        .child("images")
//                        .child("thumb/" + key);
//
//                ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                imageBmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
//                byte[] data = baos.toByteArray();
//
//                UploadTask uploadTask = animalStorageRef.putBytes(data);
//                uploadTask.addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception exception) {
//                        // Handle unsuccessful uploads
//                    }
//                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                    @Override
//                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                        // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
//                        Uri imageURL = taskSnapshot.getDownloadUrl();
//
//                        newAnimalRef.child("thumbURL").setValue(imageURL.toString());
//
//                    }
//                });
//
//            } else if (imageUri != null && !useBitmap) {
//
//                StorageReference animalStorageRef = storageReference.child("server")
//                        .child("animals")
//                        .child("images")
//                        .child("thumb/" + key);
//
//                UploadTask uploadTask = animalStorageRef.putFile(imageUri);
//                uploadTask.addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception exception) {
//                        // Handle unsuccessful uploads
//                    }
//                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                    @Override
//                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                        // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
//                        Uri imageURL = taskSnapshot.getDownloadUrl();
//
//                        newAnimalRef.child("thumbURL").setValue(imageURL.toString());
//
//                    }
//                });
//
//            } else Log.d("Image", "Unable to submit image reference");
//
//
//        }
//
//        // Add animal to local list of animals and save it to the data file
//        yourAnimalList.add(animal.get("key").toString());
//        FileUtils.writeToFile(yourAnimalList, getApplicationContext());
//
//        return key;
//    }

    // todo get location data of phone to add to hashmap before submitting
    void onSubmit(Context context, HashMap<String, Object> animal) {


//        animal.put("latitude", Double.toString(location.getLatitude()));
//        animal.put("longitude", Double.toString(location.getLongitude()));
//        animal.put("token", FirebaseInstanceId.getInstance().getToken();
        DatabaseRequest.submitAnimal(animal);
    }

    void onAddPicture() {

    }

    void onEdit(final String animalID) {
        HashMap<String, Object> animal = new HashMap<>();

        // todo receive data from db

        postView.populateDataFields(animal);
    }

}

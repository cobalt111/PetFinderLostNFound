package com.timothycox.petfinder_lostnfound.post;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.timothycox.petfinder_lostnfound.BasePresenter;
import com.timothycox.petfinder_lostnfound.model.Animal;
import com.timothycox.petfinder_lostnfound.util.DatabaseRequest;

import static android.support.constraint.Constraints.TAG;

class PostPresenter extends BasePresenter {

    private PostView postView;

    public PostPresenter(PostView postView) {
        this.postView = postView;
    }

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
//        return key;
//    }

    // todo get location data of phone to add to animal before submitting
    void onSubmit(Context context, final Animal animal) {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                animal.setLatitude(String.valueOf(location.getLatitude()));
                animal.setLongitude(String.valueOf(location.getLongitude()));
                DatabaseRequest.submitAnimal(animal);
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };
        requestLocation(context, locationManager, locationListener);
    }

    public void onAddPicture() {

    }

    // todo figure out how to cache images for this
    public void onEdit(final String animalID) {
        postView.populateDataFields(DatabaseRequest.getAnimal(animalID));
    }

    public void requestLocation(Context context, LocationManager locationManager, LocationListener locationListener) {
        if (ContextCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            try {
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
            } catch (SecurityException e) {
                Log.d(TAG, "Do not have permission to access location.");
                e.printStackTrace();
            } catch (NullPointerException e) {
                Log.d(TAG, "Location update returned null.");
                e.printStackTrace();
            }
        }
        // else
        // todo handle not having permission
    }
}

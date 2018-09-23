package com.timothycox.petfinder_lostnfound.util;

import com.google.firebase.iid.FirebaseInstanceId;

class FirebaseUtil {

    static String generateFirebaseInstanceToken() {
        return FirebaseInstanceId.getInstance().getToken();
    }
}

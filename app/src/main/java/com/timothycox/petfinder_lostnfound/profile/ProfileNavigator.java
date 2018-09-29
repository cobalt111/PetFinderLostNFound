package com.timothycox.petfinder_lostnfound.profile;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.timothycox.petfinder_lostnfound.model.Animal;
import com.timothycox.petfinder_lostnfound.post.PostActivity;

class ProfileNavigator implements ProfileActivity.ProfileScreenEvents {

    static final int POST_ACTIVITY = 1;
    private Context context;

    ProfileNavigator(Context context) {
        this.context = context;
    }

    @Override
    public void itemClicked(final int itemId, @Nullable final Animal animal) {
        switch (itemId) {
            case (POST_ACTIVITY): {
                Intent intent = new Intent(context, PostActivity.class);
                intent.putExtra("animal", animal)
                        .putExtra("isEditInstance", true);
                context.startActivity(intent);
            }
        }

    }
}

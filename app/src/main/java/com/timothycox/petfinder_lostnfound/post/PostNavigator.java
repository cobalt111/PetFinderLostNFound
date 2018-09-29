package com.timothycox.petfinder_lostnfound.post;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.timothycox.petfinder_lostnfound.model.Animal;
import com.timothycox.petfinder_lostnfound.profile.ProfileActivity;

class PostNavigator implements PostActivity.PostScreenEvents {

    static final int PROFILE_ACTIVITY = 1;
    private Context context;

    PostNavigator(Context context) {
        this.context = context;
    }

    @Override
    public void itemClicked(final int itemId, @Nullable Animal animal) {
        switch (itemId) {
            case (PROFILE_ACTIVITY): {
                Intent intent = new Intent(context, ProfileActivity.class);
                intent.putExtra("animal", animal);
                context.startActivity(intent);
            }
        }

    }
}

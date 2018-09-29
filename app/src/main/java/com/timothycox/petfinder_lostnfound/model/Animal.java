package com.timothycox.petfinder_lostnfound.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;

public class Animal implements Parcelable {

    public static final Parcelable.Creator<Animal> CREATOR
            = new Parcelable.Creator<Animal>() {
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

    private String name;
    private String type;
    private String color;
    private String date;
    private String email;
    private String location;
    private String latitude;
    private String longitude;
    private String phone;
    private String token;
    private String description;
    private String thumbUrl;
    private String key;
    private String status;

    // todo figure out better way to handle pojo?
    public Animal(String name, String type, String color, String date, String email, String location,
                  String latitude, String longitude, String phone, String token, String description,
                  String thumbUrl, String key, String status) {
        this.name = name;
        this.type = type;
        this.color = color;
        this.date = date;
        this.email = email;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.phone = phone;
        this.token = token;
        this.description = description;
        this.thumbUrl = thumbUrl;
        this.key = key;
        this.status = status;
    }

    // todo implement parcelable
    private Animal(Parcel in) {
    }

    private Animal(Builder builder) {
        this.name = builder.name;
        this.type = builder.type;
        this.color = builder.color;
        this.date = builder.date;
        this.email = builder.email;
        this.location = builder.location;
        this.latitude = builder.latitude;
        this.longitude = builder.longitude;
        this.phone = builder.phone;
        this.token = builder.token;
        this.description = builder.description;
        this.thumbUrl = builder.thumbURL;
        this.key = builder.key;
        this.status = builder.status;
    }

    // region Animal Getters
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public String getDate() {
        return date;
    }

    public String getEmail() {
        return email;
    }

    public String getLocation() {
        return location;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getPhone() {
        return phone;
    }

    public String getToken() {
        return token;
    }

    public String getDescription() {
        return description;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public String getKey() {
        return key;
    }

    public String getStatus() {
        return status;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }
    // endregion

    // region Animal Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HashMap<String, Object> parseAnimalToHashMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("color", color);
        map.put("email", email);
        map.put("phone", phone);
        map.put("location", location);
        map.put("token", token);
        map.put("date", date);
        map.put("description", description);
        map.put("type", type);
        map.put("found", status);
        map.put("thumbUrl", thumbUrl);
        return map;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    // endregion

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }

    public static class Builder {

        private String type;
        private String status;
        private String name;
        private String color;
        private String date;
        private String email;
        private String location;
        private String latitude;
        private String longitude;
        private String phone;
        private String token;
        private String description;
        private String thumbURL;
        private String key;

        public Builder() {
        }

        public Animal build() {
            return new Animal(this);
        }

        // region Builder Setters
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Builder date(String date) {
            this.date = date;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder latitude(String latitude) {
            this.latitude = latitude;
            return this;
        }

        public Builder longitude(String longitude) {
            this.longitude = longitude;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder thumbURL(String thumbURL) {
            this.thumbURL = thumbURL;
            return this;
        }

        public Builder key(String key) {
            this.key = key;
            return this;
        }
        // endregion
    }
}

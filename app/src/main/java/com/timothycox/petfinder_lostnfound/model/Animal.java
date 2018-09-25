package com.timothycox.petfinder_lostnfound.model;

import java.io.Serializable;

public class Animal implements Serializable {

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
    private String thumbURL;
    private String key;
    private String status;

    public Animal(String name, String type, String color, String date, String email, String location, String latitude, String longitude, String phone, String token, String description, String thumbURL, String key, String status) {
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
        this.thumbURL = thumbURL;
        this.key = key;
        this.status = status;
    }

    //    private Animal(AnimalBuilder builder) {
//        this.name = builder.name;
//        this.type = builder.type;
//        this.color = builder.color;
//        this.date = builder.date;
//        this.email = builder.email;
//        this.location = builder.location;
//        this.latitude = builder.latitude;
//        this.longitude = builder.longitude;
//        this.phone = builder.phone;
//        this.token = builder.token;
//        this.description = builder.description;
//        this.thumbURL = builder.thumbURL;
//        this.key = builder.key;
//        this.status = builder.status;
//    }

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

    public String getThumbURL() {
        return thumbURL;
    }

    public String getKey() {
        return key;
    }

    public String getStatus() {
        return status;
    }

//    public static class AnimalBuilder {
//
//        private String type;
//        private String status;
//        private String name;
//        private String color;
//        private String date;
//        private String email;
//        private String location;
//        private String latitude;
//        private String longitude;
//        private String phone;
//        private String token;
//        private String description;
//        private String thumbURL;
//        private String key;
//
//        public AnimalBuilder() {
//        }
//
//        public Animal build() {
//            return new Animal(this);
//        }
//
//        // region AnimalBuilder Setters
//        public AnimalBuilder name(String name) {
//            this.name = name;
//            return this;
//        }
//
//        public AnimalBuilder type(String type) {
//            this.type = type;
//            return this;
//        }
//
//        public AnimalBuilder status(String status) {
//            this.status = status;
//            return this;
//        }
//
//        public AnimalBuilder color(String color) {
//            this.color = color;
//            return this;
//        }
//
//        public AnimalBuilder date(String date) {
//            this.date = date;
//            return this;
//        }
//
//        public AnimalBuilder email(String email) {
//            this.email = email;
//            return this;
//        }
//
//        public AnimalBuilder location(String location) {
//            this.location = location;
//            return this;
//        }
//
//        public AnimalBuilder latitude(String latitude) {
//            this.latitude = latitude;
//            return this;
//        }
//
//        public AnimalBuilder longitude(String longitude) {
//            this.longitude = longitude;
//            return this;
//        }
//
//        public AnimalBuilder phone(String phone) {
//            this.phone = phone;
//            return this;
//        }
//
//        public AnimalBuilder token(String token) {
//            this.token = token;
//            return this;
//        }
//
//        public AnimalBuilder description(String description) {
//            this.description = description;
//            return this;
//        }
//
//        public AnimalBuilder thumbURL(String thumbURL) {
//            this.thumbURL = thumbURL;
//            return this;
//        }
//
//        public AnimalBuilder key(String key) {
//            this.key = key;
//            return this;
//        }
//        // endregion
//    }
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

    public void setThumbURL(String thumbURL) {
        this.thumbURL = thumbURL;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    // endregion
}

package com.timothycox.petfinder_lostnfound.exception;

public class CacheNotFoundException extends Exception {

    public CacheNotFoundException() {
    }

    public CacheNotFoundException(String message) {
        super(message);
    }
}

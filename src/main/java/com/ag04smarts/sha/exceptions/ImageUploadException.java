package com.ag04smarts.sha.exceptions;

public class ImageUploadException extends RuntimeException {

    public ImageUploadException() {
        super("Image could not be uploaded.");
    }
}

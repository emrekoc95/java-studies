package com.kocemre.instagramclonejava.model;

public class Post {
    String email;
    String comment;
    String downloadUrl;

    public Post(String email, String comment, String downloadUrl) {
        this.email = email;
        this.comment = comment;
        this.downloadUrl = downloadUrl;
    }

    public String getEmail() {
        return email;
    }

    public String getComment() {
        return comment;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }
}

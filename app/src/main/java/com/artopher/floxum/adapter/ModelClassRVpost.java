package com.artopher.floxum.adapter;

public class ModelClassRVpost {

    int postImage , profileImage;
    String post_date_time , user_id , username , post_caption;

    public ModelClassRVpost(int postImage, int profileImage, String post_date_time, String user_id, String username, String post_caption) {
        this.postImage = postImage;
        this.profileImage = profileImage;
        this.post_date_time = post_date_time;
        this.user_id = user_id;
        this.username = username;
        this.post_caption = post_caption;
    }

    public int getPostImage() {
        return postImage;
    }

    public void setPostImage(int postImage) {
        this.postImage = postImage;
    }

    public int getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(int profileImage) {
        this.profileImage = profileImage;
    }

    public String getPost_date_time() {
        return post_date_time;
    }

    public void setPost_date_time(String post_date_time) {
        this.post_date_time = post_date_time;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPost_caption() {
        return post_caption;
    }

    public void setPost_caption(String post_caption) {
        this.post_caption = post_caption;
    }
}

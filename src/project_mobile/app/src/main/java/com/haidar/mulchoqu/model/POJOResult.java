
package com.haidar.mulchoqu.model;

import com.google.gson.annotations.SerializedName;

public class POJOResult {

    @SerializedName("id")
    private Long mId;
    @SerializedName("image")
    private String mImage;
    @SerializedName("title")
    private String mTitle;

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

}

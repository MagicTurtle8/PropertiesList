package com.example.peter.propertiestablet.data.source;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Medium {

    @SerializedName("url")
    @Expose
    private String url;

    public String getUrl() {
        return url;
    }
}

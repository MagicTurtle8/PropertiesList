package com.example.peter.propertiestablet.data.source;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("medium")
    @Expose
    private Medium medium;

    public Medium getMedium() {
        return medium;
    }
}

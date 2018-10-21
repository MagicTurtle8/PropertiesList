package com.example.peter.propertiestablet.data.source;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Owner {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("lastName")
    @Expose
    private String lastName;

    @SerializedName("image")
    @Expose
    private Image image;

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Image getImage() {
        return image;
    }
}

package com.example.peter.propertiestablet.data.source;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("Address")
    @Expose
    private String address;
    @SerializedName("Address2")
    @Expose
    private String address2;
    @SerializedName("State")
    @Expose
    private String state;
    @SerializedName("Suburb")
    @Expose
    private String suburb;

    public String getAddress() {
        return address;
    }

    public String getAddress2() {
        return address2;
    }

    public String getState() {
        return state;
    }

    public String getSuburb() {
        return suburb;
    }
}

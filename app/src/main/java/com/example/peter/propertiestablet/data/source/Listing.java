package com.example.peter.propertiestablet.data.source;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Listing {
    @SerializedName("Id")
    @Expose
    private String id;

    @SerializedName("Area")
    @Expose
    private String area;

    @SerializedName("Bedrooms")
    @Expose
    private Integer bedrooms;

    @SerializedName("Bathrooms")
    @Expose
    private Integer bathrooms;

    @SerializedName("Carspaces")
    @Expose
    private Integer carspaces;

    @SerializedName("Description")
    @Expose
    private String description;

    @SerializedName("DisplayPrice")
    @Expose
    private String displayPrice;

    @SerializedName("owner")
    @Expose
    private Owner owner;

    @SerializedName("ImageUrls")
    @Expose
    private List<String> imageUrls = null;

    @SerializedName("Location")
    @Expose
    private Location location;

    @SerializedName("is_premium")
    @Expose
    private Integer isPremium;


    public Owner getOwner() {
        return owner;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public Location getLocation() {
        return location;
    }

    public Integer getBedrooms() {
        return bedrooms;
    }

    public Integer getBathrooms() {
        return bathrooms;
    }

    public Integer getCarspaces() {
        return carspaces;
    }

    public String getDescription() {
        return description;
    }

    public String getDisplayPrice() {
        return displayPrice;
    }

    public Integer getIsPremium() {
        return isPremium;
    }

    public String getId() {
        return id;
    }

    public String getArea() {
        return area;
    }
}

package com.example.peter.propertiestablet.data;

public class Property {

    private String id;
    private String Area;
    private int Bedrooms;
    private int Bathrooms;
    private int Carspaces;
    private String Description;
    private String DisplayPrice;
    private String OwnerFirstName;
    private String OwnerLastName;
    private String imageUrl;
    private String Address1;
    private String Address2;
    private String Suburb;
    private String State;
    private boolean is_premium;

    public Property() {
    }

    public Property(String id, String area, int bedrooms, int bathrooms, int carspaces, String description, String displayPrice, String ownerFirstName, String ownerLastName, String imageUrl, String address1, String address2, String suburb, String state, boolean is_premium) {
        this.id = id;
        Area = area;
        Bedrooms = bedrooms;
        Bathrooms = bathrooms;
        Carspaces = carspaces;
        Description = description;
        DisplayPrice = displayPrice;
        OwnerFirstName = ownerFirstName;
        OwnerLastName = ownerLastName;
        this.imageUrl = imageUrl;
        Address1 = address1;
        Address2 = address2;
        Suburb = suburb;
        State = state;
        this.is_premium = is_premium;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    public int getBedrooms() {
        return Bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        Bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return Bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        Bathrooms = bathrooms;
    }

    public int getCarspaces() {
        return Carspaces;
    }

    public void setCarspaces(int carspaces) {
        Carspaces = carspaces;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDisplayPrice() {
        return DisplayPrice;
    }

    public void setDisplayPrice(String displayPrice) {
        DisplayPrice = displayPrice;
    }

    public String getOwnerFirstName() {
        return OwnerFirstName;
    }

    public void setOwnerFirstName(String ownerFirstName) {
        OwnerFirstName = ownerFirstName;
    }

    public String getOwnerLastName() {
        return OwnerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        OwnerLastName = ownerLastName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAddress1() {
        return Address1;
    }

    public void setAddress1(String address1) {
        Address1 = address1;
    }

    public String getAddress2() {
        return Address2;
    }

    public void setAddress2(String address2) {
        Address2 = address2;
    }

    public String getSuburb() {
        return Suburb;
    }

    public void setSuburb(String suburb) {
        Suburb = suburb;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public boolean is_premium() {
        return is_premium;
    }

    public void setIs_premium(boolean is_premium) {
        this.is_premium = is_premium;
    }
}

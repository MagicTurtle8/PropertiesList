package com.example.peter.propertiestablet.propertydetail;

/**
 * Contract for property details
 */
public interface PropertyDetailContract {

    interface View {
        void showPropertyId(String propertyId);
    }

    interface Presenter {

        void showPropertyDetail();
    }
}

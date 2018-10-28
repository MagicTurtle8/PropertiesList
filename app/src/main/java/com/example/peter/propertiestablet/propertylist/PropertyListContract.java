package com.example.peter.propertiestablet.propertylist;

import com.example.peter.propertiestablet.data.Property;

import java.util.ArrayList;
import java.util.List;

/**
 *  Contract for property listings
 */
public interface PropertyListContract {

    interface View {
        void showProgressBar();

        void hideProgressBar();

        void showProperties(List<Property> properties);
    }

    interface Presenter {

        void loadProperties();
    }
}

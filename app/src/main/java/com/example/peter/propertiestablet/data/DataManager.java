package com.example.peter.propertiestablet.data;

import com.example.peter.propertiestablet.data.source.Listing;
import com.example.peter.propertiestablet.data.source.Source;
import com.google.gson.Gson;

import java.io.InputStreamReader;
import java.net.URL;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Obtain observables. Operations/methods are also called here to get the desired output for the presenters
 */
public class DataManager {

    private static final String URL_PROPERTIES = "https://sentia-test.herokuapp.com/properties";
    private static Observable observable;


    public static Observable getObservable() {
        if (observable == null) {
            observable = Observable.create(new ObservableOnSubscribe<Property>() {
                @Override
                public void subscribe(ObservableEmitter<Property> emitter) {
                    try {
                        URL url = new URL(URL_PROPERTIES);
                        InputStreamReader reader = new InputStreamReader(url.openStream());
                        Source source = new Gson().fromJson(reader, Source.class);

                        for (int i = 0; i < source.getData().getListings().size(); i++) {
                            Property property = setPropertyValues(source.getData().getListings().get(i));
                            emitter.onNext(property);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        emitter.onError(e);
                    }
                    emitter.onComplete();
                }
            })
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        }
        return observable;
    }

    private static Property setPropertyValues(Listing listing) {
        String id = listing.getId();
        String area = listing.getArea();
        int bedrooms = listing.getBedrooms();
        int bathrooms = listing.getBathrooms();
        int carSpaces = listing.getCarspaces();
        String description = listing.getDescription();
        String displayPrice = listing.getDisplayPrice();
        String firstName = listing.getOwner().getName();
        String lastName = listing.getOwner().getLastName();
        String imageUrls = listing.getOwner().getImage().getMedium().getUrl();
        String address1 = listing.getLocation().getAddress();
        String address2 = listing.getLocation().getAddress2();
        String suburb = listing.getLocation().getSuburb();
        String state = listing.getLocation().getState();
        int premium = listing.getIsPremium();

        boolean isPremium = false;
        if (premium == 1) {
            isPremium = true;
        }
        return new Property(id, area, bedrooms, bathrooms, carSpaces, description, displayPrice, firstName, lastName, imageUrls, address1, address2, suburb, state, isPremium);
    }
}

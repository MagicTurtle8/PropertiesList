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
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Obtain observables. Operations/methods are also called here to get the desired output for the presenters
 */
public class DataManager {

    private static final String BASE_URL = "https://sentia-test.herokuapp.com/properties";
    private static Observable observable;
    private static Retrofit retrofit;


    public static Observable getObservable() {

        if (observable == null) {

            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build();
            }

            return retrofit.create(RetrieveService.class)
                    .getProperties()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        }

        return observable;
    }

    public static Property setPropertyValues(Listing listing) {
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

package com.example.peter.propertiestablet.propertylist;

import android.util.Log;

import com.example.peter.propertiestablet.data.DataManager;
import com.example.peter.propertiestablet.data.Property;
import com.example.peter.propertiestablet.data.source.Source;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.observers.DisposableObserver;

/**
 * Listens to user actions from the UI (PropertyListFragment), retrieves the data and updates
 * the UI as required.
 *
 * Also subscribe to observable provided by (DataManager), and process the data before calling the
 * View method, showProperties.
 *
 */
public class PropertyListPresenter implements PropertyListContract.Presenter {

    private String TAG = "PropertyListPresenter";
    private PropertyListContract.View mPropertyListView;

    PropertyListPresenter(PropertyListContract.View mPropertyListView) {
        this.mPropertyListView = mPropertyListView;
    }

    @Override
    public void loadProperties() {
        mPropertyListView.showProgressBar();
        DataManager.getObservable().subscribe(getObserver());
    }

    private DisposableObserver<Source> getObserver() {
        final List<Property> properties = new ArrayList<>();
        return new DisposableObserver<Source>() {
            @Override
            public void onNext(Source source) {
                for (int i = 0; i < source.getData().getListings().size(); i++) {
                    Property property = DataManager.setPropertyValues(source.getData().getListings().get(i));
                    properties.add(property);
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "Error " + e);
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "Completed");
                mPropertyListView.hideProgressBar();
                mPropertyListView.showProperties(properties);
                dispose();
            }
        };
    }
}

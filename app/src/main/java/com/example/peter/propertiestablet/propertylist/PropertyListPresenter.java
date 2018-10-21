package com.example.peter.propertiestablet.propertylist;

import android.util.Log;

import com.example.peter.propertiestablet.data.DataManager;
import com.example.peter.propertiestablet.data.Property;
import java.util.ArrayList;
import io.reactivex.observers.DisposableObserver;

/**
 * Listens to user actions from the UI ({@link PropertyListFragment}), retrieves the data and updates
 * the UI as required.
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

    private DisposableObserver<Property> getObserver() {
        final ArrayList<Property> properties = new ArrayList<>();
        return new DisposableObserver<Property>() {
            @Override
            public void onNext(Property property) {
                properties.add(property);
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

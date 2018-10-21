package com.example.peter.propertiestablet.propertydetail;

/**
 * Listens to user actions from the UI ({@link PropertyDetailFragment}), retrieves the data and updates
 * the UI as required.
 */
public class PropertyDetailPresenter implements PropertyDetailContract.Presenter {

    private String mPropertyId;
    private PropertyDetailContract.View mPropertyDetailView;

    PropertyDetailPresenter(String mPropertyId, PropertyDetailContract.View mPropertyDetailView) {
        this.mPropertyId = mPropertyId;
        this.mPropertyDetailView = mPropertyDetailView;
    }

    @Override
    public void showPropertyDetail() {
        mPropertyDetailView.showPropertyId(mPropertyId);
    }
}

package com.example.peter.propertiestablet.propertydetail;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.peter.propertiestablet.R;

/**
 * This fragment displays a specific a property id from which a user has selected from the property list
 */
public class PropertyDetailFragment extends Fragment implements PropertyDetailContract.View {
    private static final String ARG_PROPERTY_ID = "propertyID";

    private String mPropertyId;
    private TextView mPropertyIdTextView;
    private PropertyDetailPresenter mainPresenter;


    public static PropertyDetailFragment newInstance(String id) {
        PropertyDetailFragment fragment = new PropertyDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PROPERTY_ID, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPropertyId  = getArguments().getString(ARG_PROPERTY_ID);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_property_detail, container, false);
        mPropertyIdTextView = view.findViewById(R.id.text_view_property_id);

        setupPresenter();
        mainPresenter.showPropertyDetail();

        return  view;
    }

    private void setupPresenter() {
        mainPresenter = new PropertyDetailPresenter(mPropertyId, this);
    }

    @Override
    public void showPropertyId(String propertyId) {
        mPropertyIdTextView.setText(mPropertyId);
    }
}

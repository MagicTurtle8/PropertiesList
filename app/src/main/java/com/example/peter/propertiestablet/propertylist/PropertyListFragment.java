package com.example.peter.propertiestablet.propertylist;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.peter.propertiestablet.R;
import com.example.peter.propertiestablet.data.Property;
import java.util.ArrayList;
import java.util.List;


/**
 * This fragment displays a list of all the properties in a RecyclerView
 */
public class PropertyListFragment extends Fragment implements PropertyListContract.View {

    public static final String KEY_PROPERTY_LISTINGS = "listing_key";

    private PropertyListPresenter mainPresenter;

    private Callbacks mCallbacks;

    private RecyclerView mRecyclerView;
    private PropertyAdapter mPropertyAdapter;
    private ArrayList<Property> mProperty;
    private ProgressBar mProgressBar;


    /**
     * Delegate the functionality back to the host activity (implemented by MainActivity)
     * When an item is selected (holder.onclick()), the implemented method is called on MainActivity, which in turn
     * will open the detail fragment in the container (for tablets) and pass down the id via. bundle arguments.
     */
    public interface Callbacks {
        void onPropertySelected(Property property);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCallbacks = (Callbacks) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

    @Override
    public void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showProperties(List<Property> properties) {
        mProperty = new ArrayList<>(properties);
        setupRecyclerView();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        // Preserve data by serializing the list to save memory
        outState.putSerializable(KEY_PROPERTY_LISTINGS, mProperty);
    }

    @SuppressWarnings("unchecked")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_property_list, container, false);

        mProgressBar = view.findViewById(R.id.progress_bar);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        setupPresenter();

        if (savedInstanceState != null) {
            // Retrieve the saved list and load UI
            mProperty = (ArrayList<Property>) savedInstanceState.getSerializable(KEY_PROPERTY_LISTINGS);
            setupRecyclerView();
        } else {
            // Fresh data required
            getPropertyList();
        }

        return view;
    }

    private void setupRecyclerView(){
        if (mPropertyAdapter != null) {
            mPropertyAdapter.notifyDataSetChanged();
        } else {
            mPropertyAdapter = new PropertyAdapter(mProperty, getContext(), mCallbacks);
            mRecyclerView.setAdapter(mPropertyAdapter);
        }
    }

    private void setupPresenter() {
        mainPresenter = new PropertyListPresenter(this);
    }

    private void getPropertyList() {
        mainPresenter.loadProperties();
    }
}

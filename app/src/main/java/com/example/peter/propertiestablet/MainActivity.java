package com.example.peter.propertiestablet;

import android.support.v4.app.Fragment;

import com.example.peter.propertiestablet.data.Property;
import com.example.peter.propertiestablet.propertydetail.PropertyDetailFragment;
import com.example.peter.propertiestablet.propertylist.PropertyListFragment;

/**
 * MainActivity is the main/launcher activity.
 * It is a HostFragmentActivity, which handles how fragments are transacted.
 * It also implements onPropertySelected, which is called a user selects a property, and from there, it will
 * open the detail fragment (if screen width is wide enough), and pass down the property Id to be displayed there.
 */
public class MainActivity extends HostFragmentActivity implements PropertyListFragment.Callbacks {

    @Override
    protected Fragment createFragment() {
        return new PropertyListFragment();
    }

    @Override
    protected int getLayoutRestId() {
        return R.layout.activity_masterdetail;
    }

    @Override
    public void onPropertySelected(Property property) {
        if (findViewById(R.id.detail_fragment_container) != null) {
            Fragment newDetail = PropertyDetailFragment.newInstance(property.getId());

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_fragment_container, newDetail)
                    .commit();
        }
    }
}
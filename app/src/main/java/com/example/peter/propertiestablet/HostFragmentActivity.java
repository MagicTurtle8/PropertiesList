package com.example.peter.propertiestablet;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * HostFragmentActivity is an abstract class which dictates how a fragments should be created and
 * handled by the manager.
 */
public abstract class HostFragmentActivity extends android.support.v4.app.FragmentActivity {

    protected abstract Fragment createFragment();

    @LayoutRes
    protected int getLayoutRestId() {
        return R.layout.activity_fragment;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRestId());

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }
}

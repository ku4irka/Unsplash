package com.ku4irka.unsplash.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.ku4irka.unsplash.R;

/**
 * Created by Pavlo Kuchirka on 27-Mar-17.
 */

public class FragmentUtils {

    public static void addFragment(FragmentManager manager, Fragment fragment, String tag, boolean addBackStack) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment, tag);
        if (addBackStack) transaction.addToBackStack(null);
        transaction.commit();
    }
}

package com.ku4irka.unsplash.view.fragments;

import android.support.v4.app.Fragment;

import com.ku4irka.unsplash.presenter.BasePresenter;

/**
 * Created by Pavlo Kuchirka on 15-Mar-17.
 */

public abstract class BaseFragment extends Fragment {

    protected abstract BasePresenter getPresenter();

    @Override
    public void onStop() {
        super.onStop();

        if (getPresenter() != null) getPresenter().onStop();
    }
}

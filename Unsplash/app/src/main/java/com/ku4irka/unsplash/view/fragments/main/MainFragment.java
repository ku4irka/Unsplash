package com.ku4irka.unsplash.view.fragments.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ku4irka.unsplash.R;
import com.ku4irka.unsplash.presenter.BasePresenter;
import com.ku4irka.unsplash.view.fragments.BaseFragment;

/**
 * Created by Pavlo Kuchirka on 28-Mar-17.
 */

public class MainFragment extends BaseFragment {

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        return view;
    }
}

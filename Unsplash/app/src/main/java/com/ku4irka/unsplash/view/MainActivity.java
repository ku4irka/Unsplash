package com.ku4irka.unsplash.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.ku4irka.unsplash.R;
import com.ku4irka.unsplash.app.AppApplication;
import com.ku4irka.unsplash.app.Const;
import com.ku4irka.unsplash.app.helper.PreferencesHelper;
import com.ku4irka.unsplash.view.fragments.authenticate.AuthFragment;
import com.ku4irka.unsplash.view.fragments.main.MainFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.ku4irka.unsplash.util.FragmentUtils.addFragment;

public class MainActivity extends AppCompatActivity {

    PreferencesHelper mPrefHelper;

    @BindView(R.id.toolbar) Toolbar mToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(Const.TAG);
        if (fragment == null) {
            mPrefHelper = AppApplication.getInstance().getAppComponent().preferencesHelper();

            if (mPrefHelper.getToken() == null)
                fragment = new AuthFragment();
            else
                fragment = new MainFragment();

            addFragment(fragmentManager, fragment, Const.TAG, false);
        }
    }
}

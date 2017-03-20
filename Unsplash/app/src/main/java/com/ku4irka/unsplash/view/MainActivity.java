package com.ku4irka.unsplash.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.ku4irka.unsplash.R;
import com.ku4irka.unsplash.view.fragments.authenticate.AuthFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TAG";

    private FragmentManager mFragmentManager;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

//    private BasePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        mFragmentManager = getSupportFragmentManager();
        Fragment fragment = mFragmentManager.findFragmentByTag(TAG);
        if (fragment == null) replaceFragment(new AuthFragment(), false);

//        presenter = new AuthPresenterImp(this);

//        buttonSignIn.setOnClickListener(v -> presenter.onSignInClick());
    }

    private void replaceFragment(Fragment fragment, boolean addBackStack) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragment, TAG);
        if (addBackStack) transaction.addToBackStack(null);
        transaction.commit();
    }
}

package com.ku4irka.unsplash.view.fragments.authenticate;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.ku4irka.unsplash.R;
import com.ku4irka.unsplash.app.Const;
import com.ku4irka.unsplash.presenter.BasePresenter;
import com.ku4irka.unsplash.presenter.authenticate.AuthPresenterImp;
import com.ku4irka.unsplash.view.fragments.BaseFragment;
import com.ku4irka.unsplash.view.fragments.main.MainFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.ku4irka.unsplash.util.FragmentUtils.addFragment;

/**
 * Created by Pavlo Kuchirka on 14-Mar-17.
 */

public class AuthFragment extends BaseFragment implements AuthFragmentView {

    @BindView(R.id.webView) WebView mWebView;

    private Unbinder mUnbinder;

    private AuthPresenterImp mPresenter = new AuthPresenterImp(this);

    @Override
    protected BasePresenter getPresenter() {
        return mPresenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_auth_webview, container, false);
        mUnbinder = ButterKnife.bind(this, view);

        initWebView();

        return view;
    }

    @Override
    public void initWebView() {
        WebViewClient client = mPresenter.getWebViewClient();
        mWebView.setWebViewClient(client);

        String link = mPresenter.getLoginUrl();
        mWebView.loadUrl(link);
    }

    @Override
    public void goToMainFragment() {
        addFragment(getFragmentManager(), new MainFragment(), Const.TAG, true);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this.getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}

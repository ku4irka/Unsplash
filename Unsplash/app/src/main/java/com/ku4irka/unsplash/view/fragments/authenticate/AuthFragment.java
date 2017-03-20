package com.ku4irka.unsplash.view.fragments.authenticate;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.ku4irka.unsplash.R;
import com.ku4irka.unsplash.app.AppApplication;
import com.ku4irka.unsplash.app.Const;
import com.ku4irka.unsplash.presenter.BasePresenter;
import com.ku4irka.unsplash.presenter.authenticate.AuthPresenterImp;
import com.ku4irka.unsplash.view.fragments.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.ku4irka.unsplash.app.Const.LOGIN_URL;

/**
 * Created by Pavlo Kuchirka on 14-Mar-17.
 */

public class AuthFragment extends BaseFragment implements AuthFragmentView {

    @BindView(R.id.webView)
    WebView mWebView;

    private Unbinder mUnbinder;

    private AuthPresenterImp mPresenter = new AuthPresenterImp(this);

    @Override
    protected BasePresenter getPresenter() {
        return mPresenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_auth_webview, container, false);
        mUnbinder = ButterKnife.bind(this, view);

        mPresenter.getLoginUrl();
        return view;
    }

    @Override
    public void setWebView(String link) {
        mWebView.setWebViewClient(new WebViewClient() {

            // if you use api >= 21, you can use shouldOverrideUrlLoading(WebView view, WebResourceRequest request)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Uri uri = Uri.parse(url);

                if (uri.getHost().equals(Const.HOST_URL) && uri.getPath().contains("oauth/authorize") && uri.getQueryParameter("client_id") == null) {
                    String code = uri.getLastPathSegment();
                    mPresenter.getAccessToken(code);

                    return true; //Indicates WebView to NOT load the url;
                }
                return false; //Allow WebView to load url
            }
        });


        mWebView.loadUrl(link);
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

package com.ku4irka.unsplash.presenter;

import com.ku4irka.unsplash.model.Model;
import com.ku4irka.unsplash.model.ModelImp;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Pavlo Kuchirka on 13-Mar-17.
 */

public abstract class BasePresenter implements Presenter{

    protected Model mDataModel = new ModelImp();
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    protected void addDisposable(Disposable disposable) {
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void onStop() {
        mCompositeDisposable.clear();
    }
}

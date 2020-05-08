package com.example.currencyapp.presenters;

import com.example.currencyapp.views.MVPView;

/**
 * @author zoubair
 * @since 07/05/20
 */
public interface Presenter<V extends MVPView> {

    void attachView(V mvpView);

    void detachView();

}

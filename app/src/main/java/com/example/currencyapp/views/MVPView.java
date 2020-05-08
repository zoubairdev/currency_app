package com.example.currencyapp.views;

/**
 * @author zoubair
 * @since 07/05/20
 */
public interface MVPView {

    /**
     * Should be called when a time taking process starts and we want the user
     * to wait for the process to finish. The UI should gracefully display some
     * sort of progress bar or animation so that the user knows that the app is
     * doing some work and has not stalled.
     * <p>
     * For example: a network request to the API is made for authenticating
     * the user.
     */
    default void showProgress() {
    }

    /**
     * Should be called when a time taking process ends and we have some result
     * for the user.
     */
    default void hideProgress() {
    }
}

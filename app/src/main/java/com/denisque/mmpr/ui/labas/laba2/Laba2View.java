package com.denisque.mmpr.ui.labas.laba2;

import com.arellomobile.mvp.MvpView;

public interface Laba2View extends MvpView {

    void changeEps(double val);

    void showResultIntoConsole(String result);

    void showMessage(String message);
}

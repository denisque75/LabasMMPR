package com.denisque.mmpr.ui.labas.laba2;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.denisque.mmpr.core.interactors.FormulaInteractor;
import com.denisque.mmpr.core.validator.Validator;

@InjectViewState
public class Laba2Presenter extends MvpPresenter<Laba2View> {
    private final FormulaInteractor<String> interactor;
    private final Validator<String> validator;

    public Laba2Presenter(FormulaInteractor<String> interactor, Validator<String> validator) {
        this.interactor = interactor;
        this.validator = validator;
    }

    public void calculateFormula(double eps) {
        interactor.calculate(eps, result -> {
            if (result != null) {
                getViewState().showResultIntoConsole(result);
            }
        });
    }

    public void changeEps(String eps) {
        if (validator.isValid(eps)) {
            getViewState().changeEps(Double.valueOf(eps));
        } else {
            getViewState().showMessage("Non valid eps!");
        }
    }

    public void clearConsole() {
        getViewState().showResultIntoConsole("");
    }
}

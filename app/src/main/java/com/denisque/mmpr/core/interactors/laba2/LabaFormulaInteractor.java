package com.denisque.mmpr.core.interactors.laba2;

import android.os.Handler;
import android.os.Looper;

import com.denisque.mmpr.core.callbacks.OnResultCalculated;
import com.denisque.mmpr.core.executor.FormulaExecutor;
import com.denisque.mmpr.core.interactors.FormulaInteractor;


public class LabaFormulaInteractor implements FormulaInteractor<String> {
    private final FormulaExecutor<String> executor;
    private final Handler handler;

    public LabaFormulaInteractor(FormulaExecutor<String> executor) {
        this.executor = executor;
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void calculate(double eps, OnResultCalculated<String> onResultCalculated) {
        Thread thread = new Thread(() -> {
            String result = executor.calculate(eps);
            handler.post(() -> onResultCalculated.success(result));
        });
        thread.start();
    }
}

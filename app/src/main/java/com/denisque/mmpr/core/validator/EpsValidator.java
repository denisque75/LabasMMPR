package com.denisque.mmpr.core.validator;

import android.text.TextUtils;

public class EpsValidator implements Validator<String> {

    @Override
    public boolean isValid(String s) {
        if (TextUtils.isEmpty(s)) {
            return false;
        }
        try {
            Double.valueOf(s);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
}

package com.denisque.mmpr.ui.labas.laba2;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.denisque.mmpr.R;
import com.denisque.mmpr.constants.LabaConstant;
import com.denisque.mmpr.core.executor.FormulaExecutor;
import com.denisque.mmpr.core.executor.laba2.Laba2Executor;
import com.denisque.mmpr.core.executor.laba3.Laba3Executor;
import com.denisque.mmpr.core.executor.laba4.Laba4Executor;
import com.denisque.mmpr.core.interactors.FormulaInteractor;
import com.denisque.mmpr.core.interactors.laba2.LabaFormulaInteractor;
import com.denisque.mmpr.core.validator.EpsValidator;
import com.denisque.mmpr.core.validator.Validator;
import com.denisque.mmpr.ui.OnFragmentInteractionListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Laba2Fragment extends MvpAppCompatFragment implements Laba2View {
    public static final String TAG = "Laba2Fragment";

    private static final String LABA_NUMBER = "laba.number";

    private OnFragmentInteractionListener listener;
    private Toast toast;

    @BindView(R.id.textView_laba2_formula)
    TextView formulaTextView;
    @BindView(R.id.textView_laba2_epsValue)
    TextView epsValueTextView;
    @BindView(R.id.textView_laba2_changeEps)
    TextView changeEpsTextView;
    @BindView(R.id.editText_laba2_editEps)
    EditText editEpsEditText;
    @BindView(R.id.button_laba2_changeEps)
    Button changeEpsButton;
    @BindView(R.id.textView_laba2_console)
    TextView consoleTextView;
    @BindView(R.id.button_laba2_calculate)
    Button calculateButton;
    @BindView(R.id.button_laba2_clear)
    Button clearButton;

    @InjectPresenter
    Laba2Presenter presenter;

    @ProvidePresenter
    public Laba2Presenter provideLaba2Presenter() {
        Validator<String> validator = new EpsValidator();
        FormulaExecutor<String> executor = getExecutor(getArguments().getInt(LABA_NUMBER));
        FormulaInteractor<String> interactor = new LabaFormulaInteractor(executor);
        presenter = new Laba2Presenter(interactor, validator);
        return presenter;
    }

    @Nullable
    private FormulaExecutor<String> getExecutor(int labaNumber) {
        switch (labaNumber) {
            case 2:
                return new Laba2Executor();
            case 3:
                return new Laba3Executor();
            case 4:
                return new Laba4Executor();
            default:
                return null;
        }
    }

    public Laba2Fragment() {
        // Required empty public constructor
    }

    public static Laba2Fragment newInstance(int labaNumber) {
        Laba2Fragment fragment = new Laba2Fragment();
        Bundle args = new Bundle();
        args.putInt(LABA_NUMBER, labaNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_laba2, container, false);
        ButterKnife.bind(this, rootView);

        initUI();

        //make textView scrollable
        consoleTextView.setMovementMethod(new ScrollingMovementMethod());

        return rootView;
    }

    private void initUI() {
        formulaTextView.setText(getFormula());

        presenter.changeEps(Double.toString(LabaConstant.EPS));

        changeEpsTextView.setOnClickListener(v -> {
            changeEpsTextView.setVisibility(View.GONE);
            editEpsEditText.setVisibility(View.VISIBLE);
            changeEpsButton.setVisibility(View.VISIBLE);
        });

        changeEpsButton.setOnClickListener(v -> {
            presenter.changeEps(editEpsEditText.getText().toString());
            editEpsEditText.setVisibility(View.GONE);
            changeEpsButton.setVisibility(View.GONE);
            changeEpsTextView.setVisibility(View.VISIBLE);
        });

        calculateButton.setOnClickListener(v -> {
            presenter.calculateFormula(Double.valueOf(epsValueTextView.getText().toString()));
        });

        clearButton.setOnClickListener(v -> {
            presenter.clearConsole();
        });
    }

    @Nullable
    private String getFormula() {
        int labaNumb = getArguments().getInt(LABA_NUMBER);
        switch (labaNumb) {
            case 2:
                return getResources().getString(R.string.laba2_formula);
            case 3:
                return getResources().getString(R.string.laba3_and_4_formula);
            case 4:
                return getResources().getString(R.string.laba3_and_4_formula);
            default:
                return null;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            listener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public void changeEps(double val) {
        epsValueTextView.setText(String.valueOf(val));
    }

    @Override
    public void showResultIntoConsole(String result) {
        consoleTextView.setText(result);
    }

    @Override
    public void showMessage(String message) {
        if(toast != null)
            toast.cancel();
        toast = Toast.makeText(getContext(), message, Toast.LENGTH_SHORT);
        toast.show();
    }
}

package com.denisque.mmpr.ui.labas;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.denisque.mmpr.R;
import com.denisque.mmpr.constants.MenuConstants;
import com.denisque.mmpr.core.callbacks.OnMenuItemChose;
import com.denisque.mmpr.core.entity.MenuEntity;
import com.denisque.mmpr.core.repository.asset.LabaEntryAssetRepository;
import com.denisque.mmpr.core.repository.asset.MenuAssetRepository;
import com.denisque.mmpr.ui.OnFragmentInteractionListener;
import com.denisque.mmpr.ui.labas.laba2.Laba2Fragment;
import com.denisque.mmpr.ui.main_activity.adapter.MenuRecyclerViewAdapter;
import com.denisque.mmpr.ui.main_activity.presenter.MainPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuFragment extends MvpAppCompatFragment implements MainView, OnMenuItemChose {
    public static final String TAG = "MenuFragment";

    @InjectPresenter
    MainPresenter presenter;

    @BindView(R.id.activity_main_recyclerView)
    RecyclerView menuRecyclerView;

    private MenuRecyclerViewAdapter adapter;

    private OnFragmentInteractionListener listener;

    public MenuFragment() {
        // Required empty public constructor
    }

    public static MenuFragment newInstance() {
        return new MenuFragment();
    }

    @ProvidePresenter
    public MainPresenter provideMainPresenter() {
        MenuAssetRepository menuAssetRepository = new LabaEntryAssetRepository();
        presenter = new MainPresenter(menuAssetRepository);
        return presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_menu, container, false);
        ButterKnife.bind(this, rootView);

        menuRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MenuRecyclerViewAdapter(this);
        menuRecyclerView.setAdapter(adapter);
        return rootView;
    }

    @Override
    public void showMenu(List<MenuEntity> menuEntities) {
        adapter.setItems(menuEntities);
    }

    @Override
    public void onItemChose(String labaNumber) {
        switch (labaNumber) {
            case MenuConstants.BTN2:
                listener.onFragmentChose(Laba2Fragment.newInstance(2), Laba2Fragment.TAG);
                break;
            case MenuConstants.BTN3:
                listener.onFragmentChose(Laba2Fragment.newInstance(3), Laba2Fragment.TAG);
                break;
            case MenuConstants.BTN4:
                listener.onFragmentChose(Laba2Fragment.newInstance(4), Laba2Fragment.TAG);
                break;
            default:
                break;
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

}

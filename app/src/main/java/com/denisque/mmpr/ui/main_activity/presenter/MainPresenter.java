package com.denisque.mmpr.ui.main_activity.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.denisque.mmpr.core.callbacks.EntityCallback;
import com.denisque.mmpr.core.entity.MenuEntity;
import com.denisque.mmpr.core.repository.asset.MenuAssetRepository;
import com.denisque.mmpr.ui.labas.MainView;

import java.util.List;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {
    private final MenuAssetRepository menuAssetRepository;

    public MainPresenter(MenuAssetRepository menuAssetRepository) {
        this.menuAssetRepository = menuAssetRepository;
        displayMenu();
    }

    private void displayMenu() {
        menuAssetRepository.downloadMenuAsset(new EntityCallback<List<MenuEntity>>() {
            @Override
            public void onSuccess(List<MenuEntity> menuEntities) {
                getViewState().showMenu(menuEntities);
            }

            @Override
            public void onFailure(Exception ex) {
                //todo handle exception
            }
        });
    }


}

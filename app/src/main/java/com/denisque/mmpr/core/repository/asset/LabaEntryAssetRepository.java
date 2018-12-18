package com.denisque.mmpr.core.repository.asset;

import com.denisque.mmpr.constants.MenuAsset;
import com.denisque.mmpr.core.callbacks.EntityCallback;
import com.denisque.mmpr.core.entity.MenuEntity;

import java.util.List;

public class LabaEntryAssetRepository implements MenuAssetRepository{

    @Override
    public void downloadMenuAsset(EntityCallback<List<MenuEntity>> entityCallback) {
        List<MenuEntity> menuEntities = MenuAsset.MENU_ENTITIES;
        entityCallback.onSuccess(menuEntities);
    }
}

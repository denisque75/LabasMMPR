package com.denisque.mmpr.core.repository.asset;

import com.denisque.mmpr.core.callbacks.EntityCallback;
import com.denisque.mmpr.core.entity.MenuEntity;

import java.util.List;

public interface MenuAssetRepository {

    void downloadMenuAsset(EntityCallback<List<MenuEntity>> entityCallback);
}

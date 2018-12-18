package com.denisque.mmpr.constants;

import com.denisque.mmpr.core.entity.MenuEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class MenuAsset {
    public static List<MenuEntity> MENU_ENTITIES;

    static {
        MENU_ENTITIES = new ArrayList<>();

        MENU_ENTITIES.add(MenuConstants.LABA2_ENTITY);
        MENU_ENTITIES.add(MenuConstants.LABA3_ENTITY);
        MENU_ENTITIES.add(MenuConstants.LABA4_ENTITY);
    }
}

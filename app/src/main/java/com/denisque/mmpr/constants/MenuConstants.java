package com.denisque.mmpr.constants;

import com.denisque.mmpr.core.entity.MenuEntity;

public interface MenuConstants {
    String LABA2_TITLE = "Newton-Raphson Method";
    String LABA3_TITLE = "Gradient Method";
    String LABA4_TITLE = "Quickest Descent";
    String LABA5_TITLE = "Laba 5";

    String BTN2 = "Laba 2";
    String BTN3 = "Laba 3";
    String BTN4 = "Laba 4";
    String BTN5 = "Laba 5";

    MenuEntity LABA2_ENTITY = new MenuEntity(LABA2_TITLE, BTN2);
    MenuEntity LABA3_ENTITY = new MenuEntity(LABA3_TITLE, BTN3);
    MenuEntity LABA4_ENTITY = new MenuEntity(LABA4_TITLE, BTN4);
    MenuEntity LABA5_ENTITY = new MenuEntity(LABA5_TITLE, BTN5);

}

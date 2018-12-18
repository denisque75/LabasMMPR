package com.denisque.mmpr.ui.labas;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.denisque.mmpr.core.entity.MenuEntity;

import java.util.List;

@StateStrategyType(OneExecutionStateStrategy.class)
public interface MainView extends MvpView {

    void showMenu(List<MenuEntity> menuEntities);
}

package com.denisque.mmpr.ui.main_activity.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.denisque.mmpr.R;
import com.denisque.mmpr.core.callbacks.OnMenuItemChose;
import com.denisque.mmpr.core.entity.MenuEntity;

import java.util.ArrayList;
import java.util.List;

public class MenuRecyclerViewAdapter extends RecyclerView.Adapter<MenuRecyclerViewAdapter.ViewHolder> {
    private final OnMenuItemChose onMenuItemChose;
    private final List<MenuEntity> menuEntities;

    public MenuRecyclerViewAdapter(OnMenuItemChose onMenuItemChose) {
        this.onMenuItemChose = onMenuItemChose;
        menuEntities = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.laba_item_main_recycler_view, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(menuEntities.get(i));
    }

    @Override
    public int getItemCount() {
        return menuEntities.size();
    }

    public void setItems(List<MenuEntity> entities) {
        menuEntities.clear();
        menuEntities.addAll(entities);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private Button openFragmentBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textView_mainRecyclerView_labaNumber);
            openFragmentBtn = itemView.findViewById(R.id.button_mainRecyclerView_openLaba);
        }

        void bind(final MenuEntity entity) {
            title.setText(entity.getTitle());
            openFragmentBtn.setText(entity.getButtonText());

            openFragmentBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onMenuItemChose.onItemChose(entity.getButtonText());
                }
            });
        }
    }
}

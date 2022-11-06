package com.example.appsantander.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appsantander.R;
import com.example.appsantander.ui.MenuItemButton;

import java.util.List;

public class MenuItemAdapter extends RecyclerView.Adapter<MenuItemAdapter.MenuItemButtonViewHolder> {

    private final List<MenuItemButton> buttons;

    public MenuItemAdapter(List<MenuItemButton> buttons) {
        this.buttons = buttons;
    }

    @NonNull
    @Override
    public MenuItemAdapter.MenuItemButtonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, parent, false);
        return new MenuItemAdapter.MenuItemButtonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuItemAdapter.MenuItemButtonViewHolder holder, int position) {
        holder.bind(buttons.get(position));
    }

    @Override
    public int getItemCount() {
        return buttons.size();
    }

    class MenuItemButtonViewHolder extends RecyclerView.ViewHolder{
        private final ImageView icon;
        private final TextView title;
        private final TextView description;

        public MenuItemButtonViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.menu_item_icon);
            title = itemView.findViewById(R.id.menu_item_title);
            description = itemView.findViewById(R.id.menu_item_description);
        }

        public void bind(MenuItemButton menuItemButton){
            Integer iconResource = menuItemButton.getIconResource();
            String titleText = menuItemButton.getText();
            String descriptionText = menuItemButton.getDescription();

            if (titleText != null){
                this.title.setText(titleText);
            }else{
                this.title.setVisibility(View.GONE);
            }

            if (descriptionText != null){
                this.description.setText(descriptionText);
            }else{
                this.description.setVisibility(View.GONE);
            }

            if (iconResource != null){
                this.icon.setImageResource(iconResource);
            }else{
                this.icon.setVisibility(View.GONE);
            }

            this.itemView.setOnClickListener(menuItemButton.getOnClickListener());
        }
    }
}

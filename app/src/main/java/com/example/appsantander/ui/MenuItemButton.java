package com.example.appsantander.ui;

import android.view.View;

public class MenuItemButton extends CardButton{
    private String description;

    public MenuItemButton(String text, Integer iconResource, View.OnClickListener onClickListener, String description){
        super(text, iconResource, onClickListener);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

package com.example.appsantander.ui;

import android.view.View;

public class MenuItemButton extends CardButton{
    private final String description;
    private final Integer rightIcon;

    public MenuItemButton(String text, Integer iconResource, View.OnClickListener onClickListener, String description, Integer rightIcon){
        super(text, iconResource, onClickListener);
        this.description = description;
        this.rightIcon = rightIcon;
    }

    public String getDescription() {
        return description;
    }

    public Integer getRightIcon() {
        return rightIcon;
    }
}

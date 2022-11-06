package com.example.appsantander.ui;

import android.view.View;

public class CardButton {
    protected final String text;
    protected final Integer iconResource;
    protected final View.OnClickListener onClickListener;

    public CardButton(String text, Integer iconResource, View.OnClickListener onClickListener) {
        this.text = text;
        this.iconResource = iconResource;
        this.onClickListener = onClickListener;
    }

    public String getText() {
        return text;
    }

    public Integer getIconResource() {
        return iconResource;
    }

    public View.OnClickListener getOnClickListener() {
        return onClickListener;
    }
}

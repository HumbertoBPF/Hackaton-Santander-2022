package com.example.appsantander.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appsantander.R;
import com.example.appsantander.ui.CardButton;

import java.util.List;

public class CardItemAdapter extends RecyclerView.Adapter<CardItemAdapter.CardButtonViewHolder> {
    private final List<CardButton> buttons;
    private final Integer layoutResource;

    public CardItemAdapter(List<CardButton> buttons, Integer layoutResource) {
        this.buttons = buttons;
        this.layoutResource = layoutResource;
    }

    @NonNull
    @Override
    public CardItemAdapter.CardButtonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutResource, parent, false);
        return new CardButtonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardItemAdapter.CardButtonViewHolder holder, int position) {
        holder.bind(buttons.get(position));
    }

    @Override
    public int getItemCount() {
        return buttons.size();
    }

    class CardButtonViewHolder extends RecyclerView.ViewHolder{
        private final ImageView imageView;
        private final TextView textView;

        public CardButtonViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.card_icon);
            textView = itemView.findViewById(R.id.card_text);
        }

        public void bind(CardButton cardButton){
            textView.setText(cardButton.getText());
            this.itemView.setOnClickListener(cardButton.getOnClickListener());
        }
    }
}

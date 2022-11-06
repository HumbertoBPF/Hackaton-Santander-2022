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

    public CardItemAdapter(List<CardButton> buttons) {
        this.buttons = buttons;
    }

    @NonNull
    @Override
    public CardItemAdapter.CardButtonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
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
            String buttonText = cardButton.getText();
            Integer buttonImageResource = cardButton.getIconResource();

            if (cardButton.getText() != null){
                textView.setText(buttonText);
            }

            if (cardButton.getIconResource() != null){
                this.imageView.setImageResource(buttonImageResource);
            }

            this.itemView.setOnClickListener(cardButton.getOnClickListener());
        }
    }
}

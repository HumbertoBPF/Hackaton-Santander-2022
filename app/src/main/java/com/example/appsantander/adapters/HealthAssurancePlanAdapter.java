package com.example.appsantander.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appsantander.R;
import com.example.appsantander.activities.AssuranceConfirmationActivity;
import com.example.appsantander.ui.HealthAssurancePlan;

import java.util.List;

public class HealthAssurancePlanAdapter extends RecyclerView.Adapter<HealthAssurancePlanAdapter.HealthAssurancePlanViewHolder> {
    private final Context context;
    private final List<HealthAssurancePlan> plans;

    public HealthAssurancePlanAdapter(Context context, List<HealthAssurancePlan> plans) {
        this.context = context;
        this.plans = plans;
    }

    @NonNull
    @Override
    public HealthAssurancePlanAdapter.HealthAssurancePlanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.health_assurance_plan_item, parent, false);
        return new HealthAssurancePlanAdapter.HealthAssurancePlanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HealthAssurancePlanAdapter.HealthAssurancePlanViewHolder holder, int position) {
        holder.bind(plans.get(position));
    }

    @Override
    public int getItemCount() {
        return plans.size();
    }

    class HealthAssurancePlanViewHolder extends RecyclerView.ViewHolder{
        private final TextView title;
        private final TextView description;
        private final TextView price;

        public HealthAssurancePlanViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_text_view);
            description = itemView.findViewById(R.id.description_text_view);
            price = itemView.findViewById(R.id.price_text_view);
        }

        public void bind(HealthAssurancePlan plan){
            title.setText(plan.getTitle());
            String descriptionItems = "";

            for (String item: plan.getDescription()){
                descriptionItems += "- "+item+"\n\n";
            }

            description.setText(descriptionItems);
            price.setText(plan.getPrice());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, AssuranceConfirmationActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }
}

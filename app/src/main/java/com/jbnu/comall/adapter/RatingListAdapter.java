package com.jbnu.comall.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.jbnu.comall.R;
import com.jbnu.comall.model.Examine;
import com.jbnu.comall.model.Rating;

import java.util.List;

public class RatingListAdapter extends RecyclerView.Adapter<RatingListAdapter.ViewHolder> {

    private OnItemClickListener listener1;
    private List<Rating> Data;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView evaluation;
        TextView evaluation_name;
        TextView management;
        TextView management_name;
        TextView performance;
        TextView performance_name;
        TextView priceper;
        TextView priceper_name;
        TextView ratingname;

        ViewHolder(View itemView) {
            super(itemView);
            priceper = itemView.findViewById(R.id.rating_priceper);
            management = itemView.findViewById(R.id.rating_management);
            evaluation =  itemView.findViewById(R.id.rating_evaluation);
            ratingname =  itemView.findViewById(R.id.rating_name);
            performance = itemView.findViewById(R.id.rating_performance);
            priceper_name =  itemView.findViewById(R.id.priceper_name);
            management_name =  itemView.findViewById(R.id.management_name);
            performance_name =  itemView.findViewById(R.id.performance_name);
            evaluation_name = itemView.findViewById(R.id.evaluation_name);

            itemView.setOnClickListener(v -> {
                int pos = getAdapterPosition();
                if (pos != RecyclerView.NO_POSITION) {
                    try {
                        listener1.onItemClick(v, pos);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public RatingListAdapter(List<Rating> list1, OnItemClickListener listener1) {
        this.listener1 = listener1;
        this.Data = list1;
    }

    @Override
    public RatingListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_rating, parent, false);
        return new RatingListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RatingListAdapter.ViewHolder holder, int position) {
        Rating rating = Data.get(position);
        holder.ratingname.setText(rating.getRatingname());
        holder.priceper.setText(rating.getPriceper());
        holder.performance.setText(rating.getPerformance());
        holder.management.setText(rating.getManagement());
        holder.evaluation.setText(rating.getEvaluation());
        holder.evaluation_name.setText(rating.getEvaluation_name());
        holder.management_name.setText(rating.getManagement_name());
        holder.performance_name.setText(rating.getPerformance_name());
        holder.priceper_name.setText(rating.getPriceper_name());


    }

    @Override
    public int getItemCount() {
        return Data.size();
    }
}
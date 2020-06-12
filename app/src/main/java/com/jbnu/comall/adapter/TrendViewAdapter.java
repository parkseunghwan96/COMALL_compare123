package com.jbnu.comall.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jbnu.comall.R;
import com.jbnu.comall.model.TrendView;

import java.util.List;

public class TrendViewAdapter extends RecyclerView.Adapter <TrendViewAdapter.ViewHolder> {

    private OnItemClickListener listener2;
    private List<TrendView> nData;

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView trend_image;



        ViewHolder(View itemView) {
            super(itemView);
            trend_image = itemView.findViewById(R.id.trend_thumbnail);

            itemView.setOnClickListener(v -> {
                int pos = getAdapterPosition();
                if (pos != RecyclerView.NO_POSITION) {
                    try {
                        listener2.onItemClick(v, pos);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public TrendViewAdapter(List<TrendView> list2, OnItemClickListener listener2) {
        this.listener2 = listener2;
        this.nData = list2;
    }

    @Override
    public TrendViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_trendview, parent, false);
        return new TrendViewAdapter.ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(TrendViewAdapter.ViewHolder holder, int position) {
        System.out.println(nData.get(position));
        TrendView trend_views = nData.get(position);

        Glide.with(holder.trend_image.getContext())
                .load(trend_views.getTrend_image())
                .into(holder.trend_image);




    }

    @Override
    public int getItemCount() {
        return nData.size();
    }
}

package com.jbnu.comall.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jbnu.comall.R;
import com.jbnu.comall.model.TrendList;

import java.util.List;

public class TrendListAdapter extends RecyclerView.Adapter<TrendListAdapter.ViewHolder>{
    private OnItemClickListener listener2;
    private List<TrendList> nData;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView trendtext;



        ViewHolder(View itemView) {
            super(itemView);
            trendtext = itemView.findViewById(R.id.trend_text);


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

    public TrendListAdapter(List<TrendList> list2, OnItemClickListener listener2) {
        this.listener2 = listener2;
        this.nData = list2;
    }

    @Override
    public TrendListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_trend, parent, false);
        return new TrendListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TrendListAdapter.ViewHolder holder, int position) {
        System.out.println(nData.get(position));
        TrendList trendList = nData.get(position);
        holder.trendtext.setText(trendList.getTrendtext());

    }

    @Override
    public int getItemCount() {
        return nData.size();
    }
}


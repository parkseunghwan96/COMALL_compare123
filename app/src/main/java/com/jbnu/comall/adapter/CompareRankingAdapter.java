package com.jbnu.comall.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.jbnu.comall.R;
import com.jbnu.comall.model.CompareRanking;

import java.util.List;

public class CompareRankingAdapter extends RecyclerView.Adapter<CompareRankingAdapter.ViewHolder> {

    private OnItemClickListener listener1;
    private List<CompareRanking> Data;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView partname;
        TextView partscore;

        ViewHolder(View itemView) {
            super(itemView);
            partname = itemView.findViewById(R.id.part_name);
            partscore = itemView.findViewById(R.id.part_score);

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

    public CompareRankingAdapter(List<CompareRanking> list1, OnItemClickListener listener1) {
        this.listener1 = listener1;
        this.Data = list1;
    }

    @Override
    public CompareRankingAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_ranking_list, parent, false);
        return new CompareRankingAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CompareRankingAdapter.ViewHolder holder, int position) {
        System.out.println(Data.get(position));
        CompareRanking compareRanking = Data.get(position);
        holder.partname.setText(compareRanking.getPartname());
        holder.partscore.setText(compareRanking.getPartscore());




    }

    @Override
    public int getItemCount() {
        return Data.size();
    }
}
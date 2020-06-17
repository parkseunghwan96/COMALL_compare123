package com.jbnu.comall.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.jbnu.comall.R;
import com.jbnu.comall.model.Compare;

import java.util.List;

public class CompareListAdapter extends RecyclerView.Adapter<CompareListAdapter.ViewHolder> {

    private OnItemClickListener listener1;
    private List<Compare> Data;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView spec1;
        TextView spec2;
        TextView spec3;

        ViewHolder(View itemView) {
            super(itemView);
            spec1 = itemView.findViewById(R.id.spec1);
            spec2 = itemView.findViewById(R.id.spec2);
            spec3 = itemView.findViewById(R.id.spec3);

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

    public CompareListAdapter(List<Compare> list1, OnItemClickListener listener1) {
        this.listener1 = listener1;
        this.Data = list1;
    }

    @Override
    public CompareListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_compare, parent, false);
        return new CompareListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CompareListAdapter.ViewHolder holder, int position) {
        System.out.println(Data.get(position));
        Compare compare = Data.get(position);
        holder.spec1.setText(compare.getSpec1());
        holder.spec2.setText(compare.getSpec2());
        holder.spec3.setText(compare.getSpec3());




    }

    @Override
    public int getItemCount() {
        return Data.size();
    }
}
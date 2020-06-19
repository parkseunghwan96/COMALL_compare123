package com.jbnu.comall.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.jbnu.comall.R;
import com.jbnu.comall.model.ComparePart;

import java.util.List;

public class ComparePartAdapter extends RecyclerView.Adapter<ComparePartAdapter.ViewHolder> {

    private OnItemClickListener listener1;
    private List<ComparePart> Data;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView comparetext;

        ViewHolder(View itemView) {
            super(itemView);
            comparetext = itemView.findViewById(R.id.compare_text);


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

    public ComparePartAdapter(List<ComparePart> list1, OnItemClickListener listener1) {
        this.listener1 = listener1;
        this.Data = list1;
    }

    @Override
    public ComparePartAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_compare_part, parent, false);
        return new ComparePartAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ComparePartAdapter.ViewHolder holder, int position) {
        System.out.println(Data.get(position));
        ComparePart comparePart = Data.get(position);
        holder.comparetext.setText(comparePart.getComparetext());




    }

    @Override
    public int getItemCount() {
        return Data.size();
    }
}
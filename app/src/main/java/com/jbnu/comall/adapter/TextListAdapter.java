package com.jbnu.comall.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.jbnu.comall.R;

import java.util.List;

public class TextListAdapter extends RecyclerView.Adapter<TextListAdapter.ViewHolder> {

    private List<String> mData;
    private OnItemClickListener listener;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item_text);

            itemView.setOnClickListener(v -> {
                int pos = getAdapterPosition();
                if (pos != RecyclerView.NO_POSITION) {
                    try {
                        listener.onItemClick(v, pos);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public TextListAdapter(List<String> list, OnItemClickListener listener) {
        this.mData = list;
        this.listener = listener;
    }

    @Override
    public TextListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_text, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TextListAdapter.ViewHolder holder, int position) {
        String text = mData.get(position);
        holder.textView.setText(text);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
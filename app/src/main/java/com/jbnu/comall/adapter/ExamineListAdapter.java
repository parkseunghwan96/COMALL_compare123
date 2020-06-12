package com.jbnu.comall.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.jbnu.comall.R;
import com.jbnu.comall.model.Examine;

import java.util.List;

public class ExamineListAdapter extends RecyclerView.Adapter<ExamineListAdapter.ViewHolder> {

    private OnItemClickListener listener1;
    private List<Examine> Data;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView examine_info;
        TextView examine_text;

        ViewHolder(View itemView) {
            super(itemView);
            examine_info = itemView.findViewById(R.id.examine_info);
            examine_text = itemView.findViewById(R.id.examine_text);

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

    public ExamineListAdapter(List<Examine> list1, OnItemClickListener listener1) {
        this.listener1 = listener1;
        this.Data = list1;
    }

    @Override
    public ExamineListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_examine, parent, false);
        return new ExamineListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ExamineListAdapter.ViewHolder holder, int position) {
        System.out.println(Data.get(position));
        Examine examine = Data.get(position);
        holder.examine_info.setText(examine.getExamine_info());
        holder.examine_text.setText(examine.getExamine_text());


    }

    @Override
    public int getItemCount() {
        return Data.size();
    }
}
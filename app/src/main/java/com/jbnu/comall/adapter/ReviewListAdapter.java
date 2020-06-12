package com.jbnu.comall.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jbnu.comall.R;
import com.jbnu.comall.model.Product;
import com.jbnu.comall.model.Review;

import java.text.DecimalFormat;
import java.util.List;

public class ReviewListAdapter extends RecyclerView.Adapter<ReviewListAdapter.ViewHolder> {

    private OnItemClickListener listener;
    private List<Review> mData;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameView;
        TextView fromView;
        TextView reviewView;
        TextView dateView;
        TextView ratingView;

        ViewHolder(View itemView) {
            super(itemView);
            nameView = itemView.findViewById(R.id.review_name);
            fromView = itemView.findViewById(R.id.review_from);
            reviewView = itemView.findViewById(R.id.review_text);
            dateView = itemView.findViewById(R.id.review_date);
            ratingView = itemView.findViewById(R.id.review_rating);

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

    public ReviewListAdapter(List<Review> list, OnItemClickListener listener) {
        this.listener = listener;
        this.mData = list;
    }

    @Override
    public ReviewListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_review, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ReviewListAdapter.ViewHolder holder, int position) {
        System.out.println(mData.get(position));
        Review review = mData.get(position);
        holder.nameView.setText(review.getName());
        holder.fromView.setText("from " + review.getFrom());
        holder.ratingView.setText("평점 : " + review.getRating());
        holder.reviewView.setText(review.getReview());

        String date = String.valueOf(review.getDate());
        String year = date.substring(0, 4);
        String month = date.substring(4, 6);
        String day = date.substring(6, 8);
        holder.dateView.setText("작성일 : " + year + "/" + month + "/" + day);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
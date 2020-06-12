package com.jbnu.comall.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jbnu.comall.R;
import com.jbnu.comall.model.Product;

import java.text.DecimalFormat;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {

    private OnItemClickListener listener;
    private List<Product> mData;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameView;
        TextView priceView;
        TextView propertiesView;
        ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);
            nameView = itemView.findViewById(R.id.product_name);
            priceView = itemView.findViewById(R.id.product_price);
            propertiesView = itemView.findViewById(R.id.product_properties);
            imageView = itemView.findViewById(R.id.product_thumbnail);

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

    public ProductListAdapter(List<Product> list, OnItemClickListener listener) {
        this.listener = listener;
        this.mData = list;
    }

    @Override
    public ProductListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductListAdapter.ViewHolder holder, int position) {
        Product product = mData.get(position);

        Glide.with(holder.imageView.getContext())
                .load(product.getThumbnail())
                .into(holder.imageView);

        holder.nameView.setText(product.getName());
        holder.priceView.setText("최저가 : " + new DecimalFormat("###,###").format(product.getPrice()) + "원");
        holder.propertiesView.setText(String.join("/", product.getProperties()));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
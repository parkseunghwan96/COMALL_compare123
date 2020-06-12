package com.jbnu.comall.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jbnu.comall.R;
import com.jbnu.comall.adapter.ProductListAdapter;
import com.jbnu.comall.adapter.ReviewListAdapter;
import com.jbnu.comall.base.BaseFragment;
import com.jbnu.comall.model.Product;
import com.jbnu.comall.model.Review;

import java.text.DecimalFormat;
import java.util.List;

/**
 * @author : Hyunwoong
 * @when : 5/10/2020 4:21 PM
 * @homepage : https://github.com/gusdnd852
 */
public class ProductViewFragment extends BaseFragment {

    private Product product;

    public ProductViewFragment(Product product) {
        this.product = product;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_product_view, container, false);
        TextView productName = rootView.findViewById(R.id.product_name);
        TextView productProperties = rootView.findViewById(R.id.product_properties);
        TextView productPrice = rootView.findViewById(R.id.product_price);
        TextView ratingView = rootView.findViewById(R.id.product_rating);
        ImageView productImage = rootView.findViewById(R.id.product_thumbnail);

        Glide.with(getActivity())
                .load(product.getThumbnail())
                .into(productImage);

        productName.setText(product.getName());
        productProperties.setText(String.join("/", product.getProperties()));
        productPrice.setText("최저가 : " + new DecimalFormat("###,###").format(product.getPrice()) + "원");

        RecyclerView recyclerView = rootView.findViewById(R.id.review_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ReviewListAdapter adapter = new ReviewListAdapter(this.product.getReviews(), (v, pos) -> {
        });

        List<Review> reviews = product.getReviews();
        float totalRating = 0;
        for (Review review : reviews){
            totalRating += review.getRating();
        }
        totalRating /= reviews.size();
        ratingView.setText(String.valueOf(totalRating));

        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), 1));
        recyclerView.setAdapter(adapter);
        return rootView;
    }
}

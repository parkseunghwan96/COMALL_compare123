package com.jbnu.comall.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jbnu.comall.R;
import com.jbnu.comall.adapter.ProductListAdapter;
import com.jbnu.comall.base.BaseFragment;
import com.jbnu.comall.model.Product;

import java.util.List;

/**
 * @author : Hyunwoong
 * @when : 5/10/2020 4:21 PM
 * @homepage : https://github.com/gusdnd852
 */
public class ProductListFragment extends BaseFragment {

    private List<Product> products;

    public ProductListFragment(List<Product> productList) {
        this.products = productList;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_product_list, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.product_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ProductListAdapter adapter = new ProductListAdapter(this.products, (v, pos) -> {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            ProductViewFragment productViewFragment = new ProductViewFragment(products.get(pos));
            replaceWithStack(transaction, R.id.fragment_container, productViewFragment);
        });

        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), 1));
        recyclerView.setAdapter(adapter);
        return rootView;
    }
}

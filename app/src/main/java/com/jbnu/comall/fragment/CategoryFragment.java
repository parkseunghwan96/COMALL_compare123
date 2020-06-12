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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jbnu.comall.R;
import com.jbnu.comall.adapter.TextListAdapter;
import com.jbnu.comall.base.BaseFragment;
import com.jbnu.comall.model.Categories;
import com.jbnu.comall.model.Product;
import com.jbnu.comall.model.Review;
import com.jbnu.comall.util.DBHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CategoryFragment extends BaseFragment {

    private List<String> categories = Arrays.asList("CPU", "메인보드", "메모리", "HDD");

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_category, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.category_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        TextListAdapter adapter = new TextListAdapter(categories, (v, pos) -> {
            String itemName = categories.get(pos);
            String category = Categories.toEnum(itemName).toString();
            DBHelper.getInstance().getProduct(category, productList -> {
                        ProductListFragment listFragment = new ProductListFragment(productList);
                        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                        replaceWithStack(transaction, R.id.fragment_container, listFragment);
                    });
        });

        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), 1));
        recyclerView.setAdapter(adapter);
        return rootView;
    }
}

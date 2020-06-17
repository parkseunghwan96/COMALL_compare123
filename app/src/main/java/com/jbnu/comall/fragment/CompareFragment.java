package com.jbnu.comall.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jbnu.comall.R;
import com.jbnu.comall.adapter.TextList1Adapter;
import com.jbnu.comall.adapter.TextListAdapter;
import com.jbnu.comall.base.BaseFragment;
import com.jbnu.comall.model.Categories;
import com.jbnu.comall.model.Categories1;
import com.jbnu.comall.util.DBHelper;

import java.util.Arrays;
import java.util.List;

public class CompareFragment extends BaseFragment {

    private List<String> categories = Arrays.asList("CPU", "VGA");

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_compare, container, false);

        TabHost tabHost1 = (TabHost) rootView.findViewById(R.id.tabHost1) ;
        tabHost1.setup() ;

        TabHost.TabSpec ts1 = tabHost1.newTabSpec("Tab Spec 1") ;
        ts1.setContent(R.id.content1) ;
        ts1.setIndicator("제품 성능") ;
        tabHost1.addTab(ts1)  ;

        TabHost.TabSpec ts2 = tabHost1.newTabSpec("Tab Spec 2") ;
        ts2.setContent(R.id.content2) ;
        ts2.setIndicator("성능 비교") ;
        tabHost1.addTab(ts2) ;

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

        RecyclerView recyclerView1 = rootView.findViewById(R.id.category_list1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getActivity()));

        TextList1Adapter adapter1 = new TextList1Adapter(categories, (v, pos) -> {
            String itemName = categories.get(pos);
            String category = Categories1.toEnum(itemName).toString();
            DBHelper.getInstance().getProduct(category, productList -> {
                ProductListFragment listFragment = new ProductListFragment(productList);
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                replaceWithStack(transaction, R.id.fragment_container, listFragment);
            });
        });

        recyclerView1.addItemDecoration(new DividerItemDecoration(getContext(), 1));

        recyclerView1.setAdapter(adapter1);
        return rootView;
    }
}



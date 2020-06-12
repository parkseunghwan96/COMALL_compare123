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
import com.jbnu.comall.adapter.TrendListAdapter;
import com.jbnu.comall.base.BaseFragment;
import com.jbnu.comall.model.TrendList;

import java.util.List;

public class TrendListFragment extends BaseFragment {

    private List<TrendList> trendLists;

    public TrendListFragment(List<TrendList> trendList) {
        this.trendLists = trendList;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_trend_list, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.trend_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        TrendListAdapter adapter = new TrendListAdapter(this.trendLists, (v, pos) -> {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            TrendViewFragment trendViewFragment = new TrendViewFragment(trendLists.get(pos));
            replaceWithStack(transaction, R.id.fragment_container, trendViewFragment);
        });

        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), 1));
        recyclerView.setAdapter(adapter);
        return rootView;
    }
}


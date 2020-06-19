package com.jbnu.comall.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jbnu.comall.R;
import com.jbnu.comall.adapter.CompareRankingAdapter;
import com.jbnu.comall.base.BaseFragment;
import com.jbnu.comall.model.ComparePart;

public class CompareRankingFragment extends BaseFragment {

    private ComparePart comparePart;

    public CompareRankingFragment(ComparePart comparePart) {
        this.comparePart = comparePart;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_compare_ranking, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.compare_rankinglist);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        CompareRankingAdapter adapter = new CompareRankingAdapter(this.comparePart.getCompareRankings(), (v, pos) -> {
        });

        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), 1));
        recyclerView.setAdapter(adapter);
        return rootView;
    }
}


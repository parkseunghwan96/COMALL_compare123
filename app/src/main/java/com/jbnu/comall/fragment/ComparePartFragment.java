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
import com.jbnu.comall.adapter.ComparePartAdapter;
import com.jbnu.comall.base.BaseFragment;
import com.jbnu.comall.model.ComparePart;

import java.util.List;

public class ComparePartFragment extends BaseFragment {

    private List<ComparePart> compareParts;

    public ComparePartFragment(List<ComparePart> compareParts) { this.compareParts = compareParts; }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_compare_part, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.compare_part);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ComparePartAdapter adapter = new ComparePartAdapter(this.compareParts, (v, pos) -> {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            CompareRankingFragment compareRankingFragment = new CompareRankingFragment(compareParts.get(pos));
            replaceWithStack(transaction, R.id.fragment_container, compareRankingFragment);
        });

        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), 1));
        recyclerView.setAdapter(adapter);
        return rootView;
    }
}


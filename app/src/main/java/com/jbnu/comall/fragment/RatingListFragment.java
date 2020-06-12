package com.jbnu.comall.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jbnu.comall.R;
import com.jbnu.comall.adapter.RatingListAdapter;
import com.jbnu.comall.base.BaseFragment;
import com.jbnu.comall.model.Rating;

import java.util.List;

public class RatingListFragment extends BaseFragment {
    private List<Rating> ratings;

    public RatingListFragment(List<Rating> ratingList) {
        this.ratings = ratingList;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_rating_list, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.rating_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RatingListAdapter adapter = new RatingListAdapter(this.ratings, (v, pos) -> {
        });

        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), 1));
        recyclerView.setAdapter(adapter);
        return rootView;
    }
}

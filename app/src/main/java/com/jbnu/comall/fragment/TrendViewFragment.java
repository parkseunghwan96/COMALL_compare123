package com.jbnu.comall.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jbnu.comall.R;
import com.jbnu.comall.adapter.TrendViewAdapter;
import com.jbnu.comall.base.BaseFragment;
import com.jbnu.comall.model.TrendList;

public class TrendViewFragment extends BaseFragment {

    private TrendList trendList;

    public TrendViewFragment(TrendList trendList) {
        this.trendList = trendList;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_trend_view, container, false);
        TextView trendtext = rootView.findViewById(R.id.trend_text);



        trendtext.setText(trendList.getTrendtext());
        RecyclerView recyclerView = rootView.findViewById(R.id.trend_view_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        TrendViewAdapter adapter = new TrendViewAdapter(this.trendList.getTrendViews(), (v, pos) -> {
        });




        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), 1));
        recyclerView.setAdapter(adapter);
        return rootView;
    }


}

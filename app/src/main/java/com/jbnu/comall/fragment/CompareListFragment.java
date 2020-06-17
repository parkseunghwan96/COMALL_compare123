package com.jbnu.comall.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jbnu.comall.R;
import com.jbnu.comall.adapter.CompareListAdapter;
import com.jbnu.comall.model.Compare;

import java.util.List;

public class CompareListFragment extends Fragment {

    private Spinner spinner;
    private Spinner spinner1;
    private List<Compare> compares;


    public CompareListFragment(List<Compare> compareList) {
        this.compares = compareList;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_compare_list, container, false);

        spinner = rootView.findViewById(R.id.spinner);
        spinner1 = rootView.findViewById(R.id.spinner1);

        RecyclerView recyclerView = rootView.findViewById(R.id.compare_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        CompareListAdapter adapter = new CompareListAdapter(this.compares, (v, pos) -> {
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), 1));
        recyclerView.setAdapter(adapter);
        return rootView;
    }
}

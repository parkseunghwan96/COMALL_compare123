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
import com.jbnu.comall.adapter.ExamineListAdapter;
import com.jbnu.comall.base.BaseFragment;
import com.jbnu.comall.model.Examine;

import java.util.List;

    public class ExamineListFragment extends BaseFragment {

        private List<Examine> examines;

        public ExamineListFragment(List<Examine> examineList) {
            this.examines = examineList;
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_examine_list, container, false);
            RecyclerView recyclerView = rootView.findViewById(R.id.examine_list);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            ExamineListAdapter adapter = new ExamineListAdapter(this.examines, (v, pos) -> {
            });

            recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), 1));
            recyclerView.setAdapter(adapter);
            return rootView;
        }
    }
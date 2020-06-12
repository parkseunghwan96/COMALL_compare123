package com.jbnu.comall.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.database.FirebaseDatabase;
import com.jbnu.comall.R;
import com.jbnu.comall.base.BaseFragment;
import com.jbnu.comall.model.Categories;
import com.jbnu.comall.util.DBHelper;

public class SearchFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_search, container, false);
        EditText searchBar = rootView.findViewById(R.id.search_bar);
        TextView searchButton = rootView.findViewById(R.id.search_button);

        searchButton.setOnClickListener(v->{
            String keyward = searchBar.getText().toString();
            if (keyward == null || keyward.replaceAll(" ", "").equals("")){
                Toast.makeText(getContext(), "검색어를 입력해주세요.", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }
}

package com.jbnu.comall.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;

import com.jbnu.comall.R;
import com.jbnu.comall.base.BaseActivity;
import com.jbnu.comall.fragment.ExamineFragment;
import com.jbnu.comall.fragment.TrendFragment;
import com.jbnu.comall.fragment.CategoryFragment;
import com.jbnu.comall.fragment.RatingFragment;
import com.jbnu.comall.fragment.CompareFragment;
import com.roughike.bottombar.BottomBar;

public class MainActivity extends BaseActivity {

    private BottomBar bottomBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomBar = findViewById(R.id.bottom_bar);
        bottomBar.setOnTabSelectListener(id -> {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            if (id == R.id.tab_category)
                replace(transaction, R.id.fragment_container, new CategoryFragment());

            else if (id == R.id.tab_compare)
                replace(transaction, R.id.fragment_container, new CompareFragment());

            else if (id == R.id.tab_rating)
                replace(transaction, R.id.fragment_container, new RatingFragment());

            else if (id == R.id.tab_examine)
                replace(transaction, R.id.fragment_container, new ExamineFragment());

            else if (id == R.id.tab_cart)
                replace(transaction, R.id.fragment_container, new TrendFragment());
        });

    }

}

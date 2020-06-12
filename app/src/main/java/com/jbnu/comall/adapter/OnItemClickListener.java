package com.jbnu.comall.adapter;

import android.view.View;

@FunctionalInterface
public interface OnItemClickListener {
    void onItemClick(View v, int pos) throws Exception;
}

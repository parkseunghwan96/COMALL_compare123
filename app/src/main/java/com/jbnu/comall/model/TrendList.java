package com.jbnu.comall.model;

import java.util.List;

public class TrendList {

    private String trendtext;
    private List<TrendView> trendViews;



    public String getTrendtext() {
        return trendtext;
    }

    public void setTrendtext(String trendtext) {
        this.trendtext = trendtext;
    }


    public List<TrendView> getTrendViews() {
        return trendViews;
    }

    public void setTrendViews(List<TrendView> trendViews) {
        this.trendViews = trendViews;
    }



}

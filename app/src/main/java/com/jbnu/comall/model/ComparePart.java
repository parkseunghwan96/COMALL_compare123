package com.jbnu.comall.model;

import java.util.List;

public class ComparePart {

    private String comparetext;

    public String getComparetext() {
        return comparetext;
    }

    public void setComparetext(String comparetext) {
        this.comparetext = comparetext;
    }

    public List<CompareRanking> getCompareRankings() {
        return compareRankings;
    }

    public void setCompareRankings(List<CompareRanking> compareRankings) {
        this.compareRankings = compareRankings;
    }

    private List<CompareRanking> compareRankings;
}

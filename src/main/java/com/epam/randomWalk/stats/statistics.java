package com.epam.randomWalk.stats;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class statistics {
    long totalAmount;
    long totalIncorrectAmount;
    long maxValue;
    long minValue;
    long mostPopularResult;

    public statistics() {}

    public long getTotalAmount() {
        return totalAmount;
    }

    public void increaseTotalAmount() {
        this.totalAmount++;
    }

    public long getTotalIncorrectAmount() {
        return totalIncorrectAmount;
    }

    public void increaseTotalIncorrectAmount() {
        this.totalIncorrectAmount++;
    }

    public long getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(long maxValue) {
        this.maxValue = maxValue;
    }

    public long getMinValue() {
        return minValue;
    }

    public void setMinValue(long minValue) {
        this.minValue = minValue;
    }

    public long getMostPopularResult() {
        return mostPopularResult;
    }

    public void setMostPopularResult(long mostPopularResult) {
        this.mostPopularResult = mostPopularResult;
    }

    public void findPopular(ArrayList<Long> results) {
        Collections.sort(results);

        long previous = results.get(0);
        long popular = results.get(0);
        int count = 1;
        int maxCount = 1;

        for (int i = 1; i < results.size(); i++) {
            if (results.get(i) == previous)
                count++;
            else {
                if (count > maxCount) {
                    popular = results.get(i-1);
                    maxCount = count;
                }
                previous = results.get(i);
                count = 1;
            }
        }

        this.mostPopularResult = count > maxCount ? results.get(results.size()-1) : popular;
    }
}

package com.epam.randomWalk.response;

import com.epam.randomWalk.stats.statistics;

import java.util.ArrayList;

public class response {
    ArrayList<Long> results = new ArrayList<>();
    long previousResult;
    long requestsCount;
    statistics stats = new statistics();

    public response() {}

    public ArrayList<Long> getResults() {
        return results;
    }

     public Long getLastResult() {
        return results.get(results.size() - 1);
    }

    public void setResult(Long result) {
        results.add(result);
    }

    public long getPreviousResult() {
        return previousResult;
    }

    public void setPreviousResult(long previousResult) {
        this.previousResult = previousResult;
    }

    public long getRequests() {
        return requestsCount;
    }

    public void setRequests(long requests) {
        this.requestsCount = requests;
    }
        public statistics getStats() {
        return stats;
    }

    public void setStats(statistics stats) {
        this.stats = stats;
    }
}

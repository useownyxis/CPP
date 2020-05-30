package com.epam.randomWalk.response;

public class response {
    long result;
    long previousResult;
    long requests;

    public response() {}

    public long getResult() {
        return result;
    }

    public void setResult(long result) {
        this.result = result;
    }

    public long getPreviousResult() {
        return previousResult;
    }

    public void setPreviousResult(long previousResult) {
        this.previousResult = previousResult;
    }

    public long getRequests() {
        return requests;
    }

    public void setRequests(long requests) {
        this.requests = requests;
    }
}

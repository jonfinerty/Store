package com.jonathanfinerty.store;

public class Writer {

    public Writer() {
    }

    public Writer withProgressListener(ProgressListener listener) {
        return this;
    }

    public Writer withCanceller(Canceller canceller) {
        return this;
    }

    public Writer async() {
        return this;
    }

    public Writer withEvictionRules(@Store.EvictionPriority int evictionRules) {
        return this;
    }

    public Key write() {
        return null;
    }
}

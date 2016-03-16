package com.jonathanfinerty.store;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

public class Store {

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({NEVER_EVICT, DEFAULT})
    public @interface EvictionPriority {
    }

    public static final int NEVER_EVICT = 0;
    public static final int DEFAULT = 1;

    public Location location(Key key) {
        return new Location();
    }

    public <T> Location location(T type) {
        return new Location();
    }

    public void deleteAll() {

    }

    public List<Location> getAll() {
        return new ArrayList<>();
    }

    /*
    // asyncWrite

    // asyncRead w/ callback

    // memory cache

    // changing max size

    // keys need to be easily persisted? with db/sharedpreferences

    changePriority(Priority priority, Key key) {

    }

    changePriority(Priority priority, T t) {

    }

    // move

    // getAll -> key | priority pair?

    // exists

    // touch, update used so not chucked out of cache

    // register all keys in builder?

    // delete(key)

    // deleteOldestItem()

    // delete(condition) //older than X? // less than X priority?

    */
    public static class Builder {

        @Retention(RetentionPolicy.SOURCE)
        @IntDef({BYTES, KB, MB, GB})
        public @interface Unit {
        }

        public static final int BYTES = 0;
        public static final int KB = 1;
        public static final int MB = 2;
        public static final int GB = 3;

        public Builder location() {
            // cache folder, in-app, sd-card, custom?
            return this;
        }

        public Builder name(String name) {
            // name of parent folder
            return this;
        }

        public Builder maxSize(float quantity, @Unit int unit) {
            // maximum size of disk store
            return this;
        }

        public Builder withKeyGenerator(KeyGenerator keyGenerator) {
            // provides function from domain object -> location
            // and priority?
            return this;
        }

        // set default eviction? always keep? basically toggle between cache and store?


        // max size of individual thing

        public Store build() {
            return new Store();
        }
    }

}

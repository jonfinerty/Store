package com.jonathanfinerty.store;

import android.content.Context;
import android.os.Environment;
import android.support.annotation.IntDef;

import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

public class Store {

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({INTERNAL, EXTERNAL})
    public @interface StorageArea {
    }

    public static final int INTERNAL = 0;
    public static final int EXTERNAL = 1;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({BYTES, KB, MB, GB})
    public @interface Unit {
    }

    public static final int BYTES = 0;
    public static final int KB = 1;
    public static final int MB = 2;
    public static final int GB = 3;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({NEVER_EVICT, DEFAULT})
    public @interface EvictionPriority {
    }

    public static final int NEVER_EVICT = 0;
    public static final int DEFAULT = 1;

    private final File rootDir;

    Store(Context context, @StorageArea int storageLocation, String folderName) {
        File storageDirectory;
        if (storageLocation == INTERNAL) {
            storageDirectory = context.getFilesDir();
        } else {
            storageDirectory = Environment.getExternalStorageDirectory();
        }

        rootDir = FileUtils.getOrMakeDir(storageDirectory, folderName);
    }

    public Location location(Key key) {
        return new Location(this, key);
    }

    public <T> Location location(T type) {
        Key key = getKeyForObject(type);
        return new Location(this, key);
    }

    public Location location(String key) {
        return new Location(this, new StringKey(key));
    }

    public void deleteAll() {

    }

    public List<Location> getAll() {
        return new ArrayList<>();
    }

    private <T> Key getKeyForObject(T type) {
        return null;
    }

    File getRootDir() {
        return rootDir;
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

        private Context context;
        private String folderName = "store-folder";
        private int storageArea = INTERNAL;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder location(@StorageArea int storageArea) {
            this.storageArea = storageArea;
            return this;
        }

        public Builder inFolder(String folderName) {
            this.folderName = folderName;
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
            return new Store(context, storageArea, folderName);
        }
    }

}

package com.jonathanfinerty.store;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Location {

    private final Store store;
    private final Key key;

    Location(Store store, Key key) {
        this.store = store;
        this.key = key;
    }

    public Writer prepareWrite(InputStream content) {
        return new Writer(this, content);
    }

    public Key write(InputStream content) {
        return prepareWrite(content).write();
    }

    public InputStream read() {
        try {
            return new FileInputStream(getFile());
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    public void delete() {

    }

    public boolean exists() {
        return false;
    }

    public File getFile() {
        File rootDir = store.getRootDir();
        return new File(rootDir, key.getUniqueId());
    }

    public Key getKey() {
        return key;
    }
}

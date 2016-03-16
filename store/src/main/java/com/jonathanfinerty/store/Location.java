package com.jonathanfinerty.store;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

public class Location {
    public Writer prepareWrite(InputStream content) {
        return new Writer();
    }

    public Key write(InputStream content) {
        return new Writer().write();
    }

    public <T> InputStream read() {
        return new ByteArrayInputStream(new byte[0]);
    }

    public void delete() {

    }

    public boolean exists() {
        return false;
    }

    public File getFile() {
        return new File("");
    }

    public Key getKey() {
        return null;
    }
}

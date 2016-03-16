package com.jonathanfinerty.store;

import java.lang.Override;
import java.lang.String;

public class StringKey extends Key {

    private String id;

    public StringKey(String id) {
        this.id = id;
    }

    @Override
    public String getUniqueId() {
        return id;
    }
}

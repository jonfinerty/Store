package com.jonathanfinerty.store;

import java.lang.String;

public interface KeyGenerator<T> {

    String map(T item);

}

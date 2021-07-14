package com.zym.common;

import java.io.Serializable;

@FunctionalInterface
public interface Fn<T, R> extends Serializable {
    R apply(T source);

    public static <T, R> String getName(Fn<T, R> fn) {
        return Reflections.fnToFieldName(fn);
    }
}

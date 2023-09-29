package com.djachtoma.utils;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;


public class ObjectUtils {

    public static <T> void nullSafeUpdate(T t, Supplier<T> input, Consumer<T> set) {
        if (Objects.nonNull(input.get())) {
            set.accept(t);
        }
    }
}

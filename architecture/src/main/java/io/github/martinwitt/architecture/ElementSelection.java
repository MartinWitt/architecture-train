package io.github.martinwitt.architecture;

import spoon.reflect.CtModel;

@FunctionalInterface
public interface ElementSelection<T> {

    Iterable<T> select(CtModel model);
}

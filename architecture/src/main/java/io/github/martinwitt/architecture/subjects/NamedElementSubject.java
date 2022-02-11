package io.github.martinwitt.architecture.subjects;

import spoon.reflect.declaration.CtNamedElement;

public interface NamedElementSubject<T extends CtNamedElement> extends ISubject<T> {

    // public default void hasName(String name) {
    //   is(e -> e.getSimpleName().equals(name));
    // }

    public default void nameMatchesPattern(String regex) {
        is(e -> e.getSimpleName().matches(regex), getElement().getSimpleName(), regex);
    }
}

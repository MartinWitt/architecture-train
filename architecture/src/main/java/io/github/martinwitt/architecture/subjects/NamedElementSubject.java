package io.github.martinwitt.architecture.subjects;

import spoon.reflect.declaration.CtNamedElement;

public interface NamedElementSubject<T extends CtNamedElement> extends ISubject<T> {

    // public default void hasName(String name) {
    //   is(e -> e.getSimpleName().equals(name));
    // }

    /**
     * Checks that simple name of this element matches the given regex.
     * @param regex  regular expression
     */
    public default void nameMatchesPattern(String regex) {
        is(e -> e.getSimpleName().matches(regex), getElement().getSimpleName(), regex);
    }
}

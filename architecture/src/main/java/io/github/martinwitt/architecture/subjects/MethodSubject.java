package io.github.martinwitt.architecture.subjects;

import spoon.reflect.declaration.CtMethod;

public class MethodSubject extends AbstractSubject<CtMethod<?>> {

    public MethodSubject(CtMethod<?> element) {
        super(element);
    }

    public void hasName(String name) {
        is(e -> e.getSimpleName().equals(name));
    }

    public void nameMatchesPattern(String regex) {
        is(e -> e.getSimpleName().matches(regex), element.getSimpleName(), regex);
    }
}

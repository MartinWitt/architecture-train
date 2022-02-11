package io.github.martinwitt.architecture.subjects;

import spoon.reflect.declaration.CtMethod;

public class MethodSubject extends AbstractSubject<CtMethod<?>> implements NamedElementSubject<CtMethod<?>> {

    public MethodSubject(CtMethod<?> element) {
        super(element);
    }
}

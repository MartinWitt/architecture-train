package io.github.martinwitt.architecture.subjects;

import spoon.reflect.CtModel;
import spoon.reflect.declaration.CtMethod;

public class MethodSubject extends AbstractSubject<CtMethod<?>>
        implements NamedElementSubject<CtMethod<?>>, ModifierSubject<CtMethod<?>> {

    public MethodSubject(CtModel model, CtMethod<?> element) {
        super(model, element);
    }

    @Override
    public MethodSubject not() {
        negate = !negate;
        return this;
    }
}

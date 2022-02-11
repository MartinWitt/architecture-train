package io.github.martinwitt.architecture.subjects;

import spoon.reflect.CtModel;
import spoon.reflect.declaration.CtField;

public class FieldSubject extends AbstractSubject<CtField<?>>
        implements NamedElementSubject<CtField<?>>, ModifierSubject<CtField<?>> {

    public FieldSubject(CtModel model, CtField<?> element) {
        super(model, element);
    }

    @Override
    public FieldSubject not() {
        negate = !negate;
        return this;
    }
}

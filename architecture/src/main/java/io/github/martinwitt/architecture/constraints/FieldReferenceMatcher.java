package io.github.martinwitt.architecture.constraints;

import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import spoon.reflect.CtModel;
import spoon.reflect.declaration.CtField;
import spoon.reflect.reference.CtFieldReference;
import spoon.reflect.visitor.filter.TypeFilter;

public class FieldReferenceMatcher implements Predicate<CtField<?>> {

    private Set<CtField<?>> lookUp;

    public FieldReferenceMatcher(CtModel model) {
        model.getElements(new TypeFilter<>(CtFieldReference.class)).stream()
                .map(v -> v.getDeclaration())
                .filter(Objects::nonNull)
                .map(lookUp::add);
    }

    @Override
    public boolean test(CtField<?> t) {
        return lookUp.contains(t);
    }
}
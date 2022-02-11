package io.github.martinwitt.architecture.subjects;

import spoon.reflect.declaration.CtTypedElement;

public interface TypeSubject<T extends CtTypedElement<?>> extends ISubject<T> {

    /**
     * Checks that type of this element matches the given type. Converts the given type to a string using {@link Class#getCanonicalName()}.
     * A fully qualified name is {@code package.Type} and a simple name is {@code Type}.
     * @param type  type
     */
    public default void isType(Class<?> type) {
        if (getElement().getType() == null) {
            return;
        }
        is(
                e -> e.getType().getQualifiedName().equals(type.getCanonicalName()),
                getElement().getType().getQualifiedName(),
                type.getCanonicalName());
    }

    /**
     * Checks that type of this element matches the given type. A fully qualified name is {@code package.Type} and a simple name is {@code Type}.
     * @param type  type
     */
    public default void isType(String fqName) {
        if (getElement().getType() == null) {
            return;
        }
        is(
                e -> e.getType().getQualifiedName().equals(fqName),
                getElement().getType().getQualifiedName(),
                fqName);
    }

    /**
     * Checks that type of this element matches the given type using simple name.
     * A fully qualified name is {@code package.Type} and a simple name is {@code Type}.
     * @param type  type
     */
    public default void isTypeSimpleQualified(String simpleName) {
        if (getElement().getType() == null) {
            return;
        }
        is(
                e -> e.getType().getSimpleName().equals(simpleName),
                getElement().getType().getQualifiedName(),
                simpleName);
    }
}

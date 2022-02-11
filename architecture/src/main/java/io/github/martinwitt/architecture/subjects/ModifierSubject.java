package io.github.martinwitt.architecture.subjects;

import spoon.reflect.declaration.CtModifiable;
import spoon.reflect.declaration.ModifierKind;

public interface ModifierSubject<T extends CtModifiable> extends ISubject<T> {

    /**
     * Checks that this element has public visiblity.
     */
    public default void isPublic() {
        is(e -> e.getVisibility() == ModifierKind.PUBLIC, getVisibility(getElement()), "public");
    }

    /**
     * Checks that this element has protected visiblity.
     *
     */
    public default void isProtected() {
        is(e -> e.getVisibility() == ModifierKind.PUBLIC, getVisibility(getElement()), "protected");
    }

    /**
     * Checks that this element has default visiblity.
     */
    public default void isDefaultVisible() {
        is(e -> e.getVisibility() == null, getVisibility(getElement()), "default");
    }

    /**
     * Checks that this element has private visiblity.
     */
    public default void isPrivate() {
        is(e -> e.getVisibility() == ModifierKind.PRIVATE, getVisibility(getElement()), "private");
    }

    /**
     * Checks that this element has final modifier.
     */
    public default void isFinal() {
        is(CtModifiable::isFinal, getElement().getModifiers().toString(), "final");
    }
    /**
     * Checks that this element has abstract modifier.
     */
    public default void isAbstract() {
        is(CtModifiable::isAbstract, getElement().getModifiers().toString(), "abstract");
    }

    /**
     * Checks that this element has static modifier.
     */
    public default void isStatic() {
        is(CtModifiable::isStatic, getElement().getModifiers().toString(), "static");
    }

    /**
     * Checks that this element has synchronized modifier.
     */
    public default void isSynchronized() {
        is(CtModifiable::isSynchronized, getElement().getModifiers().toString(), "synchronized");
    }

    /**
     * Checks that this element has native modifier.
     */
    public default void isNative() {
        is(CtModifiable::isNative, getElement().getModifiers().toString(), "native");
    }

    /**
     * Checks that this element has transient modifier.
     */
    public default void isTransient() {
        is(CtModifiable::isTransient, getElement().getModifiers().toString(), "transient");
    }

    /**
     * Checks that this element has volatile modifier.
     */
    public default void isVolatile() {
        is(CtModifiable::isVolatile, getElement().getModifiers().toString(), "volatile");
    }

    /**
     * Checks that this element has strictFP modifier.
     */
    public default void isStrictfp() {
        is(CtModifiable::isStrictfp, getElement().getModifiers().toString(), "strictFP");
    }

    private String getVisibility(CtModifiable modifiable) {
        return modifiable.getVisibility() == null
                ? "default"
                : modifiable.getVisibility().toString();
    }
}

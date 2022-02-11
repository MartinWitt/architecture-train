package io.github.martinwitt.architecture.subjects;

import java.util.function.Predicate;
import spoon.reflect.declaration.CtElement;

public interface ISubject<T extends CtElement> {

    T getElement();

    void is(Predicate<T> condition, String exptectedValue, String actualValue);
}

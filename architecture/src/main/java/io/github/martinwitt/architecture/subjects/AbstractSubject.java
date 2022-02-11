package io.github.martinwitt.architecture.subjects;

import io.github.martinwitt.architecture.Failure;
import java.util.function.Predicate;
import spoon.reflect.declaration.CtElement;

public abstract class AbstractSubject<T extends CtElement> implements ISubject<T> {

    protected T element;

    protected AbstractSubject(T element) {
        this.element = element;
    }

    void is(Predicate<T> condition) {
        condition.test(element);
    }

    void is(Predicate<T> condition, String checkMethod, String exptectedValue, String actualValue) {
        if (condition.negate().test(element)) {
            new Failure("", checkMethod, exptectedValue, actualValue);
        }
    }

    public void is(Predicate<T> condition, String exptectedValue, String actualValue) {
        if (condition.negate().test(element)) {
            StackWalker walker = StackWalker.getInstance();
            String checkMethod = walker.walk(frames -> frames.map(StackWalker.StackFrame::getMethodName)
                            .skip(1)
                            .findFirst())
                    .orElse("");
            new Failure(element.getClass().getSimpleName(), checkMethod, exptectedValue, actualValue);
        }
    }

    protected void failWithMessage(String message) {
        throw new AssertionError(message);
    }

    @Override
    public T getElement() {
        return element;
    }
}

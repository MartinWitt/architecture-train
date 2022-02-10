package io.github.martinwitt.architecture;

public interface IConstraint<T> {
    void checkConstraint(T model);
}

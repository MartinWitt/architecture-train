package io.github.martinwitt.architecture.errorhandling;

public interface IError<T> {

    void printError(T element);
}

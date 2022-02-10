package io.github.martinwitt.architecture.errorhandling;

public class NopError<T> implements IError<T> {

    @Override
    public void printError(T element) {}
}

package io.github.martinwitt.architecture;

public class FailureCollector extends AbstractFailureCollector {

    @Override
    protected void logFailure(Failure failure) {
        System.err.println(failure);
    }

    @Override
    protected void afterAllFailures() {
        throw new ArchitectureFailure(failures.size() + " failure(s) found");
    }

    @Override
    protected void logSuccess() {
        System.out.println("No failures found");
    }
}

package io.github.martinwitt.architecture;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public abstract class AbstractFailureCollector implements BeforeEachCallback, AfterEachCallback {

    protected List<Failure> failures;

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        if (!failures.isEmpty()) {
            for (Failure failure : failures) {
                logFailure(failure);
            }
            Architecture.removeExtension(this);
            afterAllFailures();
        }
        logSuccess();
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        failures = new ArrayList<>();
        System.out.println("Registering failure collector");
        Architecture.registerExtension(this);
    }

    public void raiseFailure(Failure failure) {
        failures.add(failure);
    }

    protected abstract void logFailure(Failure failure);

    protected abstract void afterAllFailures();

    protected abstract void logSuccess();
}

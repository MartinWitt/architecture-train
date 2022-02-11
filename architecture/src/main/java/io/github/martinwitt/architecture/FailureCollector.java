package io.github.martinwitt.architecture;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class FailureCollector implements BeforeEachCallback, AfterEachCallback {

    private List<Failure> failures;

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        if (!failures.isEmpty()) {
            for (Failure failure : failures) {
                System.err.println(failure);
            }
            Architecture.removeExtension(this);
            throw new ArchitectureFailure(failures.size() + " failure(s) found");
        }
        System.out.println("No failures");
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
}

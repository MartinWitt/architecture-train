package io.github.martinwitt.architecture;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import org.junit.jupiter.api.extension.ExtensionContext;

public class FailsWithException extends AbstractFailureCollector {

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        failures = new ArrayList<>();
        Architecture.clearExtensions();
        Architecture.registerExtension(this);
    }

    @Override
    protected void logFailure(Failure failure) {}

    @Override
    protected void afterAllFailures() {}

    @Override
    protected void logSuccess() {
        if (failures.isEmpty()) fail("Testcase was marked as failing but was successful");
        else {
            System.out.println("Testcase succesfull");
        }
    }
}

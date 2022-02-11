package io.github.martinwitt.architecture;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.junit.jupiter.api.extension.TestWatcher;

public class FailsWithException implements TestExecutionExceptionHandler, BeforeEachCallback, TestWatcher {

    private Set<ExtensionContext> contexts = new HashSet<>();

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        if (throwable instanceof ArchitectureFailure) {
            contexts.add(context);
            return;
        }
        throw throwable;
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        System.out.println("Clear extensions");
        Architecture.clearExtensions();
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        if (contexts.contains(context)) {
            contexts.remove(context);
        } else {
            fail("Testcase was marked as must failing but was successful");
        }
    }
}

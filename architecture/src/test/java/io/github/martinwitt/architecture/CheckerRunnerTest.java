package io.github.martinwitt.architecture;

import io.github.martinwitt.architecture.runner.CheckerRunner;
import org.junit.jupiter.api.Test;

public class CheckerRunnerTest {

    @Test
    public void allChecksMustRun() {
        CheckerRunner runner = new CheckerRunner();
        runner.runChecks("./src/main/java", "./src/test/java");
    }
}

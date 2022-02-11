package io.github.martinwitt.architecture;

import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import spoon.Launcher;
import spoon.reflect.CtModel;
import spoon.reflect.declaration.CtMethod;

public class TestFile {

    @ArchitectureCheck
    @ExtendWith(FailsWithException.class)
    public void foo() {
        System.out.println("3");
        int a = 3;
        Architecture.assertThat(everyMethod()).nameMatchesPattern("foo");
    }

    private ElementSelection<CtMethod<?>> everyMethod() {
        return new ElementSelection<CtMethod<?>>() {
            @Override
            public Iterable<CtMethod<?>> select(CtModel model) {
                Launcher launcher = new Launcher();
                var method = launcher.getFactory().createMethod();
                method.setSimpleName("bar");
                return List.of(method);
            }
        };
    }
}

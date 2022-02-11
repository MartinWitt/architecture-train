package io.github.martinwitt.architecture;

import org.junit.jupiter.api.extension.ExtendWith;
import spoon.reflect.CtModel;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.visitor.filter.TypeFilter;

public class MethodSubjectTest {

    @ArchitectureCheck(modelPath = "src/test/resources/projects/MethodNaming/Foo.java")
    @ExtendWith(FailsWithException.class)
    public void testModelNamesFailing(CtModel model) {
        System.out.println("Test running");
        // everyMethod().select(model)
        //         .forEach(method -> Architecture.assertThat(method).nameMatchesPattern("foo"));
        everyMethod().select(model).forEach(method -> Architecture.assertThat(model, method)
                .nameMatchesPattern("test1AAA"));
    }

    @ArchitectureCheck(modelPath = "src/test/resources/projects/MethodNaming/Foo.java")
    public void testModelNamesCorrect(CtModel model) {
        System.out.println("Test running");
        // everyMethod().select(model)
        //         .forEach(method -> Architecture.assertThat(method).nameMatchesPattern("foo"));
        everyMethod().select(model).forEach(method -> Architecture.assertThat(model, method)
                .nameMatchesPattern(".*"));
    }

    private ElementSelection<CtMethod<?>> everyMethod() {
        return new ElementSelection<CtMethod<?>>() {
            @Override
            public Iterable<CtMethod<?>> select(CtModel model) {
                return model.getElements(new TypeFilter<>(CtMethod.class));
            }
        };
    }
}

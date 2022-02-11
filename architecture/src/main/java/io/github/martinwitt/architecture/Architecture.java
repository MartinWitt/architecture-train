package io.github.martinwitt.architecture;

import io.github.martinwitt.architecture.subjects.MethodSubject;
import spoon.reflect.CtModel;
import spoon.reflect.declaration.CtMethod;

public class Architecture {

    private Architecture() {}

    public static MethodSubject assertThat(ElementSelection<CtMethod<?>> selection) {
        CtModel model = null;
        return new MethodSubject(selection.select(model).iterator().next());
    }
}

package io.github.martinwitt.architecture;

import io.github.martinwitt.architecture.subjects.MethodSubject;
import java.util.ArrayList;
import java.util.List;
import spoon.reflect.CtModel;
import spoon.reflect.declaration.CtMethod;

public class Architecture {

    private static List<FailureCollector> extensions = new ArrayList<>();

    private Architecture() {}

    public static void registerExtension(FailureCollector extension) {
        extensions.add(extension);
    }

    public static void removeExtension(FailureCollector extension) {
        extensions.add(extension);
    }

    public static void raiseFailure(Failure failure) {
        for (FailureCollector extension : extensions) {
            extension.raiseFailure(failure);
        }
    }

    public static MethodSubject assertThat(ElementSelection<CtMethod<?>> selection) {
        CtModel model = null;
        return new MethodSubject(selection.select(model).iterator().next());
    }

    public static void clearExtensions() {
        extensions.clear();
    }
}

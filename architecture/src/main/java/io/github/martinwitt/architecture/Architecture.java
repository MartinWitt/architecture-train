package io.github.martinwitt.architecture;

import io.github.martinwitt.architecture.subjects.MethodSubject;
import java.util.ArrayList;
import java.util.List;
import spoon.reflect.CtModel;
import spoon.reflect.declaration.CtMethod;

public class Architecture {

    private static List<AbstractFailureCollector> extensions = new ArrayList<>();

    private Architecture() {}

    public static void registerExtension(AbstractFailureCollector extension) {
        extensions.add(extension);
    }

    public static void removeExtension(AbstractFailureCollector extension) {
        extensions.add(extension);
    }

    public static void raiseFailure(Failure failure) {
        for (AbstractFailureCollector extension : extensions) {
            extension.raiseFailure(failure);
        }
    }

    public static MethodSubject assertThat(CtModel model, CtMethod<?> method) {
        return new MethodSubject(model, method);
    }

    public static void clearExtensions() {
        extensions.clear();
    }
}

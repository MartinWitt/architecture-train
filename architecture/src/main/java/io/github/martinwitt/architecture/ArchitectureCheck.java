package io.github.martinwitt.architecture;

import io.github.martinwitt.architecture.ArchitectureCheck.ModelBuilder;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import spoon.Launcher;
import spoon.OutputType;
import spoon.reflect.CtModel;

@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(FailureCollector.class)
@ExtendWith(ModelBuilder.class)
@Target({ElementType.METHOD})
@Test
public @interface ArchitectureCheck {

    String modelPath() default "src/main/java";

    static class ModelBuilder implements ParameterResolver {

        @Override
        public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
                throws ParameterResolutionException {
            return parameterContext.getParameter().getType().equals(CtModel.class);
        }

        @Override
        public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
                throws ParameterResolutionException {
            ArchitectureCheck check = parameterContext.getDeclaringExecutable().getAnnotation(ArchitectureCheck.class);
            Launcher launcher = new Launcher();
            launcher.addInputResource(check.modelPath());
            launcher.getEnvironment().setComplianceLevel(11);
            launcher.getEnvironment().setOutputType(OutputType.NO_OUTPUT);
            return launcher.buildModel();
        }
    }
}

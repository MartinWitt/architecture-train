package io.github.martinwitt.architecture;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.extension.ExtendWith;
import spoon.reflect.CtModel;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtModifiable;
import spoon.reflect.declaration.ModifierKind;
import spoon.reflect.visitor.filter.TypeFilter;

public class ModifierSubjectTest {

    @Nested
    class PublicModifier {
        @ArchitectureCheck(modelPath = "src/test/resources/projects/modifiers/")
        @ExtendWith(FailsWithException.class)
        public void testPublicModifiersFailing(CtModel model) {
            allWithoutModifier(ModifierKind.PUBLIC, CtMethod.class)
                    .select(model)
                    .forEach(method -> Architecture.assertThat(model, method).isPublic());
        }

        @ArchitectureCheck(modelPath = "src/test/resources/projects/modifiers/")
        public void testProtectedModifiers(CtModel model) {
            allWithModifier(ModifierKind.PUBLIC, CtMethod.class)
                    .select(model)
                    .forEach(method -> Architecture.assertThat(model, method).isPublic());
        }
    }

    @Nested
    class ProtectedModifier {
        @ArchitectureCheck(modelPath = "src/test/resources/projects/modifiers/")
        @ExtendWith(FailsWithException.class)
        public void testProtectedModifiersFailing(CtModel model) {
            allWithoutModifier(ModifierKind.PROTECTED, CtMethod.class)
                    .select(model)
                    .forEach(method -> Architecture.assertThat(model, method).isProtected());
        }

        @ArchitectureCheck(modelPath = "src/test/resources/projects/modifiers/")
        public void testProtectedModifiers(CtModel model) {
            allWithModifier(ModifierKind.PROTECTED, CtMethod.class)
                    .select(model)
                    .forEach(method -> Architecture.assertThat(model, method).isProtected());
        }
    }

    @Nested
    class DefaultVisibiltyModifier {
        @ArchitectureCheck(modelPath = "src/test/resources/projects/modifiers/")
        @ExtendWith(FailsWithException.class)
        public void testProtecteModifiersFailing(CtModel model) {
            allWithoutModifier(null, CtMethod.class)
                    .select(model)
                    .forEach(method -> Architecture.assertThat(model, method).isProtected());
        }

        @ArchitectureCheck(modelPath = "src/test/resources/projects/modifiers/")
        public void testPublicModifiers(CtModel model) {
            allWithModifier(null, CtMethod.class).select(model).forEach(method -> Architecture.assertThat(model, method)
                    .isProtected());
        }
    }

    private <T extends CtModifiable> ElementSelection<T> allWithoutModifier(ModifierKind kind, Class<T> clazz) {
        return new ElementSelection<>() {
            @Override
            public List<T> select(CtModel model) {
                return model.getElements(new TypeFilter<>(clazz)).stream()
                        .filter(e -> !e.getModifiers().contains(kind))
                        .collect(Collectors.toList());
            }
        };
    }

    private <T extends CtModifiable> ElementSelection<T> allWithModifier(ModifierKind kind, Class<T> clazz) {
        return new ElementSelection<>() {
            @Override
            public List<T> select(CtModel model) {
                return model.getElements(new TypeFilter<>(clazz)).stream()
                        .filter(e -> e.getModifiers().contains(kind))
                        .collect(Collectors.toList());
            }
        };
    }
}

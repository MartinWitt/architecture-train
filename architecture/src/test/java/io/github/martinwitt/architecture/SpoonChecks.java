package io.github.martinwitt.architecture;

import io.github.martinwitt.architecture.errorhandling.NopError;
import io.github.martinwitt.architecture.preconditions.Modifier;
import io.github.martinwitt.architecture.preconditions.Naming;
import io.github.martinwitt.architecture.runner.Architecture;
import spoon.reflect.CtModel;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtField;

public class SpoonChecks {

    @Architecture
    public void statelessFactory(CtModel srcModel, CtModel testModel) {
        Precondition<CtClass<?>> pre =
                Precondition.of(DefaultElementFilter.CLASSES.getFilter(), Naming.contains("Factory"));
        Constraint<CtClass<?>> con = Constraint.of(new NopError<CtClass<?>>(), (clazz) -> clazz.getFields().stream()
                .allMatch(field -> stateless(field)));
        ArchitectureTest.of(pre, con).runCheck(srcModel);
    }

    private boolean stateless(CtField<?> field) {
        return Naming.equal("factory").test(field) || (Modifier.FINAL.test(field) && Modifier.TRANSIENT.test(field));
    }

    @Architecture
    public void testFactorySubFactory(CtModel srcModel, CtModel testModel) {
        Precondition<CtClass<?>> pre = Precondition.of(
                DefaultElementFilter.CLASSES.getFilter(),
                Naming.contains("Factory"),
                (clazz) -> clazz.getSuperclass().getSimpleName().equals("SubFactory"));

        // TODO: simplify to getClassWithName,SuperClass,Interface
        CtClass<?> factory = srcModel.getElements(DefaultElementFilter.CLASSES.<CtClass<?>>getFilter()).stream()
                .filter(v -> v.getSimpleName().equals("Factory"))
                .findFirst()
                .get();

        // TOOD: allow assertions for all methods
        Constraint<CtClass<?>> con = Constraint.of(new NopError<CtClass<?>>(), (clazz) -> clazz.getMethods().stream()
                .filter(v -> v.getSimpleName().startsWith("create"))
                .allMatch(v -> factory.getMethods().contains(v)));
        ArchitectureTest.of(pre, con).runCheck(srcModel);
    }

    @Architecture
    public void testDocumentation(CtModel srcModel, CtModel testModel) {
        // TODO:_
    }
}

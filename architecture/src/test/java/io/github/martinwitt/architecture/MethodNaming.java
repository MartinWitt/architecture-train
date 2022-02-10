package io.github.martinwitt.architecture;

import io.github.martinwitt.architecture.preconditions.Naming;
import io.github.martinwitt.architecture.preconditions.Visibility;
import io.github.martinwitt.architecture.runner.Architecture;
import spoon.reflect.CtModel;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtNamedElement;

public class MethodNaming {

    @Architecture
    public void methodNameStartsWithTest(CtModel srcModel, CtModel testModel) {
        Precondition<CtMethod<?>> pre = Precondition.of(DefaultElementFilter.METHODS.getFilter(), Visibility.PUBLIC);
        Constraint<CtNamedElement> con =
                Constraint.of((element) -> System.out.println(element), Naming.startsWith("test"));
        ArchitectureTest.of(pre, con).runCheck(testModel);
    }
}

package io.github.martinwitt.architecture;

import io.github.martinwitt.architecture.constraints.InvocationMatcher;
import io.github.martinwitt.architecture.preconditions.Visibility;
import io.github.martinwitt.architecture.runner.Architecture;
import spoon.reflect.CtModel;
import spoon.reflect.declaration.CtMethod;

public class MethodInvocation {

    @Architecture
    public void methodInvocationLookUp(CtModel srcModel, CtModel testModel) {
        Precondition<CtMethod<?>> pre = Precondition.of(DefaultElementFilter.METHODS.getFilter(), Visibility.PRIVATE);
        InvocationMatcher matcher = new InvocationMatcher(srcModel);
        Constraint<CtMethod<?>> con = Constraint.of(
                (element) -> System.out.println("element has no invocation: " + element),
                (element) -> matcher.test(element));
        ArchitectureTest.of(pre, con).runCheck(srcModel);
    }
}

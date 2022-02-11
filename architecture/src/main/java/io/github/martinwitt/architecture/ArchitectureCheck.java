package io.github.martinwitt.architecture;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(FailureCollector.class)
// @Target({ElementType.METHOD})
@Test
public @interface ArchitectureCheck {}

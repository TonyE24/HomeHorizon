package com.homehorizon.bienesraices.validaciones;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.constraints.Pattern.Flag;

@Constraint(validatedBy = PatternValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MiPattern {
    String regexp();

    String message() default "La expresión regular no es válida";

    Flag[] flags() default {};
}
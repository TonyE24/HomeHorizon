package com.homehorizon.bienesraices.validaciones;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PatternValidator implements ConstraintValidator<MiPattern, String> {
    private java.util.regex.Pattern pattern;

    @Override
    public void initialize(MiPattern constraintAnnotation) {
        int flags = 0;
        for (javax.validation.constraints.Pattern.Flag flag : constraintAnnotation.flags()) {
            flags |= flag.getValue();
        }
        this.pattern = java.util.regex.Pattern.compile(constraintAnnotation.regexp(), flags);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false; // Valor null es inválido
        }
        return this.pattern.matcher(value).matches();
    }
}
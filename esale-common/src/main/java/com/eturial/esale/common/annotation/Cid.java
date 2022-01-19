package com.eturial.esale.common.annotation;

import com.eturial.esale.common.validator.CidValidator;
import com.eturial.esale.common.validator.MobileValidator;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CidValidator.class)
public @interface Cid {
}

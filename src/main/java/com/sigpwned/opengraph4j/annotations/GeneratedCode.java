package com.sigpwned.opengraph4j.annotations;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.CLASS;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * A hint to tools to ignore code for the purposes of computing test coverage.
 * 
 * @see https://github.com/jacoco/jacoco/issues/656
 */
@Retention(CLASS)
@Target({TYPE, METHOD, CONSTRUCTOR})
public @interface GeneratedCode {
}

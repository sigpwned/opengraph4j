package com.sigpwned.opengraph4j.annotation;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.CLASS;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Marks generated methods to exclude from code coverage
 */
@Retention(CLASS)
@Target({TYPE, CONSTRUCTOR, METHOD})
public @interface Generated {
  public String value();
}

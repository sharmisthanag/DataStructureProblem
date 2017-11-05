package com.java8.text.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
@Retention(value=RetentionPolicy.CLASS)
public @interface CustomAnnotation {

	String key();
    String value();
}

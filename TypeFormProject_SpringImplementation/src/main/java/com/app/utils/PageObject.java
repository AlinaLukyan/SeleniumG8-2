package com.app.utils;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)  //KEEP AN EYE
@Retention(RetentionPolicy.RUNTIME) //KEEP AN EYE
@Component
public @interface PageObject {

}

package com.example.demo.ratelimit.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyLimiter {
	String key() default "my:limiter";
	// 单位时间内限制数量
	long times() default 2;
	// 过期时间
	long expire() default 1;
}

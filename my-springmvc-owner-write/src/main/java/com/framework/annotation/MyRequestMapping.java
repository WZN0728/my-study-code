/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  MyRequestMapping.java
 * @Package com.framework.annotation
 * @Copyright: 2018 All rights reserved.
 */
package com.framework.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName:  MyRequestMapping
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date:   2018年4月28日 下午8:47:19
 */
@Documented
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyRequestMapping {
	String value() default "";
}

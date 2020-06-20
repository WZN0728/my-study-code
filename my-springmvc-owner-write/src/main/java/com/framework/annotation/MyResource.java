/**
 * All rights Reserved, Designed By MyCompany
 * @Title:  MyResource.java
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
 * @ClassName:  MyResource
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date:   2018��4��28�� ����8:46:44
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyResource {
	String value() default "";
}

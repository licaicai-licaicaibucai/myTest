package com.limaolin.framework.anno;

/**
 * 包名:com.itheima.framework.anno
 *
 * @author Leevi
 * 日期2020-08-01  12:10
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {
    String value();
}

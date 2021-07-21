package com.maple.common.annotation;

import java.lang.annotation.*;

/**
 * 数据权限过滤注解
 *
 * @author Maple
 * @classname DataScope
 * @create 2021-07-21 21:42
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataScope {

    /**
     * 班级表的别名
     */
    String classAlias() default "";

    /**
     * 用户表的别名
     */
    String userAlias() default "";

}

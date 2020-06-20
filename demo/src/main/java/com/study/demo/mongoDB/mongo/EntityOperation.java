package com.study.demo.mongoDB.mongo;

/**
 * 实体对象的反射操作
 *
 * @param <T>
 * @author Tom
 */

public class EntityOperation<T> {
    public Class<T> entityClass = null; // 泛型实体Class对象

    public EntityOperation(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
}


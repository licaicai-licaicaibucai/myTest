package com.limaolin.framework.entry;

import java.lang.reflect.Method;

/**
 * 包名:com.itheima.framework.entry
 *
 * @author Leevi
 * 日期2020-08-01  14:32
 * 多个MVCMethod对象
 */
public class MvcMethod {
    private Method method;
    private Object object;

    public MvcMethod() {
    }

    public MvcMethod(Method method, Object object) {
        this.method = method;
        this.object = object;
    }

    @Override
    public String toString() {
        return "MvcMethod{" +
                "method=" + method +
                ", object=" + object +
                '}';
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}

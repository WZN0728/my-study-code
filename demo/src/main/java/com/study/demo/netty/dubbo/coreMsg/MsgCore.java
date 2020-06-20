package com.study.demo.netty.dubbo.coreMsg;

import java.io.Serializable;

/**
 * @author wuting
 * @date 2019/02/26
 */
public class MsgCore implements Serializable {

    private static final long serialVersionUID = 2967523154905553049L;

    private String className;//类名

    private String methodName;//函数名称

    private Class<?>[] parames;//参数类型

    private Object[] values;//参数列表

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?>[] getParames() {
        return parames;
    }

    public void setParames(Class<?>[] parames) {
        this.parames = parames;
    }

    public Object[] getValues() {
        return values;
    }

    public void setValues(Object[] values) {
        this.values = values;
    }

}

package com.demo.rmi.rpc;

import java.io.Serializable;

/**
 * @author wuting
 * @date 2019/03/20
 */
public class RpcRequest implements Serializable {

    private static final long serialVersionUID = 6089756736418188181L;

    private String version;

    private String className;

    private String methodName;

    private Object[] parameters;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

}

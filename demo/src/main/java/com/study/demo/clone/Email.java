package com.study.demo.clone;

import java.io.Serializable;

/**
 * @author wuting
 * @date 2019/02/14
 */
public class Email implements Cloneable, Serializable {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Email{" +
                "content='" + content + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}

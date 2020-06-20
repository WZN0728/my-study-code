/**
 * All rights Reserved, Designed By MyCompany
 *
 * @Title: DoOrderRequest.java
 * @Package org.api
 * @Copyright: 2018 All rights reserved.
 */
package org.api;

import java.io.Serializable;

/**
 * @ClassName: DoOrderRequest
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年4月17日 上午11:39:04
 */
public class DoOrderRequest implements Serializable {

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1251864157760082467L;

    private String name;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("DoOrderRequest [name=%s]", name);
    }

}

/**
 * All rights Reserved, Designed By MyCompany
 *
 * @Title: InterfaceTest2.java
 * @Package test
 * @Copyright: 2018 All rights reserved.
 */
package test;

import com.InterfaceTest;

/**
 * @ClassName: InterfaceTest2
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 吴停
 * @date: 2018年4月24日 下午11:24:11
 */
public class InterfaceTest2 implements InterfaceTest {

    public static void main(String[] args) {
        InterfaceTest2 test = new InterfaceTest2();
        System.out.println(InterfaceTest2.name);
        test.Test();
        String value = InterfaceTest.getValue();
        System.out.println(value);
    }

}

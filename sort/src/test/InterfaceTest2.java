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
 * @Description:TODO(������һ�仰��������������)
 * @author: ��ͣ
 * @date: 2018��4��24�� ����11:24:11
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

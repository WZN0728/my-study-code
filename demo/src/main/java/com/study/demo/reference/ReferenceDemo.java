package com.study.demo.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author wuting
 * @date 2019/02/15
 */
public class ReferenceDemo {

    //引用分为强软弱虚
    //1.强引用 就是正常new出来的对象引用，即使发生OOM也不回收
    //2.软引用 SoftReference修饰的引用,在发生OOM之前进行回收,在内存充足的情况下是不会被回收的
    //3.弱引用 WeakReference修饰的引用,只要触发GC就会被回收
    //4.虚引用 PhantomReference修饰的引用,
    public static void main(String[] args) {
        User user = new User();//强引用
        SoftReference softReference = new SoftReference(user);//软引用
        WeakReference weakReference = new WeakReference(user);//弱引用
        ReferenceQueue referenceQueue = new ReferenceQueue();
        PhantomReference phantomReference = new PhantomReference(user, referenceQueue);//虚引用
        System.out.println("强引用" + user);
        System.out.println("软引用" + softReference.get());
        System.out.println("弱引用" + weakReference.get());
        System.out.println("虚引用" + phantomReference.get());
        System.gc();
        System.out.println("强引用" + user);
        System.out.println("软引用" + softReference.get());
        System.out.println("弱引用" + weakReference.get());
        System.out.println("虚引用" + phantomReference.get());
    }

    static class User {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}

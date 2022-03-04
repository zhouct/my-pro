package com.zc.base.concurrent;

import org.hibernate.validator.internal.util.privilegedactions.NewInstance;
import org.junit.Before;
import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.security.Guard;

public class UnsafeDemo {

    public Unsafe get() {

        Field field = null;
        try {
            field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            Unsafe u = (Unsafe) field.get(null);
            return u;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 不经过构造器，创建实例
     * @throws Exception
     */
    @Test
    public void testAllocateInstance() throws Exception {

        Single s1 = Single.getInstance();

//        Single s2 = Single.class.newInstance();  // 创建失败

        Unsafe unsafe = get();
        Single s3 = (Single) unsafe.allocateInstance(Single.class);
    }

    /**
     * 修改属性
     */
    @Test
    public void testObjectFieldOffset() throws Exception {
        Unsafe unsafe = get();
        Car car = new Car();
        System.out.println(car.access());

        Field f = Car.class.getDeclaredField("ACCESS_ALLOWED");
        unsafe.putInt(car, unsafe.objectFieldOffset(f), 17);
        System.out.println(car.access());
    }

    static class Single{

        private static volatile Single single;

        private Single(){
            System.out.println("new instance from constructor");
        }

        public static Single getInstance(){
            if(single == null){
                synchronized (Single.class){
                    if(single == null){
                        single = new Single();
                    }
                }
            }
            return single;
        }

    }

    class Car{

        Integer id;

        private int ACCESS_ALLOWED = 1;

        public boolean access(){
            return 17 == ACCESS_ALLOWED;
        }

        @Override
        public String toString() {
            return "car-" + id;
        }
    }

}

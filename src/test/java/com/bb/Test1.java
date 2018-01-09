package com.bb;


//静态变量线程安全问题模拟
//http://blog.csdn.net/aaa1117a8w5s6d/article/details/8295527
public class Test1 implements Runnable {


    private static int static_i;    //静态变量

    public void run()  {
        static_i = 4;
        System.out.println("[" + Thread.currentThread().getName()
                + "]获取static_i 的值:" + static_i);
        static_i = 10;
        System.out.println("[" + Thread.currentThread().getName()
                + "]获取static_i*3的值:" + static_i * 2);
    }


    public static void main(String[] args) {
        Test1 t = new Test1();
        //启动尽量多的线程才能很容易的模拟问题
        for (int i = 0; i < 3000; i++)
        {
            //t可以换成new Test(),保证每个线程都在不同的对象中执行，结果一样
            new Thread(t, "线程" + i).start();
        }
    }

}

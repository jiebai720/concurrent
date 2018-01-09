package com.bb;


//实例变量线程安全问题模拟

public class Test4 implements Runnable
{
    private MyInteger myInteger = new MyInteger(); //实例变量


    public void run()
    {
        myInteger.setInstance_i(4);
        System.out.println("[" + Thread.currentThread().getName()
                + "]获取instance_i 的值:" + myInteger.getInstance_i() + " :::::::" + myInteger  );
        myInteger.setInstance_i(10);

        myInteger.setInstance_i( myInteger.getInstance_i() * 2 );
        System.out.println("[" + Thread.currentThread().getName()
                + "]获取instance_i*3的值:" + myInteger.getInstance_i()  + " :::::::" + myInteger  );
    }


    public static void main(String[] args)
    {
        Test4 t = new Test4();
        //启动尽量多的线程才能很容易的模拟问题
        for (int i = 0; i < 3000; i++)
        {
            //每个线程对在对象t中运行，模拟单例情况
            new Thread(t, "线程" + i).start();
        }
    }

}
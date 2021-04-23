package functest.threadAndRunable;

import lombok.SneakyThrows;

/**
 * @Author: jintienan
 * @Date: 2021/3/17 10:15
 */

public class WaitingAndTimeWaiting {

    public static void main(String[] args){
        new Thread(new TimeWaiting(), "TimeWaiting").start();
        new Thread(new Waiting(), "Waiting").start();
        new Thread(new Blocked(), "Blocked-1").start();
        new Thread(new Blocked(), "Blocked-2").start();

    }

    // 该线程不断地进行睡眠
    static class TimeWaiting implements Runnable {
        @Override
        public void run (){
            try{
                while (true){
                    Thread.sleep(5000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    // 该线程在 Waiting.class 实例上等待
    static class Waiting implements Runnable{
        @Override
        public void run(){
            while(true){
                synchronized (Waiting.class){
                    try{
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    // 该线程在 Blocked.class 实例上加锁后，不会释放该锁
    static class Blocked implements Runnable{
        @Override
        public void run(){
            synchronized (Blocked.class){
                while (true) {
                    try {
                        Thread.sleep(5000);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }


}

package functest.threadAndRunable.daemon;

/**
 * @Author: jintienan
 * @Date: 2021/4/9 10:19
 * https://blog.csdn.net/shimiso/article/details/8964414
 */
public class DaemonThread {


}

class DaemonSpawn implements Runnable{

    @Override
    public void run(){
        while(true){
            Thread.yield();// 暂停当前正在执行的线程对象，并执行其他线程
        }
    }

class DaemonHolder implements Runnable{

        @Override
        public void run(){

    }
}
}

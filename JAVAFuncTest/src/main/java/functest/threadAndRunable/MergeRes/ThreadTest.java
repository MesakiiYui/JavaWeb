package functest.threadAndRunable.MergeRes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


/**
 * @Description:多线程执行同一任务,所有线程返回值后执行下一步操作测试(可用于多线程查询)
 * @Auther:
 * @Date:
 */
public class ThreadTest {
    private static ExecutorService threadPool = null;

    static {
        threadPool = Executors.newFixedThreadPool(20);
    }

    public static void main(String[] args) {
        try {
//            getNumArg(1);
//            getNumArg(2);
            getForNum();
            System.out.println("方法执行完毕");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description: 简单多线程执行(参数利用)
     * @Param: []
     * @return: void
     * @Author: MaoHQ
     * @Date: 2021/3/25
     */
    public static void getNumArg(int num) throws InterruptedException, ExecutionException {
        List<String> tmplist = new ArrayList<String>();
        CountDownLatch latch = new CountDownLatch(2);
        Future<Integer> lnt = threadPool.submit(new TestThread1(1, tmplist,latch));
        Future<Integer> ykt = threadPool.submit(new TestThread2(2, tmplist,latch));
        //等待线程均完成
        latch.await();
        //获取线程返回值
        Integer i1 = lnt.get();
        Integer i2 = ykt.get();
        //线程均执行完后,继续执行
        System.out.println(i1 + i2 + "数据:" +num);
        for (String string : tmplist) {
            System.out.println(string+ "数据:" +num);
        }

    }

    /**
     * @Description: 多线程执行
     * @Param: []
     * @return: void
     * @Author: MaoHQ
     * @Date: 2021/3/25
     */
    public static void getNum() throws InterruptedException, ExecutionException {
        Future<Integer> t1 = threadPool.submit(new TestThread1(1));
        Future<Integer> t2 = threadPool.submit(new TestThread2(2));
        //获取线程返回值
        Integer i1 = t1.get();
        Integer i2 = t2.get();
        //线程均执行完后,继续执行
        System.out.println(i1 + i2);
    }

    /**
     * @Description: 多线程执行(循环)
     * @Param: []
     * @return: void
     * @Author: MaoHQ
     * @Date: 2021/3/29
     */
    public static void getForNum() throws InterruptedException, ExecutionException {
        int total = 5;
        List< Future<Integer>> allFuture = new ArrayList();
        CountDownLatch latch = new CountDownLatch(total);
        for (int i = 0; i <total ; i++) {
            Future<Integer> tmpData = threadPool.submit(new TestThread1(1,latch));
            allFuture.add(tmpData);
        }
        latch.await();
        for (Future future : allFuture) {
            Integer num = (Integer) future.get();
            System.out.println(num);
        }

    }

    /***
     * @Description:  线程2(执行中有睡眠)
     * @Param:
     * @return:
     * @Author: MaoHQ
     * @Date: 2021/3/25
     */
    private static class TestThread2 implements Callable<Integer> {
        private int num;
        private List<String> tmplist;
        private CountDownLatch latch;

        public TestThread2(int num) {
            this.num = num;
        }

        public TestThread2(int num, List<String> tmplist) {
            this.num = num;
            this.tmplist = tmplist;
        }
        public TestThread2(int num, List<String> tmplist, CountDownLatch latch) {
            this.num = num;
            this.tmplist = tmplist;
            this.latch = latch;
        }

        @Override
        public Integer call() throws Exception {
            try {
                System.out.println("线程2(执行中有睡眠) 正在运行2");
                Thread.sleep(5000);
                if (tmplist != null)
                    tmplist.add("a");
                return num;
            }finally {
                latch.countDown();
            }
        }

    }

    /***
     * @Description: 线程1(执行中无睡眠)
     * @Param:
     * @return:
     * @Author: MaoHQ
     * @Date: 2021/3/25
     */
    private static class TestThread1 implements Callable<Integer> {
        private int num;
        private List<String> tmplist;
        private CountDownLatch latch;

        public TestThread1(int num, List<String> tmplist) {
            this.num = num;
            this.tmplist = tmplist;
        }

        public TestThread1(int num) {
            this.num = num;
        }

        public TestThread1(int num, List<String> tmplist, CountDownLatch latch) {
            this.num = num;
            this.tmplist = tmplist;
            this.latch = latch;
        }
        public TestThread1(int num, CountDownLatch latch) {
            this.num = num;
            this.latch = latch;
        }

        @Override
        public Integer call() throws Exception {
            try {
                if (tmplist != null)
                    tmplist.add("b");
                System.out.println("线程1(执行中无睡眠) 正在运行");
                return num;
            }finally {
                //线程执行数-1
                latch.countDown();
            }
        }

    }

}


package functest.threadAndRunable;

import java.util.concurrent.TimeUnit;

/**
 * @Author: jintienan
 * @Date: 2021/3/17 15:33
 */
public class SleepUtils {
    public static final void second(long seconds){
        try{
            TimeUnit.SECONDS.sleep(seconds);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

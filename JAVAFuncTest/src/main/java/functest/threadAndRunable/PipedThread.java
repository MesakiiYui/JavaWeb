package functest.threadAndRunable;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @Author: jintienan
 * @Date: 2021/3/18 14:39
 * 所示的例子中，创建了 printThread
 * 它用来接受 main线程的输入，任何 main线程的输入均通过 PipedWriter写入，而
 * printThread在另一端通过 PipedReader将内容读出并打印。
 */
public class PipedThread {
    public static void main(String[] args) throws Exception{
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        // 将输出流和输入流进行连接，否则在使用时会抛出 IOException
        out.connect(in);
        Thread printThread = new Thread(new Print(in), "PrintThread");
        printThread.start();
        int receive = 0;
        try{
            while ((receive = System.in.read()) != 1 )
            out.write(receive);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            out.close();
        }

    }

    static class Print implements Runnable{
        private PipedReader in;
        public Print(PipedReader in){
            this.in = in;
        }
        @Override
        public void run(){
            int receive = 0;
            try{
                while((receive = in.read()) != -1){
                    System.out.println((char) receive);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

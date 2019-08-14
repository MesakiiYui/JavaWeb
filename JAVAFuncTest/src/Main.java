import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Main extends Thread {
//    private java.text.SimpleDateFormat sdfYMD = new java.text.SimpleDateFormat("yyyy-MM-dd");
//    private java.text.SimpleDateFormat sdfYMDHMS = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private String name;
    private String dateStr;
    public Main(String name, String dateStr) {
        this.name = name;
        this.dateStr = dateStr;
    }
    @Override
    public void run() {
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(name + " : date: " + date);
    }
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(new Main("Test_A", "2000-04-28"));
        executor.execute(new Main("Test_B", "2017-04-28"));
        executor.shutdown();
    }
}
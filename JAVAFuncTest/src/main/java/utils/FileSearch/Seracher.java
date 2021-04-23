package utils.FileSearch;
import java.io.File;
/**
 * @Author: jintienan
 * @Date: 2021/4/22 9:21
 */
public class Seracher {

    public static void searchFile() throws Exception{
        String initPath = "C:/";
        String fileName = ".json";
        System.out.println("正在执行");
        File file = new File(initPath);
        try{
            directoryProcess(file);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void directoryProcess(File file)throws Exception{
        File[] list = file.listFiles();  // 获取当目录中的所有文件
        if (list != null) { // 如果当前目录下有文件
            for (int i = 0; i < list.length; i++) {  // 遍布所有文件
//                System.out.println(list[i].getName());
                if (list[i].isDirectory()) { // 如果是一个目录
                    directoryProcess(list[i]); // 递归处理
                } else {
                    fileProcess(list[i]); // 如果是一个文件，调用文件处理方法
                }
            }
        }
    }

    private static void fileProcess(File file) throws Exception {

        if (file.getName().contains(".json") && file.getName().length() < 12) { // 当前文件名与要查找的文件同名，就输出信息
            System.out.printf("%s : %s\n", Thread.currentThread().getName(), file.getAbsolutePath());
        }

        if (Thread.interrupted()) {  // 程序被中断就抛出异常
            throw new InterruptedException();
        }
    }

    public static void main(String[] args) throws Exception{
        searchFile();
    }

}

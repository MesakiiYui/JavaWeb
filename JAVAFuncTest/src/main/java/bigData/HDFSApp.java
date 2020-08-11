package bigData;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

/**
 * Created by japson on 5/26/2018.
 * Hadoop HDFS Java API 操作
 */
public class HDFSApp {

    // HDFS_PATH 很重要！是访问连接HDFS的关键
    public static final String HDFS_PATH = "hdfs://192.168.0.117:8020";

    // 必需的FileSystem类
    FileSystem fileSystem = null;
    // 配置对象
    Configuration configuration = null;

    /**
     * 初始化一些资源
     */
    @Before
    public void setUp() throws Exception{
        configuration = new Configuration();
        // 获取一个fileSystem对象，这就相当于建立连接了
        fileSystem = FileSystem.get(new URI(HDFS_PATH),configuration,"japson");
        System.out.println("HDFSApp.setUp");
    }

    private FileSystem getFiledSystem() throws IOException {
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(configuration);
        return fileSystem;
    }
    /**
     * 创建HDFS目录
     * @throws Exception
     */
    @Test
    public void mkdir() throws Exception {
        // 创建一个新的目录，参数为路径
        fileSystem.mkdirs(new Path("/hdfsapi/test3"));
        System.out.println("mkdir已执行");
    }


    /**
     * 释放资源
     */
    @After
    public void tearDown() throws Exception {
        configuration = null;
        fileSystem = null;
        System.out.println("HDFSApp.tearDown");
    }

    /**
     * 创建一个文件并写入内容
     * @throws Exception
     */
    @Test
    public void create() throws Exception {
        FSDataOutputStream outputStream = fileSystem.create(new Path("/hdfsapi/test3/a.txt"));
        outputStream.write("hello hadoop".getBytes());
        outputStream.flush();
        outputStream.close();
    }

    /**
     * 查看HDFS文件的内容
     * @throws Exception
     */
    @Test
    public void cat() throws Exception {
        FSDataInputStream inputStream = null;
        try{
            inputStream = fileSystem.open(new Path("/hdfsapi/test3/a.txt"));
            IOUtils.copyBytes(inputStream,System.out,1024);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null){
                IOUtils.closeStream(inputStream);
            }
        }




    }

    /**
     * 删除文件
     * @throws Exception
     */
    @Test
    public void delete() throws Exception {

        fileSystem.delete(new Path("/hdfsapi/test/a.txt"),true);

    }

    /**
     * 文件重命名
     * fileSystem.rename(oldPath,newPath);，需要注意的是：每次只能修改一个目录名或文件名，不能同时修改两个及以上。
     * @throws Exception
     */
    @Test
    public void rename() throws Exception {
        Path oldPath = new Path("/hdfsapi/test3/a.txt");
        Path newPath = new Path("/hdfsapi/test3/b.txt");
        fileSystem.rename(oldPath,newPath);
    }

    /**
     * 上传本地文件到HDFS
     * 小文件直接上传
     * 注意，这里的本地文件，指的就是java的本地环境，而不是服务器的。
     *
     * 使用fileSystem.copyFromLocalFile(localPath,hdfsPath);方法。
     * 上传本地文件到HDFS
     * @throws Exception
     */
    @Test
    public void copyFromLocalFile() throws Exception {
        Path localPath = new Path("E:\\IntelliJ IDEA\\hadoopTest1\\localText.txt");
        Path hdfsPath = new Path("/hdfsapi/test");

        fileSystem.copyFromLocalFile(localPath,hdfsPath);
    }

    /**
     * 大文件进度条
     * 我们就不使用fileSystem.copyFromLocalFile(localPath,hdfsPath);了。
     *
     * 我们先将要上传的文件放入输入流，然后用输出流写，并在参数中选择输出进度条。
     *
     * 然后使用IOUtils，将输入流的内容拷贝到输出流：
     * 上传本地大文件且需要进度条
     * @throws Exception
     */
    @Test
    public void copyFromLocalFileWithProgress() throws Exception {
        FSDataOutputStream outputStream = null;
        FileInputStream fileInputStream = null;
        String localPath = "D:\\迅雷下载\\逃避可耻却有用1.mp4";
        String hdfsPath = "/hdfsapi/test/gakki.mp4";
        try {
            Path path = new Path(hdfsPath);
            outputStream = this.getFiledSystem().create(path);
            fileInputStream = new FileInputStream(new File(localPath));
            //输入流、输出流、缓冲区大小、是否关闭数据流，如果为false就在 finally里关闭
            IOUtils.copyBytes(fileInputStream, outputStream,4096, false);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileInputStream != null){
                IOUtils.closeStream(fileInputStream);
            }
            if(outputStream != null){
                IOUtils.closeStream(outputStream);
            }
        }

    }


    /**
     * 下载HDFS文件到本地
     * @throws Exception
     */
    @Test
    public void copyToLocalFile() throws Exception {
        Path localPath = new Path("E:\\IntelliJ IDEA\\hadoopTest1\\download.txt");
        Path hdfsPath = new Path("/hdfsapi/test/b.txt");
        fileSystem.copyToLocalFile(hdfsPath,localPath);
    }

    /**
     * 查看某个目录下的所有文件
     * @throws Exception
     */
    @Test
    public void listFiles() throws Exception {
        FileStatus[] fileStatuses = fileSystem.listStatus(new Path("/hdfsapi/test"));
        for (FileStatus fileStatus : fileStatuses) {
            String isDir = fileStatus.isDirectory() ? "文件夹" : "文件";
            short replication = fileStatus.getReplication();
            long len = fileStatus.getLen();
            String path = fileStatus.getPath().toString();

            System.out.println(isDir + "\t" + replication + "\t" + len + "\t" + path);
        }
    }




}
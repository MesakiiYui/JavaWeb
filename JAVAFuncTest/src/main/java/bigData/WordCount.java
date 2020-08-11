package bigData;

import com.google.common.collect.Lists;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.io.IOException;
import java.util.List;

/**
 * @Author: jintienan
 * @Date: 2020/8/10 16:05
 */
// 为方便，我们先创建一个类：MyWordCountUp并使其继承自 Configured 以及实现 Tool 接口，结构如下：
public class WordCount  extends Configured implements Tool {
    // 在类中创建一个继承自 WordCountMapper 的类，用于切割数据并实现相关的逻辑(这里为方便是以内部类的形式创建的，看个人的需求)：
    public static class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

        private Text mapKey = new Text();
        private IntWritable mapValue  = new IntWritable(1); //初始值赋值为1

        //对我们独立元素中的每一个元素进行并行计算操作的函数
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String line = value.toString();
            //以空格切割成字符串数组
            String[] lines = line.split(" ");
            for(String str : lines){
                mapKey.set(str); //设值
                context.write(mapKey, mapValue);
            }
        }
    }

    // 同理，创建一个继承自 Reducer 的内部类，用于统计单词的个数即聚合：
    public static class WrodCountReduce extends Reducer<Text, IntWritable, Text, IntWritable> {

        private IntWritable reduceValue = new IntWritable();

        //对我们独立元素中的数据进行合并
        @Override
        protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {

            List<IntWritable> list = Lists.newArrayList(values);
            int sum = 0;
            for(IntWritable reduceValue : list){
                sum += reduceValue.get(); //累加
            }

            reduceValue.set(sum);//设值
            context.write(key, reduceValue);
        }
    }

    //run
    // 在run 方法中操作 driver (组装所有的过程到job)：
    public int run(String[] args) throws Exception {

        //driver
        //1) 获取 conf
        Configuration configuration = this.getConf(); //由于类已继承 Configured ，因此直接调用其方法

        //2) 创建 job
        Job job = Job.getInstance(configuration,this.getClass().getSimpleName());
        job.setJarByClass(this.getClass());

        //3.1) 输入
        Path path = new Path(args[0]);
        FileInputFormat.addInputPath(job, path);

        //3.2 设置 map
        job.setMapperClass(WordCountMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        // 5 -> 在这里可以设置:分区、排序、分组、设置 reduce 的个数等

        //3.3 设置 reduce
        job.setReducerClass(WrodCountReduce.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        //3.4 输出
        Path outPath = new Path(args[1]);
        FileOutputFormat.setOutputPath(job, outPath);

        //4. 提交
        boolean sucess = job.waitForCompletion(true);
        return sucess ? 0 : 1;
    }

    public static void main(String[] args) {

        //当打包成 jar 之前 记得注释掉
//        args = new String[]{
//                "hdfs://bigdata-pro01.lcy.com:9000/user/hdfs/wordcount.txt",
//                "hdfs://bigdata-pro01.lcy.com:9000/user/hdfs/output"
//        };

        Configuration configuration = new Configuration();

        try {
            //先判断文件夹是否存在
            Path fileOutPath = new Path(args[1]);
            FileSystem fileSystem = FileSystem.get(configuration);

            if(fileSystem.exists(fileOutPath)){
                fileSystem.delete(fileOutPath, true); //删除
            }

            int status = ToolRunner.run(configuration, new WordCount(), args);
            System.exit(status);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }




}

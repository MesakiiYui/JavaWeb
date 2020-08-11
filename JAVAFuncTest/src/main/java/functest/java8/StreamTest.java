package functest.java8;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamTest {

    /**
     * 创建一个stream
     * @return
     */
    private Stream<String> generateStream(){
        //Stream Creation
        // Stream<T> stream = Stream.of(T... values);
        Stream<Object> build = Stream.builder().add(1).add(2).build();
        Stream<Integer> iterate= Stream.iterate(0, x -> x + 1).limit(3);
        Stream<String> generate = Stream.generate(() -> "hello world").limit(3);

        // 数组转stream
        IntStream stream1 = Arrays.stream(new int[]{1, 3, 4});
        Stream<Integer> stream2 = new ArrayList<Integer>().stream();

        // 上面为创建stream的几种方式
        String[] arr = new String[]{"a", "b", "c"};
        // 或者写成Stream.of("a", "b", "c");
        return Arrays.stream(arr);
    }

    /**
     * 创建一个固定的list,含有重复元素
     * @return
     */
    private List<String> generateList(){
        List<String> list =new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add("abc");
        list.add("abc");
        list.add("ccc");
        list.add("ccc");
        list.add("ddd");
        list.add("ddd");
        return list;
    }

    /**
     * stream多线程： parallelStream()：
     */
    @Test
    public void parallelStreamTest(){
        //Multi-threading
        List<String> list = this.generateList();
        list.parallelStream().forEach(System.out::println);
    }

    /**
     * distinct   count   collect
     *
     * stream的级联操作和终止操作---distinct && count
     * distinct（）返回由该流的不同元素组成的流。
     * 如果distinct（）正在处理有序流，那么对于重复元素，将保留以遭遇顺序首先出现的元素，并且以这种方式选择不同元素是稳定的。
     * 如果distinct（）正在处理无序流，不同元素的选择不一定是稳定的，是可以改变的.
     *
     * distinct（）执行有状态的中间操作。在有序流的并行流的情况下，保持distinct（）的稳定性是需要很高的代价的，因为它需要大量的缓冲开销。
     * 如果我们不需要保持遭遇顺序的一致性，那么我们应该可以使用通过BaseStream.unordered（）方法实现的无序流。
     */
    @Test
    public void basicOperationTest(){
        List<String> list = this.generateList();
        //distinct()返回一个Stream，所以可以级联操作，最后的count()是一个终止操作，返回最后的值。
        Long count = list.stream().distinct().count(); // 会对数组进行去重
        log.info("count的值为{}",count);
        String output = list.stream().distinct().collect(Collectors.joining(","));
        System.out.println(output);

    }


    /**
     * allMatch 全部匹配
     * anyMatch 有一个匹配就返回true
     * noneMatch 全部都不匹配才返回true
     */
    @Test
    public void matchTest(){
        System.out.println(Stream.of("peter", "anna", "mike").allMatch(s -> s.startsWith("a")));
        System.out.println(Stream.of("peter", "anna", "mike").anyMatch(s -> s.startsWith("a")));
        System.out.println(Stream.of("peter", "anna", "mike").noneMatch(s -> s.startsWith("a")));
    }

    /**
     * filter
     * 过滤操作，返回Stream，可以进行链式调用
     */
    @Test
    public void filterTest(){
        Stream.of("peter", "anna", "mike").filter(value -> value.startsWith("a")).collect(Collectors.toList()).forEach(System.out::println);
    }

    /**
     * map
     * 映射操作，返回Stream
     */
    @Test
    public void mapTest(){
        Stream.of("peter", "anna", "mike").map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);
    }

    /**
     * flatMap
     * 将最底层元素抽出来放到一起
     */
    @Test
    public void flatMapTest(){
        Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(2, 3, 6)).collect(Collectors.toList()).forEach(System.out::print);
        Stream<List<Integer>> listStream = Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(2, 3, 6));
        listStream.flatMap(lists -> lists.stream()).collect(Collectors.toList()).forEach(System.out::print);
        Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(2, 3, 6)).flatMap(lists -> lists.stream()).collect(Collectors.toList()).forEach(System.out::print);
    }

    /**
     * concat
     * 流连接操作
     */
    @Test
    public void concatTest(){
        Stream.concat(Stream.of(1, 2), Stream.of(3)).forEach(System.out::print);
    }

    /**
     * peek
     * 生成一个包含原Stream的所有元素的新Stream，新Stream每个元素被消费之前都会执行peek给定的消费函数
     */
    @Test
    public void peekTest(){
        Stream.of(2, 4).peek(x -> System.out.print(x - 1)).forEach(System.out::print);
    }

    /**
     * skip
     * 跳过前N个元素后，剩下的元素重新组成一个Stream
     */
    @Test
    public void skipTest(){
        Stream.of(1, 2, 3, 4).skip(2).forEach(System.out::print);
    }

    /**
     * max min
     * 求最大值，最小值
     */
    @Test
    public void maxTest(){
        System.out.println(Stream.of(1, 2, 3, 4).max(Integer::compareTo).get());
    }

    /**
     * reduce：
     */
    @Test
    public void reduceTest(){
        System.out.println(Stream.of(1, 2, 3, 4).reduce((a, b) -> a + b).get());
        System.out.println(Stream.of(1, 2, 3, 4).reduce(0, (a, b) -> a + b));
        System.out.println(Stream.of(1,2,3,4,5).reduce(0,(i1,i2) -> (i1 + i2)));
        System.out.println(Stream.of(1,2,3,4,5).reduce(1,(i1,i2) -> (i1 + i2)));
    }

    /**
     * Collectors.toCollection(TreeSet::new)
     * 转换成特定的set集合
     */
    @Test
    public void collectSetTest(){
        Stream.of(1, 3, 4).collect(Collectors.toCollection(TreeSet::new)).forEach(System.out::print);
    }

    /**
     * Collectors.toMap(x -> x, x -> x + 1)
     * 转换成map
     */
    @Test
    public void collectMapTest(){
        Map<Integer, Integer> collect1 = Stream.of(1, 3, 4).collect(Collectors.toMap(x -> x, x -> x + 1));
        log.info(JSON.toJSONString(collect1));
        log.info(JSON.toJSONString(collect1.keySet()));
        log.info(JSON.toJSONString(collect1.values()));
        log.info(JSON.toJSONString(collect1.get(1)));
    }

    /**
     * Collectors.minBy(Integer::compare)
     * 求最小值，相对应的当然也有maxBy方法
     */
    @Test
    public void minByTest(){
        Integer ans = Stream.of(1, 3, 4).collect(Collectors.minBy(Integer::compareTo)).get();
        log.info("min:  {}", ans);
    }

    /**
     * Collectors.averagingInt(x->x)
     * 求平均值，同时也有averagingDouble、averagingLong方法。
     */
    @Test
    public void averageTest(){
        System.out.println(Stream.of(1, 2, 3).collect(Collectors.averagingInt(x->x)));
    }

    /**
     * Collectors.summingInt(x -> x))：
     * 求和。
     */
    @Test
    public void sumTest(){
        System.out.println(Stream.of(1, 2, 3).collect(Collectors.summingInt(x->x)));
    }

    /**
     * Collectors.summarizingDouble(x -> x)：可以获取最大值、最小值、平均值、总和值、总数。
     */
    @Test
    public void summarizingDoubleTest(){
        DoubleSummaryStatistics summaryStatistics = Stream.of(1, 3, 4).collect(Collectors.summarizingDouble(x -> x));
        log.info("average:  {}", summaryStatistics.getAverage());//平均值
        log.info("count:  {}", summaryStatistics.getCount());//累加
        log.info("max:  {}", summaryStatistics.getMax());//最大值
        log.info("min:  {}", summaryStatistics.getMin());//最小值
        log.info("sum:  {}", summaryStatistics.getSum());//合计
    }

    /**
     * Collectors.groupingBy(x -> x)：
     * 有三种方法，查看源码可以知道前两个方法最终调用第三个方法，第二个参数默认HashMap::new 第三个参数默认Collectors.toList()，参考SQL的groupBy。
     */
    @Test
    public void groupByTest(){
        Map<Integer, List<Integer>> map1 = Stream.of(1, 3, 3, 4).collect(Collectors.groupingBy(x -> x));
        Map<Integer, Long> map2 = Stream.of(1, 3, 3, 4).collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        HashMap<Integer, Long> hashMap3 = Stream.of(1, 3, 3, 4).collect(Collectors.groupingBy(x -> x, HashMap::new, Collectors.counting()));
        log.info("map1:  {}", JSON.toJSONString(map1));
        log.info("map2:  {}", JSON.toJSONString(map2));
        log.info("hashMap3:  {}", JSON.toJSONString(hashMap3));
    }

    /**
     * Collectors.partitioningBy(x -> x > 2)，
     * 把数据分成两部分，key为ture/false。第一个方法也是调用第二个方法，第二个参数默认为Collectors.toList()。
     */
    @Test
    public void partitionTest(){
        Map<Boolean, List<Integer>> collect1 = Stream.of(1, 3, 4).collect(Collectors.partitioningBy(x -> x > 2));
        Map<Boolean, Long> collect2 = Stream.of(1, 3, 4).collect(Collectors.partitioningBy(x -> x > 2, Collectors.counting()));
        log.info("collect1:  {}", JSON.toJSONString(collect1));
        log.info("collect2:  {}", JSON.toJSONString(collect2));
    }

    /**
     * Collectors.joining(",")
     * 拼接字符串。
     */
    @Test
    public void joinTest(){
        System.out.println(Stream.of("a", "b", "c").collect(Collectors.joining(",")));
    }

    /**
     * Collectors.reducing(0, x -> x + 1, (x, y) -> x + y))
     * 在求累计值的时候，还可以对参数值进行改变，这里是都+1后再求和。跟reduce方法有点类似，但reduce方法没有第二个参数。
     */
    @Test
    public void reducingTest(){
        // 1+1+3+1+4+1 = 11
        System.out.println(Stream.of(1, 3, 4).collect(Collectors.reducing(0, x -> x + 1, (x, y) -> x + y)));
    }

    /**
     * Collectors.collectingAndThen(Collectors.joining(","), x -> x + "d")：
     * 先执行collect操作后再执行第二个参数的表达式。这里是先拼接字符串，再在最后+ "d"。
     */
    @Test
    public void collectingAndThenTest(){
        String str= Stream.of("a", "b", "c").collect(Collectors.collectingAndThen(Collectors.joining(","), x -> x + ",d"));
        log.info("str:  {}", str);
    }

    /**
     * Collectors.mapping(...)：跟map操作类似，只是参数有点区别。
     */
    @Test
    public void mappingTest(){
        System.out.println(Stream.of("a", "b", "c").collect(Collectors.mapping(x -> x.toUpperCase(), Collectors.joining(","))));
        Stream.of("peter", "anna", "mike").map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);
    }

}

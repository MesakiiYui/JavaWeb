package functest.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: jintienan
 * @Date: 2020/11/18 9:36
 * 1>PriorityQueue是一种无界的，线程不安全的队列
 * 2>PriorityQueue是一种通过数组实现的，并拥有优先级的队列
 * 3>PriorityQueue存储的元素要求必须是可比较的对象， 如果不是就必须明确指定比较器
 *
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        //通过改造器指定排序规则
        PriorityQueue<Student> q = new PriorityQueue<Student>(new Comparator<Student>() {
            public int compare(Student o1, Student o2) {
                //按照分数低到高，分数相等按名字
                if(o1.getScore() == o2.getScore()){
                    return o1.getName().compareTo(o2.getName());
                }
                return o1.getScore() - o2.getScore();
            }
        });
        //入列
        q.offer(new Student("dafei", 20));
        q.offer(new Student("will", 17));
        q.offer(new Student("setf", 30));
        q.offer(new Student("bunny", 20));

        //出列
        System.out.println(q.poll());  //Student{name='will', score=17}
        System.out.println(q.poll());  //Student{name='bunny', score=20}
        System.out.println(q.poll());  //Student{name='dafei', score=20}
        System.out.println(q.poll());  //Student{name='setf', score=30}
    }
}

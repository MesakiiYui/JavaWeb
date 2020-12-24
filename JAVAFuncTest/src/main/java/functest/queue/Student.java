package functest.queue;

/**
 * @Author: jintienan
 * @Date: 2020/11/18 9:36
 */
import lombok.Getter;
import lombok.Setter;

public class Student {
    @Getter @Setter String name;
    @Getter @Setter int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}


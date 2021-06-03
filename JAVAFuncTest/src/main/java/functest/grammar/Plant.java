package functest.grammar;

/**
 * @Author: jintienan
 * @Date: 2021/4/26 10:01
 */
public interface Plant {
    default void move(){
        System.out.println("plant can not move!");
    }
}

package functest.grammar;


/**
 * @Author: jintienan
 * @Date: 2021/4/26 9:59
 */
public interface Animal {

    /**
     * 1.8新特性
     */
    default void bark(){
        System.out.println("animal bark 0");
    }
}

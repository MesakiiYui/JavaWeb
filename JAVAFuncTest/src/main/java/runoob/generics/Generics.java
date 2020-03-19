package runoob.generics;

import java.util.List;

// 泛型
public class Generics {
    // 泛型方法 printArray
    // 所有泛型方法声明都有一个类型参数声明部分（由尖括号分隔），该类型参数声明部分在方法返回类型之前（在下面例子中的<E>）。
    // 类型参数能被用来声明返回值类型，并且能作为泛型方法得到的实际参数类型的占位符。
    public static < E > void printArray( E[] inputArray )
    {
        // 输出数组元素
        for ( E element : inputArray ){
            System.out.printf( "%s ", element );
        }
        System.out.println();
    }
    // 每一个类型参数声明部分包含一个或多个类型参数，参数间用逗号隔开。
    // 一个泛型参数，也被称为一个类型变量，是用于指定一个泛型类型名称的标识符。
    public static <E, V> void printTwoArray(E[] arr1, V[] arr2) {
        for(E ele : arr1) {
            System.out.printf( "%s ", ele);
        }
        for(V ele2 : arr2){
            System.out.printf( "%s ", ele2);
        }

        System.out.println();
    }

    // 下面创建一个原始的处理整形数组的方法，与上面的printArray进行对比
    public static void printIntArray(Integer[] inputArray) {
        for(Integer element : inputArray) {
            System.out.printf( "%s ", element );
        }
        System.out.println();
    }



//    可能有时候，你会想限制那些被允许传递到一个类型参数的类型种类范围。
//    例如，一个操作数字的方法可能只希望接受Number或者Number子类的实例。这就是有界类型参数的目的。
//    要声明一个有界的类型参数，首先列出类型参数的名称，后跟extends关键字，最后紧跟它的上界。
    // 比较三个值并返回最大值
//    下面的例子演示了"extends"如何使用在一般意义上的意思"extends"（类）或者"implements"（接口）。
//    该例子中的泛型方法返回三个可比较对象的最大值。
    public static <T extends Comparable<T>> T maximum(T x, T y, T z)
    {
        T max = x; // 假设x是初始最大值
        if ( y.compareTo( max ) > 0 ){
            max = y; //y 更大
        }
        if ( z.compareTo( max ) > 0 ){
            max = z; // 现在 z 更大
        }
        return max; // 返回最大对象
    }

    // 类型通配符一般是使用?代替具体的类型参数。例如 List<?> 在逻辑上是List<String>,List<Integer> 等所有List<具体类型实参>的父类。
    public static void getData(List<?> data) {
        System.out.println("data :" + data.get(0));
    }
    // 类型通配符上限通过形如List来定义，如此定义就是通配符泛型值接受Number及其下层子类类型。
    public static void getUperNumber(List<? extends Number> data) {
        System.out.println("data :" + data.get(0));
    }

    public static void main( String args[] )
    {
        // 创建不同类型数组： Integer, Double 和 Character
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        int[] intArray2 = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

        System.out.println( "整型数组元素为:" );
        printArray( intArray  ); // 传递一个整型数组
        // 泛型方法体的声明和其他方法一样。注意类型参数只能代表引用型类型，不能是原始类型（像int,double,char的等）。
        // printArray( intArray2  ); // 传递一个整型数组  -> 这个就会报错
        printTwoArray(intArray, charArray);
        System.out.println( "整型数组元素为, 利用printIntArray()方法:" );
        printIntArray(intArray); // 传递一个整型数组

        System.out.println( "\n双精度型数组元素为:" );
        printArray( doubleArray ); // 传递一个双精度型数组

        System.out.println( "\n字符型数组元素为:" );
        printArray( charArray ); // 传递一个字符型数组
    }
}

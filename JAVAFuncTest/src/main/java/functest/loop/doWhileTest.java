package functest.loop;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: jintienan
 * @Date: 2020/12/11 16:19
 * Do-while语句先执行循环体，然后判断循环条件是否成立，因此总是执行它的循环体至少一次。
 */
@Slf4j
public class doWhileTest {
     static void whileBehind(){
        int n=1;
        int a=0;
        while(n<=11)
        {
            n++;
            if(n%2==0)
            {
                a++;

            }
        }
        System.out.println(a);

        int b=1;
        int m=0;
        do {
            if(b%2==0)
            {

                m++;
            }
            b++;
        }while(b<=11);           //do....while;    while 后面一定记得加;
        System.out.println(m);

    }

    public static void main(String[] args){
        whileBehind();

    }
}

package functest.binary;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: jintienan
 * @Date: 2021/5/7 14:53
 */
@Slf4j
public class BinaryOperate {

    public static void main(String[] args) {
        moveOperate();
        orOperate();
    }

    public static void moveOperate(){
        int a = 2 << 3;
        // 2 = 0000 0010
        // << 3
        // = 0001 0000 = 2^4 = 16
        log.info(a + "");
    }

    // noFlgMove
    // 无符号右移
    public static void orOperate(){
        int x = 9;// 0000 1001 -> 0000 0100 = 4
        int mid = x >>> 1;
        log.info("mid:" + mid );
    }
}

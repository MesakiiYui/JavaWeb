package functest.NotNullCheck;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: jintienan
 * @Date: 2020/12/14 9:19
 * 当一个实体类为null 的时候，判空时company == null不会报空指针，它和null == company是一样的
 */
@Slf4j
public class NullCheck {
    public static void main(String[] args){
        Company company = null;
        if(company == null){
            log.warn("object first functional!");
        }
    }
}

package functest.jsonParser;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: jintienan
 * @Date: 2021/6/1 11:00
 */
@Data
public class ApiResponse<T> implements Serializable {

    private static final long serialVersionUID = -1920642406174619407L;

    public static final String RESULT_CODE_SUCCESS = "0100000";

    private String resultCode;

    private T resultDesc;

    private T resultDatas;
}

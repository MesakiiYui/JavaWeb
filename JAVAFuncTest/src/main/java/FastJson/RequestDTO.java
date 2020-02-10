package FastJson;

public final class RequestDTO<T extends BaseDTO> extends BaseDTO {

    private static final long serialVersionUID = -2780042604928728379L;

    /**
     * 调用方的名称
     */
    private String            caller;

    /**
     * 请求参数
     */
    private T                 param;



    public String getCaller() {
        return caller;
    }

    public void setCaller(String caller) {
        this.caller = caller;
    }

    /**
     * 获取请求参数
     */
    public T getParam() {
        return param;
    }

    /**
     * 设置请求参数
     *
     * @param param 请求参数
     */
    public void setParam(T param) {
        this.param = param;
    }

}
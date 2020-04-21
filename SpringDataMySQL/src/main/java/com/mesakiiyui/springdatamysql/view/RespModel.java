package com.mesakiiyui.springdatamysql.view;
import java.util.HashMap;
import java.util.Map;
/**
 * 来自P17项目
 */

import org.springframework.web.servlet.ModelAndView;

public class RespModel<T> {
    private long timestamp = System.currentTimeMillis();
    private boolean success = true;
    private String errCode;
    private String errMsg;
    private T content;
    private Map<String, String> validateErrs;
    private Map<String, Object> additionals;

    public RespModel() {

    }

    public RespModel(String errCode, String errMsg) {
        this.success = false;
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public RespModel(T object) {
        if (object != null) {
            this.success = true;
            this.content = object;
        }
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public Map<String, Object> getAdditionals() {
        return additionals;
    }

    public void setAdditionals(Map<String, Object> additional) {
        this.additionals = additional;
    }

    public void addAdditional(String key, Object value) {
        if (this.additionals == null) {
            this.additionals = new HashMap<String, Object>();
        }
        this.additionals.put(key, value);
    }

    public Map<String, String> getValidateErrs() {
        return validateErrs;
    }

    public void setValidateErrs(Map<String, String> validateErrs) {
        this.validateErrs = validateErrs;
    }

    public ModelAndView toModelAndView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("timestamp", timestamp);
        modelAndView.addObject("success", success);
        modelAndView.addObject("errCode", errCode);
        modelAndView.addObject("errMsg", errMsg);
        modelAndView.addObject("content", content);
        modelAndView.addObject("validateErrs", validateErrs);
        modelAndView.addObject("additionals", additionals);
        return modelAndView;
    }
}


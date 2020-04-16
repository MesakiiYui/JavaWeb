package com.mesakiiyui.springdatamysql.controller;

import com.mesakiiyui.springdatamysql.common.enums.ResultStatusCode;
import com.mesakiiyui.springdatamysql.common.vo.Result;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 类描述: 主要是解决未被全局异常处理的错误
 * 如果设置资源映射文件不存在：spring.resources.add-mappings 会导致swagger druid等web页面不能访问
 */
@RestController
@Slf4j
@Api(tags="错误接口")
public class FinalExceptionHandlerController implements ErrorController {
    @Override
    public String getErrorPath() {
        return "/error";
    }

    @GetMapping(value = "/error")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Object error(HttpServletRequest request, HttpServletResponse response) {

        log.error("response error,httpCode:" + response.getStatus());
        // 错误处理逻辑
        int status = response.getStatus();
        if (status == 404) {
            return new Result(ResultStatusCode.REQUEST_NOT_FOUND, "访问地址不存在！(*^▽^*)");
        } else if (status == 500) {
            return new Result(ResultStatusCode.SYSTEM_ERR, "服务器运行异常！(*^▽^*)");
        } else if (status >= 100 && status < 200) {
            return new Result(ResultStatusCode.HTTP_ERROR_100, null);
        } else if (status >= 300 && status < 400) {
            return new Result(ResultStatusCode.HTTP_ERROR_300, null);
        } else if (status >= 400 && status < 500) {
            return new Result(ResultStatusCode.HTTP_ERROR_400, null);
        } else {
            return new Result(ResultStatusCode.SYSTEM_ERR, "服务器运行异常！(*^▽^*)");
        }


    }
}

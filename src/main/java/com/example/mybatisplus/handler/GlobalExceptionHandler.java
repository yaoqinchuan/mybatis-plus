package  com.example.mybatisplus.handler;

import com.example.mybatisplus.common.CommonResult;
import  com.example.mybatisplus.exceptions.IllegalParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalParameterException.class)
    public CommonResult<String> handlerRuntimeException(IllegalParameterException e) {
        return CommonResult.failed(e.getMessage(), e.getCode());
    }

    @ExceptionHandler(Exception.class)
    public CommonResult<String> handlerRuntimeException(Exception e) {
        return CommonResult.failed(e.getMessage());
    }
}

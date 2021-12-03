package cn.ctyun.data.application.service.exception;

/**
 * @ClassName : BadRequestParamException  //类名
 * @Description :   //描述
 * @Param :   //参数
 * @return:
 * @Author : lenovo //作者
 * @Date: 2021/11/30  16:09
 */
public class BadRequestParamException extends RuntimeException {

    public BadRequestParamException(String message) {
        super(message);
    }
}

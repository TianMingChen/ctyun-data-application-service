package cn.ctyun.data.application.service.exception;

/**
 * @ClassName : CustomMinioException  //类名
 * @Description :   //描述
 * @Param :   //参数
 * @return:
 * @Author : lenovo //作者
 * @Date: 2021/12/1  9:24
 */

public class CustomMinioException extends RuntimeException {
    public CustomMinioException(String message) {
        super(message);
    }
}

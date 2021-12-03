package cn.ctyun.data.application.service.web.params;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashMap;

/**
 * @ClassName : TestModelParam  //类名
 * @Description :   //描述
 * @Param :   //参数
 * @return:
 * @Author : lenovo //作者
 * @Date: 2021/12/3  13:57
 */
@Data
public class TestModelParam {
    @NotBlank
    private String testDatabase;

    @NotNull
    private HashMap<String, String> columnFieldMap;

    @NotBlank
    private String modelFile;

}


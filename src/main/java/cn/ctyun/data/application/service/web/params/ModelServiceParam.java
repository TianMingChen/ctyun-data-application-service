package cn.ctyun.data.application.service.web.params;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashMap;

/**
 * @ClassName : ModelServiceParam  //类名
 * @Description :   //描述
 * @Param :   //参数
 * @return:
 * @Author : lenovo //作者
 * @Date: 2021/12/1  10:36
 */

@Data
public class ModelServiceParam {
    @NotBlank
    private String objName;

    @NotNull
    private HashMap<String, String> columnFieldMap;

    @NotBlank
    private String idColumnName;

    @NotBlank
    private String modelFileObjectKey;

    @NotNull
    private HashMap<String, String> params;




}


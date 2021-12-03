package cn.ctyun.data.application.service.service;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @ClassName : CSVInfo  //类名
 * @Description :   //描述
 * @Param :   //参数
 * @return:
 * @Author : lenovo //作者
 * @Date: 2021/12/1  9:25
 */

@Data
public class CSVInfo {
    private Long columnSize;
    private Long rowSize;
    private List<String> headerNames;
    private Map<String, List<String>> header;
}
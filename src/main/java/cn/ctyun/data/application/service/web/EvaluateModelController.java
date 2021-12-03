package cn.ctyun.data.application.service.web;

import cn.ctyun.data.application.service.exception.BadRequestParamException;
import cn.ctyun.data.application.service.exception.Resp;
import cn.ctyun.data.application.service.service.MinService;
import cn.ctyun.data.application.service.service.ModelSnapshot;
import cn.ctyun.data.application.service.service.ServingService;
import cn.ctyun.data.application.service.web.params.ModelServiceParam;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @ClassName : ModelController  //类名
 * @Description :   //描述
 * @Param :   //参数
 * @return:
 * @Author : lenovo //作者
 * @Date: 2021/11/30  15:52
 */
@RestController
public class EvaluateModelController {
//    @Autowired
//    private MinService minService;
//    @Autowired
//    private ServingService servingService;
//
//    @PostMapping("/{id}/serving")
//    public ResponseEntity<?> servingFoo(@PathVariable String id,
//                                        @RequestParam(name = "query") String q,
//                                        //@RequestBody HashMap<String, Object> params,
//                                        @Valid @RequestBody ModelServiceParam param) {
//        //Api2Resource resource = api2ResourceRepository.findById(id)
//        //        .orElseThrow(() -> new BadRequestParamException("没有找到对应的API2资产"));
//
//        // String objName = resource.getDataResource().getObjectName();
//        String objName = param.getObjName();
//        //HashMap<String, String> columnFieldMap = resource.getColumnFieldMap();
//        HashMap<String, String> columnFieldMap = param.getColumnFieldMap();
//        List<String> columnNames = new ArrayList<>(columnFieldMap.keySet());
//        //String idColumnName = resource.getIdColumnName();
//        String idColumnName = param.getIdColumnName();
//        List<CSVRecord> csvRecords = minService.queryObjectByWhere(objName, columnNames, idColumnName, q);
//
//        CSVRecord record = csvRecords.stream().findFirst()
//                .orElseThrow(() -> new BadRequestParamException("没有找到任何数据"));
//        List<String> recordValues = record.toList();
//        Map<String, String> values = IntStream.range(0, recordValues.size()).boxed()
//                .collect(Collectors.toMap(columnNames::get, recordValues::get));
//
//        Map<String, Object> input = new HashMap<>();
//        for (Map.Entry<String, String> entry : columnFieldMap.entrySet()) {
//            String field = entry.getValue();
//
//            String value = values.get(entry.getKey());
//            if (value != null) {
//                input.put(field, value);
//                continue;
//            }
//            //Object value2 = params.get(entry.getKey());
//            Object value2 = param.getParams().get(entry.getKey());
//            if (value2 != null) {
//                input.put(field, value2);
//                continue;
//            }
//
//            throw new BadRequestParamException(String.format("缺少参数[%s]", field));
//        }
//        ModelSnapshot modelSnapshot = new ModelSnapshot();
//        modelSnapshot.setModelFileObjectKey(param.getModelFileObjectKey());
//        //Map<String, ?> result = servingService.evaluateBy(resource.getModel(), input);
//        Map<String, ?> result = servingService.evaluateBy(modelSnapshot, input);
//
//        return Resp.ok(result);
//    }

}

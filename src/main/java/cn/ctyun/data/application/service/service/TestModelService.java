package cn.ctyun.data.application.service.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.dmg.pmml.FieldName;
import org.jpmml.evaluator.*;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @ClassName : TestModelService  //类名
 * @Description :   //描述
 * @Param :   //参数
 * @return:
 * @Author : lenovo //作者
 * @Date: 2021/12/3  14:03
 */
@Service
public class TestModelService {
    public String test(String csvFile, String pathxml, HashMap<String, String> columnFieldMap) {
        String str="";
        File file = new File(pathxml);
        List<String> columnNames = new ArrayList<>(columnFieldMap.keySet());
        try {
            //解析CSV测试集
            Reader reader = new FileReader(csvFile);
            CSVParser parser = CSVFormat.EXCEL.withHeader().parse(reader);
            //CSVParser parser = CSVFormat.EXCEL.withHeader("x1", "x2", "x3","x4").parse(reader);
            //CSVParser parser = CSVFormat.EXCEL.parse(reader);
            //加载模型
            Evaluator evaluator = new LoadingModelEvaluatorBuilder()
                    .load(file)
                    .build();
            //columnFieldMap "模型里的head列名":"测试集的head列名"
            //对齐列名
            for (CSVRecord record : parser.getRecords()) {
                System.out.println(record);
                Map<String, Float> data = new HashMap<String, Float>();
                for (Map.Entry<String, String> entry : columnFieldMap.entrySet()) {
                    data.put(entry.getKey(), Float.valueOf(record.get(entry.getValue())));
                }
                List<InputField> inputFields = evaluator.getInputFields();
                //构造模型输入
                Map<FieldName, FieldValue> arguments = new LinkedHashMap<FieldName, FieldValue>();
                for (InputField inputField : inputFields) {
                    FieldName inputFieldName = inputField.getName();
                    Object rawValue = data.get(inputFieldName.getValue());
                    FieldValue inputFieldValue = inputField.prepare(rawValue);
                    arguments.put(inputFieldName, inputFieldValue);
                }

                Map<FieldName, ?> results = evaluator.evaluate(arguments);
                List<TargetField> targetFields = evaluator.getTargetFields();

                TargetField targetField = targetFields.get(0);
                FieldName targetFieldName = targetField.getName();

                Object targetFieldValue = results.get(targetFieldName);
                System.out.println("target: " + targetFieldName.getValue() + " value: " + targetFieldValue);
                int primitiveValue = -1;
                if (targetFieldValue instanceof Computable) {
                    Computable computable = (Computable) targetFieldValue;
                    primitiveValue = (Integer) computable.getResult();
                }
                str=str+"预测结果:"+String.valueOf(primitiveValue)+";";
            }
            parser.close();
        } catch (Exception e) {

        }
        return str;
    }
}

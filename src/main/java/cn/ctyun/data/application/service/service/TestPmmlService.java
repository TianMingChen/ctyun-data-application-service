package cn.ctyun.data.application.service.service;


import org.dmg.pmml.FieldName;
import org.dmg.pmml.PMML;
import org.jpmml.evaluator.*;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName : TestPmmlService  //类名
 * @Description :   //描述
 * @Param :   //参数
 * @return:
 * @Author : lenovo //作者
 * @Date: 2021/12/2  10:18
 */
@Service
public class TestPmmlService {
    public void predictLrHeart(Map<String, Double> irismap, String pathxml) throws Exception {
        PMML pmml;
        File file = new File(pathxml);
        InputStream inputStream = new FileInputStream(file);
        try (InputStream is = inputStream) {
            //pmml = org.jpmml.model.PMMLUtil.unmarshal(is);
            Evaluator evaluator = new LoadingModelEvaluatorBuilder()
                    .load(file)
                    .build();

//            ModelEvaluatorFactory modelEvaluatorFactory = ModelEvaluatorFactory.newInstance();
//            ModelEvaluator<?> modelEvaluator = modelEvaluatorFactory.newModelEvaluator(pmml);
//            Evaluator evaluator = (Evaluator) modelEvaluator;

            List<InputField> inputFields = evaluator.getInputFields();
            Map<FieldName, FieldValue> argements = new LinkedHashMap<>();
            for (InputField inputField : inputFields) {
                FieldName inputFieldName = inputField.getName();
                Object raeValue = irismap.get(inputFieldName.getValue());
                FieldValue inputFieldValue = inputField.prepare(raeValue);
                argements.put(inputFieldName, inputFieldValue);
            }
            Map<FieldName, ?> results = evaluator.evaluate(argements);
            List<TargetField> targetFields = evaluator.getTargetFields();
            for (TargetField targetField : targetFields) {
                FieldName targetFieldName = targetField.getName();
                Object targetFieldValue = results.get(targetFieldName);
//                System.out.println("target: " + targetFieldName.getValue());
                System.out.println(targetFieldValue);
            }
        }
    }

    public int predict(String pathxml , float a, float b, float c, float d) {
        File file = new File(pathxml);
        String csvFile = "D:/BaiduNetdiskDownload/iris3.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                if(country[0].equals("x1")){
                    continue;
                }
                a=Float.valueOf(country[0]);
                b=Float.valueOf(country[1]);
                c=Float.valueOf(country[2]);
                d=Float.valueOf(country[3]);
                try {
                    Evaluator evaluator = new LoadingModelEvaluatorBuilder()
                            .load(file)
                            .build();
                    //输入特征赋值,iris数据类型是4维,数据维度顺序不能乱
                    Map<String, Float> data = new HashMap<String, Float>();
                    data.put("x1", a);
                    data.put("x2", b);
                    data.put("x3", c);
                    data.put("x4", d);
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
        System.out.println(a + " " + b + " " + c + " " + d + ":" + primitiveValue);
                    //return primitiveValue;
                }catch (Exception e){
                    System.out.println("异常");
                }

                //System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");

            }

        } catch (IOException e) {
            System.out.println("异常2");
            e.printStackTrace();
        }


        return 999;
    }

}

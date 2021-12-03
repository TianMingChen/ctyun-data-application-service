package cn.ctyun.data.application.service.service;

/**
 * @ClassName : ServingService  //类名
 * @Description :   //描述
 * @Param :   //参数
 * @return:
 * @Author : lenovo //作者
 * @Date: 2021/12/1  9:28
 */
import cn.ctyun.data.application.service.exception.BadRequestParamException;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.dmg.pmml.DataType;
import org.dmg.pmml.FieldName;
import org.jpmml.evaluator.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.ExecutionException;

@Service
public class ServingService {
//    public static final Logger log = LoggerFactory.getLogger(ServingService.class);
//    public static final EnumSet numberSet = EnumSet.of(DataType.DOUBLE, DataType.FLOAT);
//    private LoadingCache<ModelSnapshot, Evaluator> evaluatorCache;
//
//    @Autowired
//    private MinService minService;
//    @Autowired
//    private LoadingModelEvaluatorBuilder loadingModelEvaluatorBuilder;
//
//    public ServingService() {
//        evaluatorCache = CacheBuilder.newBuilder().build(loader());
//    }
//
//    public Map<String, ?> evaluateBy(ModelSnapshot modelSnapshot, Map<String, Object> args) {
//        Evaluator evaluator = null;
//        try {
//            evaluator = evaluatorCache.get(modelSnapshot);
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//
//        List<? extends InputField> inputFields = evaluator.getInputFields();
//        Map<FieldName, FieldValue> arguments = new HashMap<>();
//        for (InputField inputField : inputFields) {
//            FieldName inputName = inputField.getName();
//
//            Object value = args.get(inputName.getValue());
//            if (value == null) {
//                throw new BadRequestParamException("need input field [" + inputField.getName() + "]");
//            }
//
//            FieldValue inputValue = inputField.prepare(value);
//            arguments.put(inputName, inputValue);
//        }
//        Map<FieldName, ?> results = evaluator.evaluate(arguments);
//
//        return EvaluatorUtil.decodeAll(results);
//    }
//
//    public Evaluator loadModelEvaluator(String modelObjectKey) throws IOException, JAXBException, SAXException {
//        EvaluatorBuilder evaluatorBuilder;
//
//        try (InputStream input = minService.getObject(modelObjectKey)) {
//            evaluatorBuilder = loadingModelEvaluatorBuilder.clone().load(input);
//        }
//
//        Evaluator evaluator = evaluatorBuilder.build();
//        evaluator.verify();
//
//        return evaluator;
//    }
//
//    private CacheLoader<ModelSnapshot, Evaluator> loader() {
//        return new CacheLoader<ModelSnapshot, Evaluator>() {
//            @Override
//            public Evaluator load(ModelSnapshot snapshot) throws Exception {
//                return loadModelEvaluator(snapshot.getModelFileObjectKey());
//            }
//        };
//    }
}


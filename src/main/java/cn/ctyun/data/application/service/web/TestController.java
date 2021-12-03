package cn.ctyun.data.application.service.web;

import cn.ctyun.data.application.service.exception.Resp;
import cn.ctyun.data.application.service.service.MinioTestService;
import cn.ctyun.data.application.service.service.TestPmmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : TestController  //类名
 * @Description :   //描述
 * @Param :   //参数
 * @return:
 * @Author : lenovo //作者
 * @Date: 2021/11/30  11:07
 */
@RestController
public class TestController {
    @Autowired
    private TestPmmlService testPmmlService;

    @Autowired
    private MinioTestService minioTestService;

    @GetMapping("/test/get")
    public ResponseEntity<?> getPoint() {
        return Resp.ok("测试信息");
    }

    @GetMapping("/test/getiris")
    public ResponseEntity<?> getIris() {
        //String pathxml = System.getProperty("user.dir") + "/model/xgboost.pmml";
        String pathxml = "iris.pmml";
        //传入模型特征数据
        Map<String, Double> map = new HashMap<String, Double>();
        map.put("x1", 5.1);
        map.put("x2", 3.5);
        map.put("x3", 0.4);
        map.put("x4", 0.2);
        //模型预测
        try {
            testPmmlService.predictLrHeart(map, pathxml);
        } catch (Exception e) {

        }

        return Resp.ok("测试信息");
    }

    @GetMapping("/test/getiris2")
    public ResponseEntity<?> getIris2() {
        //String pathxml = "iris.pmml";
        String pathxml = "D:/pml/85af2371-98d5-4317-bffb-500e06864579.pmml";
        int res=9999;
        //模型预测
        try {
            res=testPmmlService.predict(pathxml,5.1f,3.5f,1.4f, 0.2f);
            System.out.println(res);
        } catch (Exception e) {

        }

        return Resp.ok("测试信息"+res);
    }
    @GetMapping("/test/minio")
    public ResponseEntity<?> getMinio() {
        //String fileName="pmml/0c0b556d20e7482ab95d031215256f83.pmml";
        String fileName="pml/85af2371-98d5-4317-bffb-500e06864579.pmml";
        minioTestService.downloadMinio(fileName);
        return Resp.ok("测试信息");
    }
    @GetMapping("/test/uploadminio")
    public ResponseEntity<?> UploadMinio() {
        String str=minioTestService.uploadFileMinio();
        return Resp.ok("测试信息"+str);
    }

}

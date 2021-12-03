package cn.ctyun.data.application.service.web;

import cn.ctyun.data.application.service.exception.Resp;
import cn.ctyun.data.application.service.service.TestModelService;
import cn.ctyun.data.application.service.web.params.ModelServiceParam;
import cn.ctyun.data.application.service.web.params.TestModelParam;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @ClassName : TestModelContrller  //类名
 * @Description :   //描述
 * @Param :   //参数
 * @return:
 * @Author : lenovo //作者
 * @Date: 2021/12/3  13:54
 */
@RestController
public class TestModelContrller {
    @Autowired
    private TestModelService testModelService;
    @PostMapping("/testmodel/test")
    public ResponseEntity<?> testModel(@RequestBody TestModelParam param) {
        String csvFile = param.getTestDatabase();
        String modelPmml=param.getModelFile();
        String res=testModelService.test(csvFile,modelPmml,param.getColumnFieldMap());
        return Resp.ok(res);

    }

}

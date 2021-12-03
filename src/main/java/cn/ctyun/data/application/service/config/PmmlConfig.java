package cn.ctyun.data.application.service.config;

import org.jpmml.evaluator.LoadingModelEvaluatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName : PmmlConfig  //类名
 * @Description :   //描述
 * @Param :   //参数
 * @return:
 * @Author : lenovo //作者
 * @Date: 2021/12/1  9:41
 */

@Configuration
public class PmmlConfig {

    @Bean
    public LoadingModelEvaluatorBuilder loadingModelEvaluatorBuilder() {
        return new LoadingModelEvaluatorBuilder();
    }
}

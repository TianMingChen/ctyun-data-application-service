package cn.ctyun.data.application.service.config;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName : MinioConfig  //类名
 * @Description :   //描述
 * @Param :   //参数
 * @return:
 * @Author : lenovo //作者
 * @Date: 2021/12/1  9:26
 */
@Configuration
public class MinioConfig {
    @Value("${minio.url}")
    private String endpoint;
    @Value("${minio.access_key}")
    private String accessKey;
    @Value("${minio.secret_key}")
    private String secretKey;

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKey, secretKey)
                .build();
    }
}


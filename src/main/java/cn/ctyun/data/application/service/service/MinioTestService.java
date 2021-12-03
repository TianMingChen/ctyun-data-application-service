package cn.ctyun.data.application.service.service;

import org.springframework.stereotype.Service;
import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
/**
 * @ClassName : MinioTestService  //类名
 * @Description :   //描述
 * @Param :   //参数
 * @return:
 * @Author : lenovo //作者
 * @Date: 2021/12/2  14:02
 */
@Service
public class MinioTestService {
    private final static Logger logger = LoggerFactory.getLogger(MinioTestService.class);
    private static String url = "https://minio-dataex.ctcdn.cn";
    private static String access = "ZQcWdUnaTHHQ3V3b";
    private static String secret = "913Jwhuyi9yWEecvpGLppKm2EMP##TB6";
    private static String bucket = "uploads";

    public void downloadMinio(String fileName) {
        try {
            //创建MinioClient对象
            MinioClient minioClient =
                    MinioClient.builder()
                            .endpoint(url)
                            .credentials(access, secret)
                            .build();
            InputStream stream = minioClient.getObject(GetObjectArgs.builder().bucket(bucket).object(fileName).build());
            byte[] buf = new byte[1024];
            int bytesRead;
            File file =new File("D:/"+fileName);

            //if file doesnt exists, then create it
            if(!file.exists()){
                file.createNewFile();
            }

            //true = append file
            FileWriter fileWritter = new FileWriter(file.getAbsoluteFile(),true);
           // FileWriter fileWritter = new FileWriter(file.getName(),true);

            while ((bytesRead = stream.read(buf, 0, buf.length)) >= 0) {
                String str=new String(buf, 0, bytesRead, StandardCharsets.UTF_8);
                System.out.println(new String(buf, 0, bytesRead, StandardCharsets.UTF_8));
                fileWritter.write(str);

            }
            fileWritter.close();
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
        }
    }

    public String uploadFileMinio(){
        try {
            //创建MinioClient对象
            MinioClient minioClient =
                    MinioClient.builder()
                            .endpoint(url)
                            .credentials(access, secret)
                            .build();
            File file = new File("D:/BaiduNetdiskDownload/iris.pmml");
            //File file = new File("C:/Users/yiran/Desktop/minio.txt");
            InputStream in = new FileInputStream(file);
            String fileName = file.getName();
            //文件上传到minio上的Name把文件后缀带上，不然下载出现格式问题
            fileName = "pml/"+UUID.randomUUID()+"."+fileName.substring(fileName.lastIndexOf(".") + 1);

            //创建头部信息
            Map<String, String> headers = new HashMap<>(1<<2);
            //添加自定义内容类型
            headers.put("Content-Type", "application/octet-stream");
            //添加存储类
            headers.put("X-Amz-Storage-Class", "REDUCED_REDUNDANCY");
            //添加自定义/用户元数据
            Map<String, String> userMetadata = new HashMap<>(1<<2);
            userMetadata.put("My-Project", "Project One");
            //上传
            minioClient.putObject(
                    PutObjectArgs.builder().bucket(bucket).object(fileName).stream(
                                    in, in.available(), -1)
                            .headers(headers)
                            .userMetadata(userMetadata)
                            .build());
            in.close();
            return fileName;
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }
}

package cn.ctyun.data.application.service.service;

/**
 * @ClassName : MinService  //类名
 * @Description :   //描述
 * @Param :   //参数
 * @return:
 * @Author : lenovo //作者
 * @Date: 2021/12/1  9:21
 */

import cn.ctyun.data.application.service.exception.CustomMinioException;
import io.minio.*;
import io.minio.errors.*;
import io.minio.http.Method;
import io.minio.messages.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Service
public class MinService {
//    public static final Logger log = LoggerFactory.getLogger(MinService.class);
//
//    @Autowired
//    private MinioClient mc;
//    @Value("${minio.bucket}")
//    private String bucket;
//    @Autowired
//    private CSVFormat csvFormat;
//
//    @Value("${minio.access_key}")
//    private String accessKey;
//
//    @Value("${minio.secret_key}")
//    private String secretKey;
//
//    @Value("${minio.download.url}")
//    private String downloadEndpoint;
//
//    private MinioClient mcd;
//
//    @PostConstruct
//    public void init() {
//
//        mcd = MinioClient.builder()
//                .endpoint(downloadEndpoint)
//                .credentials(accessKey, secretKey)
//                .build();
//
//    }
//
//    public InputStream getObject(String objectName) {
//        try {
//            return mc.getObject(GetObjectArgs.builder()
//                    .bucket(bucket)
//                    .object(objectName)
//                    .build());
//        } catch (ErrorResponseException | InsufficientDataException
//                | InternalException | InvalidKeyException
//                | InvalidResponseException | IOException
//                | NoSuchAlgorithmException | ServerException | XmlParserException e) {
//            log.error("get object failed", e);
//            throw new CustomMinioException(e.getMessage());
//        }
//    }
//
//    private String genSqlColumnsStr(Iterable<String> columnNames) {
//        return StreamSupport.stream(columnNames.spliterator(), false)
//                .map(s -> String.format("\"%s\"", s))
//                .collect(Collectors.joining(","));
//    }
//
//
//    public List<CSVRecord> queryObjectByWhere(String objName, Iterable<String> columnNames, String queryKey, String queryValue) {
//        String columnsStr = genSqlColumnsStr(columnNames);
//        String sql = String.format("SELECT %s FROM S3Object s WHERE s.\"%s\"='%s'",
//                columnsStr,
//                queryKey, queryValue);
//
//        return selectObjectBySql2(objName, sql);
//    }
//
//    public List<CSVRecord> selectObjectBySql2(String objName, String sql) {
//        log.info("query object[{}] by sql: ({})", objName, sql);
//        try {
//            return selectObjectBySql(objName, sql);
//        } catch (IOException | InvalidKeyException | InvalidResponseException | InsufficientDataException |
//                NoSuchAlgorithmException | ServerException | InternalException | XmlParserException |
//                ErrorResponseException e) {
//            log.error("query object header failed ", e);
//            throw new CustomMinioException(e.getMessage());
//        }
//    }
//
//    private List<CSVRecord> selectObjectBySql(String objName, String sql) throws IOException, InvalidKeyException,
//            InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException,
//            ServerException, InternalException, XmlParserException, ErrorResponseException {
//        log.debug("query object[{}] by sql: {}", objName, sql);
//        InputSerialization is = new InputSerialization(null, false,
//                null, null, FileHeaderInfo.USE, null, null, null);
//        OutputSerialization os = new OutputSerialization(null, null, null,
//                QuoteFields.ASNEEDED, null);
//
//        Iterable<Result<Item>> items = mc.listObjects(ListObjectsArgs.builder()
//                .bucket(bucket)
//                .prefix(objName)
//                .recursive(true)
//                .maxKeys(10)
//                .build());
//
//        Set<String> objNames = new HashSet<>();
//        for (Result<Item> item : items) {
//            objNames.add(item.get().objectName());
//        }
//
//        List<CSVRecord> result = new ArrayList<>();
//        for (String itemObjName : objNames) {
//            log.debug("query item obj_name: {}", itemObjName);
//            try (InputStreamReader reader = new InputStreamReader(mc.selectObjectContent(
//                    SelectObjectContentArgs.builder()
//                            .bucket(bucket)
//                            .object(itemObjName)
//                            .sqlExpression(sql)
//                            .inputSerialization(is)
//                            .outputSerialization(os)
//                            .requestProgress(false)
//                            .build()))) {
//                CSVParser parser = csvFormat.parse(reader);
//                result.addAll(parser.getRecords());
//            }
//        }
//
//        return result;
//    }
//
//    @Bean
//    public CSVFormat csvFormat() {
//        return CSVFormat.DEFAULT;
//    }
}
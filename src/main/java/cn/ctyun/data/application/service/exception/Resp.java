package cn.ctyun.data.application.service.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
/**
 * @ClassName : Resp  //类名
 * @Description :   //描述
 * @Param :   //参数
 * @return:
 * @Author : lenovo //作者
 * @Date: 2021/11/30  11:09
 */


@Data
public class Resp<T> {
    private Integer code;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String errorMsg;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Paging paging;

    public Resp(Integer code, T data, String errorMsg) {
        this.code = code;
        this.data = data;
        this.errorMsg = errorMsg;
    }

    public static <U> ResponseEntity<?> ok(U data) {
        Resp<U> resp = new Resp<U>(0, data, null);

        return ResponseEntity.ok(resp);
    }

    public static <U> ResponseEntity<?> ok(Page<U> data) {
        Resp<List<U>> resp = new Resp<>(0, data.getContent(), null);

        Paging paging = new Paging(data.getTotalPages(), data.getNumber(), data.getSize(), data.getTotalElements());
        resp.setPaging(paging);

        return ResponseEntity.ok(resp);
    }

    public static <U> ResponseEntity<?> ok(U data, int total, int pageNum, int pageSize) {
        Resp<U> resp = new Resp<U>(0, data, null);
        Paging paging = new Paging(total, pageNum, pageSize);
        resp.setPaging(paging);

        return ResponseEntity.ok(resp);
    }

    public static ResponseEntity<?> ok() {
        return ok(new HashMap<String, String>());
    }

    public static <U> ResponseEntity<?> fail(Integer code, String errorMsg) {
        Resp<U> resp = new Resp<U>(code, null, errorMsg);
        return ResponseEntity.ok(resp);
    }

    @Data
    public static class Paging {
        private int total;
        private int pageNum;
        private int pageSize;
        // 总记录数
        private long totalNum;

        public Paging(int total, int pageNum, int pageSize) {
            this.total = total;
            this.pageNum = pageNum;
            this.pageSize = pageSize;
        }

        public Paging(int total, int pageNum, int pageSize, long totalNum) {
            this.total = total;
            this.pageNum = pageNum;
            this.pageSize = pageSize;
            this.totalNum = totalNum;
        }
    }
}


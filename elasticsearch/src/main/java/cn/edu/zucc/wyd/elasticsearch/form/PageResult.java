package cn.edu.zucc.wyd.elasticsearch.form;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PageResult<T> {
    private Long total;// 总条数
    private Long totalPage;// 总页数
    private List<T> items;// 当前页数据
    private int code;
    private String msg;

    public PageResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public PageResult(Long total, List<T> items) {
        this.total = total;
        this.items = items;
    }

    public PageResult(Long total, Long totalPage, List<T> items) {
        this.total = total;
        this.totalPage = totalPage;
        this.items = items;
    }

    public PageResult(Long total, Long totalPage, List<T> items, int code, String msg) {
        this.total = total;
        this.totalPage = totalPage;
        this.items = items;
        this.code = code;
        this.msg = msg;
    }
}
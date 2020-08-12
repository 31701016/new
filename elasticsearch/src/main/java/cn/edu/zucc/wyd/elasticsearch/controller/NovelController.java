package cn.edu.zucc.wyd.elasticsearch.controller;

import cn.edu.zucc.wyd.elasticsearch.form.MyResult;
import cn.edu.zucc.wyd.elasticsearch.entity.NovelEntity;
import cn.edu.zucc.wyd.elasticsearch.form.Novel;
import cn.edu.zucc.wyd.elasticsearch.repository.XcNovelsRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class NovelController {

    private final XcNovelsRepository repository;
    public NovelController(XcNovelsRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/loadnovel")
    public MyResult<NovelEntity> login(@RequestBody Novel novel){
        //查找小说详细内容
        MyResult<NovelEntity> myResult = new MyResult();
        NovelEntity entity = new NovelEntity();
        entity = repository.findByNovelid(novel.getNovelid());

        myResult.setCode(0);
        myResult.setMsg("");
        myResult.setObj(entity);
        return myResult;
    }
}

package cn.edu.zucc.wyd.elasticsearch.controller;

import cn.edu.zucc.wyd.elasticsearch.entity.CollectionEntity;
import cn.edu.zucc.wyd.elasticsearch.entity.NovelEntity;
import cn.edu.zucc.wyd.elasticsearch.form.*;
import cn.edu.zucc.wyd.elasticsearch.repository.CollectionRepository;
import cn.edu.zucc.wyd.elasticsearch.repository.XcNovelsRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class CollectionController {

    private final CollectionRepository repository;
    private final XcNovelsRepository repository1;
    public CollectionController(CollectionRepository repository, XcNovelsRepository repository1) {
        this.repository = repository;
        this.repository1 = repository1;
    }

    @PostMapping("/collect")
    public MyResult<CollectionEntity> collect(@RequestBody Collection collection){
//        收藏书籍
        MyResult<CollectionEntity> myResult = new MyResult<>();
        if(collection.getUserid() == 0){
            myResult.setCode(1);
            myResult.setMsg("请先登录！");
            return myResult;
        }
        CollectionEntity entity = new CollectionEntity();
        entity.setUserid(collection.getUserid());
        entity.setNovelid(collection.getNovelid());
        repository.save(entity);
        myResult.setCode(0);
        myResult.setMsg("收藏成功！");
        myResult.setObj(entity);
        return myResult;
    }

    @PostMapping("/loadCollections")
    public PageResult<NovelEntity> loadCollection(@RequestBody SearchRequest request){
//        显示收藏列表
        int page = request.getPage()-1;
        int size = request.getSize();

        List<CollectionEntity> collectionList = new ArrayList<>();
        collectionList = repository.findAllByUserid(request.getUserid());

        List<NovelEntity> novelList = new ArrayList<>();
        if(collectionList.size() > 0){
            for(int i = 0; i< collectionList.size(); i++){
                NovelEntity entity = repository1.findByNovelid(collectionList.get(i).getNovelid());
                novelList.add(entity);
            }
        }

        Long total = Long.valueOf(novelList.size());
        Long totalPage = Long.valueOf(novelList.size()/size)+1;
        List<NovelEntity> list = new ArrayList<>();
        for(int i = page*size; i < ((page+1)*size < novelList.size() ? (page+1)*size : novelList.size()) ; i++){
            list.add(novelList.get(i));
        }
        PageResult<NovelEntity> result = new PageResult<NovelEntity>(total, totalPage, list);
        return result;
    }

    @PostMapping("/recommendation")
    public PageResult<Recommendation> recommendation(@RequestBody SearchRequest request){
//        显示推荐列表
        int page = request.getPage()-1;
        int size = request.getSize();
        List<CollectionEntity> collectionList = new ArrayList<>();
        collectionList = repository.findAllByUserid(request.getUserid());
        if(collectionList.size() == 0){
            int code = 1;
            String msg = "您尚未收藏小说，无法为您推荐！";
            PageResult result = new PageResult(code, msg);
            return result;
        }


        List<NovelEntity> novelList = new ArrayList<>();
        List<String> novelTypeList = new ArrayList<>();
        List<Integer> valueList = new ArrayList<>();
        if(collectionList.size() > 0){
            for(int i = 0; i< collectionList.size(); i++){
                NovelEntity entity = repository1.findByNovelid(collectionList.get(i).getNovelid());
                if(novelTypeList.contains(entity.getNovelType())){
                    valueList.set(novelTypeList.indexOf(entity.getNovelType()),valueList.get(novelTypeList.indexOf(entity.getNovelType()))+1);
                }else{
                    novelTypeList.add(entity.getNovelType());
                    valueList.add(1);
                }
                novelList.add(entity);
            }
        }
        List<Recommendation> recommendationList = new ArrayList<>();
        for(int i = 0; i < novelTypeList.size(); i++){
            //System.out.println(novelTypeList.get(i)+"="+valueList.get(i));
            List<NovelEntity> entityList = repository1.findByNovelTypeOrderByNovelClickNumDesc(novelTypeList.get(i));
            int duplicate = 0;
            for(int j = 0; j < 10+duplicate ; j++){
                if(!novelList.contains(entityList.get(j))) {
                    Recommendation recommendation = new Recommendation();
                    recommendation.setNovel(entityList.get(j));
                    recommendation.setScore(valueList.get(i) * entityList.get(j).getNovelClickNum());
                    recommendationList.add(recommendation);
                }else{
                    duplicate++;
                }
            }
        }
        Long total = Long.valueOf(recommendationList.size());
        Long totalPage = Long.valueOf(recommendationList.size()/size)+1;
        List<Recommendation> items = new ArrayList<>();
        for(int i = page*size; i < ((page+1)*size < recommendationList.size() ? (page+1)*size : recommendationList.size()) ; i++){
            items.add(recommendationList.get(i));
        }
        PageResult<Recommendation> result = new PageResult<Recommendation>(total,totalPage,items);
        return result;
    }

    @PostMapping("/beenCollected")
    public MyResult recommendation(@RequestBody Collection collection){
        //更新收藏状态
        MyResult result = new MyResult();
        CollectionEntity entity = repository.findByUseridAndNovelid(collection.getUserid(),collection.getNovelid());
        if(entity == null){
            result.setCode(1);
            return  result;
        }
        result.setCode(0);
        return result;
    }

    @PostMapping("/cancelCollect")
    public MyResult cancelCollect(@RequestBody Collection collection){
        //取消收藏
        MyResult result = new MyResult();
        CollectionEntity entity = repository.findByUseridAndNovelid(collection.getUserid(),collection.getNovelid());
        repository.delete(entity);
        result.setCode(0);
        result.setMsg("取消收藏成功！");
        return result;
    }
}

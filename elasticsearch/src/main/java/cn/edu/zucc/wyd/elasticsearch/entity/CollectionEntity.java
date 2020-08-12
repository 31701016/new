package cn.edu.zucc.wyd.elasticsearch.entity;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name="collection")
public class CollectionEntity {
    private int collectionid;
    private int userid;
    private int novelid;

    @Id
    @Column(name = "collection_id")
    public int getCollectionid() {
        return collectionid;
    }

    public void setCollectionid(int collectionid) {
        this.collectionid = collectionid;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "novel_id")
    public int getNovelid() {
        return novelid;
    }

    public void setNovelid(int novelid) {
        this.novelid = novelid;
    }
}

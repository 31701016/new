package cn.edu.zucc.wyd.elasticsearch.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


@Data
@Document(indexName = "novelscat", type = "docs", shards = 1, replicas = 0)
public class Novels {

    @Id
    private int novelid;
    private String novelName;
    private String novelAuthor;
    private String novelType;
    private int novelClickNum;
    private String novelSize;
    private String novelFileType;
    private String novelUpdateTime;
    private String novelStatus;
    private String novelRunEnvir;
    private String novelLastChapter;
    private String novelImgUrl;
    private String novelDownloadUrl;
    private String novelIntroduction;

    public int getNovelid() {
        return novelid;
    }

    public void setNovelid(int novelid) {
        this.novelid = novelid;
    }

    public String getNovelName() {
        return novelName;
    }

    public void setNovelName(String novelName) {
        this.novelName = novelName;
    }

    public String getNovelAuthor() {
        return novelAuthor;
    }

    public void setNovelAuthor(String novelAuthor) {
        this.novelAuthor = novelAuthor;
    }

    public String getNovelType() {
        return novelType;
    }

    public void setNovelType(String novelType) {
        this.novelType = novelType;
    }

    public int getNovelClickNum() {
        return novelClickNum;
    }

    public void setNovelClickNum(int novelClickNum) {
        this.novelClickNum = novelClickNum;
    }

    public String getNovelSize() {
        return novelSize;
    }

    public void setNovelSize(String novelSize) {
        this.novelSize = novelSize;
    }

    public String getNovelFileType() {
        return novelFileType;
    }

    public void setNovelFileType(String novelFileType) {
        this.novelFileType = novelFileType;
    }

    public String getNovelUpdateTime() {
        return novelUpdateTime;
    }

    public void setNovelUpdateTime(String novelUpdateTime) {
        this.novelUpdateTime = novelUpdateTime;
    }

    public String getNovelStatus() {
        return novelStatus;
    }

    public void setNovelStatus(String novelStatus) {
        this.novelStatus = novelStatus;
    }

    public String getNovelRunEnvir() {
        return novelRunEnvir;
    }

    public void setNovelRunEnvir(String novelRunEnvir) {
        this.novelRunEnvir = novelRunEnvir;
    }

    public String getNovelLastChapter() {
        return novelLastChapter;
    }

    public void setNovelLastChapter(String novelLastChapter) {
        this.novelLastChapter = novelLastChapter;
    }

    public String getNovelImgUrl() {
        return novelImgUrl;
    }

    public void setNovelImgUrl(String novelImgUrl) {
        this.novelImgUrl = novelImgUrl;
    }

    public String getNovelDownloadUrl() {
        return novelDownloadUrl;
    }

    public void setNovelDownloadUrl(String novelDownloadUrl) {
        this.novelDownloadUrl = novelDownloadUrl;
    }

    public String getNovelIntroduction() {
        return novelIntroduction;
    }

    public void setNovelIntroduction(String novelIntroduction) {
        this.novelIntroduction = novelIntroduction;
    }
}

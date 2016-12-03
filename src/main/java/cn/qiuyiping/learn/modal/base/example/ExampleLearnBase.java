package cn.qiuyiping.learn.modal.base.example;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2016/11/2.
 */
@Entity
@Table(name = "examplelearn")
public class ExampleLearnBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    //id

    private Long chapterId;    //章节

//    private Long exampleId;    //范例

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "exampleId",insertable=true,unique=true)
    private ExampleBase example;

    private Date createTime;    //创建时间

    private Date updateTime;    //更新时间

    private byte deleted;   //是否删除，1为未删除，可展示，0为已删除，不在前端中展示

    public ExampleLearnBase() {
    }

    public ExampleLearnBase(Long id,Long chapterId, ExampleBase example, Date createTime, Date updateTime, byte deleted) {
        this.id = id;
        this.chapterId = chapterId;
        this.example = example;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deleted = deleted;
    }

    public ExampleLearnBase(Long id,Long chapterId,  Date createTime, Date updateTime, byte deleted) {
        this.id = id;
        this.chapterId = chapterId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deleted = deleted;
    }

    public ExampleLearnBase(Long id,Long chapterId, Date createTime, Date updateTime, byte deleted, Long exampleId, String title, String content, String translation) {
        this.id = id;
        this.chapterId = chapterId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deleted = deleted;
        this.example = new ExampleBase(exampleId, title, content, translation);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChapterId() {
        return chapterId;
    }

    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
    }

//    public Long getExampleId() {
//        return exampleId;
//    }
//
//    public void setExampleId(Long exampleId) {
//        this.exampleId = exampleId;
//    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public byte getDeleted() {
        return deleted;
    }

    public void setDeleted(byte deleted) {
        this.deleted = deleted;
    }

    public ExampleBase getExample() {
        return example;
    }

    public void setExample(ExampleBase example) {
        this.example = example;
    }
}

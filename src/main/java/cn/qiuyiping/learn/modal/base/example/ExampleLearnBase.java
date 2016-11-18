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

    private Long exampleId;    //范例

    private Date createTime;    //创建时间

    private Date updateTime;    //更新时间

    private byte deleted;   //是否删除，1为未删除，可展示，0为已删除，不在前端中展示

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

    public Long getExampleId() {
        return exampleId;
    }

    public void setExampleId(Long exampleId) {
        this.exampleId = exampleId;
    }

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
}

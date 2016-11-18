package cn.qiuyiping.learn.modal.base.example;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2016/11/2.
 */
@Entity
@Table(name = "note")
public class NoteBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    //笔记Id

    private Long exampleLearnBaseId;    //笔记对应的范例学习Id

    private String content; //笔记内容

    private Date createTime;    //创建时间

    private Date updateTime;    //更新时间

    private byte deleted;   //是否删除，1为未删除，可展示，0为已删除，不在前端中展示

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Long getExampleLearnBaseId() {
        return exampleLearnBaseId;
    }

    public void setExampleLearnBaseId(Long exampleLearnBaseId) {
        this.exampleLearnBaseId = exampleLearnBaseId;
    }
}
